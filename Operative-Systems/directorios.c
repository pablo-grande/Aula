#include "directorios.h"
#include <string.h>
#define TAMMAX_CACHE 10

//~ struct cache ultima_busqueda = {.ruta= "/",.ninodo=0};// cache de directorios inicializada con el directorio raiz
static struct cache cache_array[TAMMAX_CACHE]; //array de cache de directorios
static unsigned int numentradas_cache = 0;
static unsigned int older = 0; //entrada más antigua de la cache

//etapa 7

/*Determina si el path pasado por parámetro (*camino) es un fichero o un directorio
 * en inicial guarda el primer String (hasta que encuentra una barra '/')
 * en final guarda el nombre del fichero (si es se trata de un fichero)
 * devuelve 1 si es un fichero y 0 si es un directorio
 */
int extraer_camino(const char *camino, char *inicial, char *final) {

    int tipo; //0 para directorio; 1 para fichero
    char ruta[strlen(camino)];
    memset(ruta, 0, sizeof (ruta));
    strcpy(ruta, camino);

    char *PrimeraBarra;
    PrimeraBarra = strchr(ruta, '/') + 1; //elimina la primera barra de camino
    char *segundaBarra;
    segundaBarra = strchr(PrimeraBarra, '/'); //conserva todo el string a partir de la segunda barra

    if (segundaBarra == NULL) {// no hay segunda barra, se trata de un fichero
        //guardamos el camino(sin la primera barra) en inicial
        strcpy(inicial, PrimeraBarra);
        *final = '\0';
        tipo = 1; //indicamos que es un fichero		
    } else {//hay segunda barra, se trata de un directorio
        strcpy(final, segundaBarra); //en final devolvemos el resto del camino(incluido la barra)
        strcpy(inicial, strtok(PrimeraBarra, "/")); //guardamos en inicial el trozo que está entre los dos primeros '/'
        tipo = 0; //indicamos que es un directorio
    }
    return tipo;
}

/*
La función buscar_entrada, dada una cadena de caracteres (camino_parcial) y el inodo del
directorio sobre el que se apoya esta cadena (p_inodo_dir), calcula:
 * El número de inodo de su directorio más cercano (p_inodo_dir).
 * Su número de inodo (p_inodo).
 * El número de su entrada dentro del último directorio que lo contiene (p_entrada).
 * La función devuelve 1 si se trata de un fichero y 0 si es un directorio
 */
int buscar_entrada(const char *camino_parcial, unsigned int *p_inodo_dir, unsigned int *p_inodo, unsigned int *p_entrada, char reservar, unsigned char modo) {

    struct inodo inode;
    struct entrada ent;

    if (strcmp(camino_parcial, "/") == 0) {//miramos si es el directorio raiz
        *p_inodo = 0; //la raiz siempre estará asociada al inodo 0
        *p_entrada = 0;
        return 0;
    }

    char inicial [60];
    char final [600];
    memset(inicial, '\0', 60);
    memset(final, '\0', 600);

    int tipo = extraer_camino(camino_parcial, inicial, final); //tipo de inodo extraido    

    if (tipo == -1) {
        printf("ERROR: directorios.c -> buscar_entrada -> Error al extraer camino\n");
        return -1;
    }

    //buscamos la entrada cuyo nombre se encuentra en inicial    
    inode = leer_inodo(*p_inodo_dir);
    memset(ent.nombre, '\0', 60); //ent.nombre[60] = '\0';
    int numentradas = inode.nlinks; //calcular el nº de entradas del inodo    
    unsigned int nentrada = 0; //nº de entrada inicial(indice)

    if (numentradas > 0) {
        ent = leer_entrada(*p_inodo_dir, nentrada);
        if ((inode.permisos & 4) != 4) {//si no hay permisos de lectura
            printf("ERROR: directorios.c => buscar_entrada => No se tienen permisos de lectura\n");
            return -1;
        }

        //~ printf("Búsqueda de la entrada '%s'...\n",inicial);
        while ((nentrada < numentradas) && (strcmp(inicial, ent.nombre) != 0)) {
            nentrada++; //incrementar nentrada;            
            if (nentrada < numentradas) ent = leer_entrada(*p_inodo_dir, nentrada); //leer siguiente entrada;            
        }
    }

    if (nentrada == numentradas) {
        switch (reservar) {
            case 0://devolver ERROR_NO_EXISTE_ENTRADA_CONSULTA;
                printf("ERROR: directorios.c => buscar_entrada => No existe la entrada '%s'\n", inicial);
                return -2;
                break;
            case 1: //modo escritura. Creamos la entrada de directorio en el directorio referenciado por *p_inodo_dir
                strcpy(ent.nombre, inicial); //guardamos el nombre de la nueva entrada
                if (tipo == 0) { //tipo directorio
                    if (strcmp(final, "/") == 0) {
                        ent.ninodo = reservar_inodo('d', modo); //reservar un inodo como directorio y asignarlo a la entrada
                    } else {
                        printf("ERROR: directorios.c => buscar_entrada => No existe el directorio intermedio %s\n", inicial);
                        return -1;
                    }
                } else {//tipo fichero
                    if ((inode.permisos & 2) != 2) { //Si no tenemos permisos de escritura devolvemos un error
                        printf("ERROR: directorios.c => buscar_entrada => No se tienen permisos de escritura\n");
                        return -1;
                    }
                    ent.ninodo = reservar_inodo('f', modo); //reservar un inodo como fichero y asignarlo a la entrada
                }


                //escribimos la entrada en el directorio				
                if (escribir_entrada(*p_inodo_dir, nentrada, ent) == -1) {
                    if (ent.ninodo != -1) {//Si se había reservado un inodo para la entrada
                        liberar_inodo(ent.ninodo);
                    }
                    printf("ERROR: directorios.c => buscar_entrada => No se tienen permisos de escritura\n");
                    return -1;
                }
                
                inode = leer_inodo(*p_inodo_dir);
                inode.nlinks++; //actualizamos el número de entradas de directorio
                escribir_inodo(inode, *p_inodo_dir); //guardamos el inodo
                break;
            default:
                printf("ERROR:  directorios.c => buscar_entrada => parámetro 'reservar' inválido, debe ser '0' o '1'\n");
                break;
        }
    }

    if ((strcmp(final, "/") == 0) || (strcmp(final, "") == 0)) { // hemos llegado al final del camino.
        if ((nentrada < numentradas) && (reservar == 1)) {//modo escritura y la entrada ya existe
            printf("ERROR: directorios.c => buscar_entrada => Entrada '%s' ya existente\n", ent.nombre);
            return -1;
        }
        //cortamos la recursividad
        *p_inodo = ent.ninodo;
        *p_entrada = nentrada;
        return tipo;

    } else {
        *p_inodo_dir = ent.ninodo;
        return buscar_entrada(final, p_inodo_dir, p_inodo, p_entrada, reservar, modo);
    }
    return tipo;
}


//Etapa 8

int mi_creat(const char *camino, unsigned char modo) {
    //Semáforo (hay sección crítica)
    mi_waitSem();
    unsigned int p_inodo_dir = 0;
    unsigned int p_inodo = 0;
    unsigned int p_entrada = 0;
    char reservar = 1;
    char var_camino[strlen(camino)];
    strcpy(var_camino, camino);

    int creat = buscar_entrada(var_camino, &p_inodo_dir, &p_inodo, &p_entrada, reservar, modo);

    if (creat == -1) {
        printf("ERROR: directorios.c -> mi_creat -> No se ha encontrado la entrada %s\n", camino);
        mi_signalSem();
        return -1;
    }
    //Se acabó la sección crítica
    mi_signalSem();
    return creat;
}

int mi_dir(const char *camino, char *buffer) {
    unsigned int p_inodo_dir = 0;
    unsigned int p_inodo = 0;
    unsigned int p_entrada = 0;
    char reservar = 0;
    struct inodo inode;
    int ent;

    ent = buscar_entrada(camino, &p_inodo_dir, &p_inodo, &p_entrada, reservar, 4); //O_RDWR|O_CREAT//este modo??

    if (ent == -1) {
        printf("ERROR: directorios.c => mi_dir => No existe el directorio '%s'\n", camino);
        return -1;
    } else if (ent == 0) {//comprobamos que se trata de un directorio
        inode = leer_inodo(p_inodo);
        int numEntradas = inode.tamEnBytesLog / sizeof (struct entrada); //entradas que tiene el directorio

        if (numEntradas == 0) {//si no hay entradas avisamos de que el directorio está vacío
            strcat(buffer, "<<directorio vacío>>");
        } else {//recorremos las entradas y guardamos si información en el buffer		
            int i;
            for (i = 0; i < numEntradas; i++) {
                struct entrada varEntrada = leer_entrada(p_inodo, i); //leemos la entrada
                struct inodo inodoEntrada = leer_inodo(varEntrada.ninodo); //leemos el inodo de la entrada
                //incorporamos el nombre de la entrada
                strcat(buffer, varEntrada.nombre);
                strcat(buffer, " ");
                //incorporamos informacion acerca de los permisos
                if (inodoEntrada.permisos & 4) strcat(buffer, "r");
                else strcat(buffer, "-");
                if (inodoEntrada.permisos & 2) strcat(buffer, "w");
                else strcat(buffer, "-");
                if (inodoEntrada.permisos & 1) strcat(buffer, "x");
                else strcat(buffer, "-");
                strcat(buffer, " ");
                //incorporamos informacion acerca del tiempo
                struct tm *tm; //ver info: struct tm
                char tmp[100];
                tm = localtime(&inodoEntrada.mtime);
                sprintf(tmp, "%d-%02d-%02d %02d:%02d:%02d\t", tm->tm_year + 1900, tm->tm_mon + 1, tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);
                strcat(buffer, tmp);
                if ((i < (numEntradas - 1)) && (i + 1) % 3 == 0 && i != 0) strcat(buffer, "\n"); //espacio entre entradas	
            }
        }
    } else { //ent !=0; no es un directorio
        printf("'%s' no es un directorio\n", camino);
        return -1;
    }
    return 1;
}

int mi_link(const char *camino1, const char *camino2) {
    //Semáforo (hay sección crítica)
    mi_waitSem();
    unsigned int p_inodo_dir = 0;
    unsigned int p_inodo = 0;
    unsigned int p_entrada = 0;
    struct entrada varEntrada;
    struct inodo inode;
    int ent;

    ent = buscar_entrada(camino1, &p_inodo_dir, &p_inodo, &p_entrada, 0, O_WRONLY);
    if (ent < 0) {
        printf("ERROR: directorios.c => mi_link => Error al buscar la entrada '%s'\n", camino1);
        mi_signalSem();
        return ent;
    }

    int ninodoC1 = p_inodo; //guardamos el ninodo asociado a camino1

    p_inodo_dir = 0;
    p_inodo = 0;
    p_entrada = 0;

    //buscamos la entrada de camino2 y si no existe se crea
    ent = buscar_entrada(camino2, &p_inodo_dir, &p_inodo, &p_entrada, 1, O_CREAT);
    if (ent < 0) {
        printf("ERROR: directorios.c => mi_link => Error al buscar la entrada '%s'\n", camino2);
        mi_signalSem();
        return ent;
    }
    varEntrada = leer_entrada(p_inodo_dir, p_entrada); //leemos la entrada que se ha creado
    liberar_inodo(varEntrada.ninodo); //liberamos el inodo asociado a la entrada
    varEntrada.ninodo = ninodoC1; //asociamos a esta entrada el inodo asociado a la entrada del camino1
    escribir_entrada(p_inodo_dir, p_entrada, varEntrada); //escribimos la entrada modificada
    inode = leer_inodo(ninodoC1); //Leemos el inodo asociado a la entrada camino1
    inode.nlinks++; //incrementamos la cantidad de enlaces del inodo
    inode.ctime = time(NULL);
    escribir_inodo(inode, ninodoC1);

    mi_signalSem();
    return 1;
}

int mi_unlink(const char *camino) {
    //semáforo (habrá sección crítica)
    mi_waitSem();
    unsigned int p_inodo_dir = 0;
    unsigned int p_inodo = 0;
    unsigned int p_entrada = 0;
    char reservar = 0;
    struct inodo inode;
    struct entrada varEntrada, entrada_eliminada;

    int ent = buscar_entrada(camino, &p_inodo_dir, &p_inodo, &p_entrada, reservar, 4); //este modo??

    if (ent == -1) {
        printf("ERROR: directorios.c => mi_dir => No existe el directorio\n");
        mi_signalSem();
        return -1;
    } else {
        inode = leer_inodo(p_inodo_dir);
        unsigned int numEntradas = inode.tamEnBytesLog / sizeof (struct entrada);

        entrada_eliminada = leer_entrada(p_inodo_dir, p_entrada); //leemos la entrada que queremos eliminar
        if (p_entrada == numEntradas - 1) {// se trata de la última entrada
            mi_truncar_f(p_inodo_dir, (inode.tamEnBytesLog - sizeof (struct entrada))); //truncamos en la posición de la última entrada
        } else {
            varEntrada = leer_entrada(p_inodo_dir, (numEntradas - 1)); //leemos la última entrada
            escribir_entrada(p_inodo_dir, p_entrada, varEntrada); //escribimos la última entrada en la posición de la entrada que queremos eliminar
            mi_truncar_f(p_inodo_dir, (inode.tamEnBytesLog - sizeof (struct entrada))); //truncamos en la posición de la última entrada
        }

        inode = leer_inodo(p_inodo_dir);
        inode.nlinks--; //decremenatamos en el número de enlaces del directorio en el que se encuentra la entrada
        escribir_inodo(inode, p_inodo_dir);

        struct inodo inodo_entrada = leer_inodo(entrada_eliminada.ninodo); //Leemos el inodo asociado a la entrada eliminada		
        inodo_entrada.nlinks--; //decrementamos el número de enlaces del inodo asociado a la entrada		
        if (inodo_entrada.nlinks == 0) {//si no quedan enlaces liberamos el inodo
            if (liberar_inodo(entrada_eliminada.ninodo) < 0) {
                printf("ERROR: directorios.c -> mi_unlink -> Error al liberar el inodo.\n");
                mi_signalSem();
                return -1;
            }
        } else {//quedan enlaces
            inodo_entrada.ctime = time(NULL); //actualizacion fecha y hora de modificación de inodo
            escribir_inodo(inodo_entrada, entrada_eliminada.ninodo); //guardamos el inodo
        }
    }

    mi_signalSem();
    return 1;
}


//funcion auxiliar para leer una entrada
struct entrada leer_entrada(unsigned int ninodo, unsigned int nentrada) {
    struct entrada entrada_leida; //variable donde guardaremos la entrada
    unsigned int offset = nentrada * sizeof (struct entrada); //desplazamiento hasta la posición de la entrada		
    mi_read_f(ninodo, &entrada_leida, offset, sizeof (struct entrada)); //leemos la entrada

    return entrada_leida;
}

//funcion auxiliar para escribir una entrada

unsigned int escribir_entrada(unsigned int ninodo, unsigned int nentrada, struct entrada varEntrada) {
    unsigned int offset = nentrada * sizeof (struct entrada); //desplazamiento hasta la posición de la entrada
    unsigned int resultado = mi_write_f(ninodo, &varEntrada, offset, sizeof (struct entrada)); //leemos la entrada

    return resultado;
}

//Etapa 9
int mi_chmod(const char *camino, unsigned char modo) {
    unsigned int p_inodo_dir = 0;
    unsigned int p_entrada = 0;
    unsigned int p_inodo = 0;

    if (buscar_entrada(camino, &p_inodo_dir, &p_inodo, &p_entrada, 0, modo) == -1) {
        printf("ERROR: directorios.c -> mi_chmod -> No existe la entrada especificada.\n");
        return -1;
    } else {//Existe la entrada
        if (mi_chmod_f(p_inodo, modo) == -1) {
            printf("ERROR: directorios.c -> mi_chmod -> Erro al cambiar los permisos del inodo.\n");
            return -1;
        }
    }
    return 1;
}

int mi_stat(const char *camino, struct STAT *p_stat) {
    
    unsigned int p_inodo_dir = 0;
    unsigned int p_entrada = 0;
    unsigned int p_inodo = 0;

    int busqueda_cache = buscar_entrada_cache(camino); //buscamos la entrada en la cache
    if (busqueda_cache == -1) {//si la entrada no está en la cache
        //buscamos la entrada
        if (buscar_entrada(camino, &p_inodo_dir, &p_inodo, &p_entrada, 0, 4) == -1) {
            printf("ERROR: directorios.c -> mi_stat -> No existe la entrada %s\n", camino);
            return -1;
        } else {
            if (guardar_entrada_cache(camino, p_inodo) == -1) {
                printf("ERROR: directorios.c -> mi_stat -> error al guardar la entrada %s en la cache\n", camino);
                return -1;
            }
        }
    } else {//la entrada está en cache
        p_inodo = busqueda_cache; //asignamos el inodo
    }

    if (mi_stat_f(p_inodo, p_stat) == -1) {
        printf("ERROR: directorios.c -> mi_stat -> Error al obtener la información del inodo.\n");
        return -1;
    }
    return 1;
}

int mi_read(const char *camino, void *buf, unsigned int offset, unsigned int nbytes) {

    unsigned int p_inodo_dir = 0;
    unsigned int p_entrada = 0;
    unsigned int p_inodo = 0;
    int bytes_leidos = 0;

    int busqueda_cache = buscar_entrada_cache(camino); //buscamos la entrada en la cache
    if (busqueda_cache == -1) {//si la entrada no está en la cache
        //buscamos la entrada
        if (buscar_entrada(camino, &p_inodo_dir, &p_inodo, &p_entrada, 0, 4) == -1) {
            printf("ERROR: directorios.c -> mi_read -> No existe la entrada %s\n", camino);
            return -1;
        } else {
            if (guardar_entrada_cache(camino, p_inodo) == -1) {
                printf("ERROR: directorios.c -> mi_read -> error al guardar la entrada %s en la cache\n", camino);
                return -1;
            }
        }
    } else {//la entrada está en cache
        p_inodo = busqueda_cache; //asignamos el inodo
    }

    //Existe la entrada
    bytes_leidos = mi_read_f(p_inodo, buf, offset, nbytes);
    if (bytes_leidos == -1) {
        printf("ERROR: directorios.c -> mi_read -> Error al leer el inodo %d\n", p_inodo);
        return -1;
    }
    return bytes_leidos;
}

int mi_write(const char *camino, const void *buf, unsigned int offset, unsigned int nbytes) {
    //Semáforo (hay sección crítica)
    mi_waitSem();
    unsigned int p_inodo_dir = 0;
    unsigned int p_entrada = 0;
    unsigned int p_inodo = 0;
    int bytes_escritos = 0;
    char buffer[strlen(buf)];
    memset(buffer, 0, strlen(buffer));
    strcpy(buffer, buf);

    int busqueda_cache = buscar_entrada_cache(camino); //buscamos la entrada en la cache
    if (busqueda_cache == -1) {//si la entrada no está en la cache
        //buscamos la entrada
        if (buscar_entrada(camino, &p_inodo_dir, &p_inodo, &p_entrada, 0, 4) < 0) {
            printf("ERROR: directorios.c -> mi_write -> No existe la entrada %s\n", camino);
            mi_signalSem();
            return -1;
        } else {//si la busqueda ha funcionado guardamos la entrada en la cache
            if (guardar_entrada_cache(camino, p_inodo) == -1) {
                printf("ERROR: directorios.c -> mi_write -> error al guardar la entrada %s en la cache\n", camino);
                mi_signalSem();
                return -1;
            }
        }
    } else {//la entrada está en cache
        p_inodo = busqueda_cache; //asignamos el inodo
    }

    //Existe la entrada
    bytes_escritos = mi_write_f(p_inodo, buf, offset, nbytes);
    if (bytes_escritos == -1) {
        printf("ERROR: directorios.c -> mi_write -> Error al escribir el inodo %d\n", p_inodo);
        mi_signalSem();
        return -1;
    }
    
    mi_signalSem();
    return bytes_escritos;
}

/*devuelve -1 si no está en cache o el número de inodo si está en la cache*/
int buscar_entrada_cache(const char *camino) {
    int i = 0;
    while ((i < numentradas_cache) && (strcmp(camino, cache_array[i].ruta) != 0)) {
        i++;
    }
    if (i < numentradas_cache) {//está en cache
        return cache_array[i].ninodo;
    } else {//no está en cache
        return -1;
    }
}

/* devuelve -1 si hay algún error y 1 si todo va bien*/
int guardar_entrada_cache(const char *camino, unsigned int ninodo) {
    //si la cache no está llena
    if (numentradas_cache < TAMMAX_CACHE) {
        //guardamos la entrada
        strcpy(cache_array[numentradas_cache].ruta, camino);
        cache_array[numentradas_cache].ninodo = ninodo;
        numentradas_cache++;
    } else {//la cache está llena (numentradas_cache==TAMMAX_CACHE)
        //sustituimos la entrada mas antigua por la nueva
        strcpy(cache_array[older].ruta, camino);
        cache_array[older].ninodo = ninodo;
        //indicamos cual es la nueva entrada más antigua de la cache
        older = (older + 1) % TAMMAX_CACHE;
    }
    return 1;
}
