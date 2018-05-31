#include "directorios.h"
#include <sys/wait.h>
#include <errno.h>
#include <stdio.h>
#include <time.h>

struct registro {
    time_t fecha;
    int pid;
    int nEscritura;
    int posicion;
};

char dir_sim[60];
int escrituras();
int verificacion();
void enterrador();
static unsigned int acabados = 0; //pid=0;
static unsigned int num_procesos = 100;
static unsigned int num_escrituras = 50;
static unsigned int num_verificados = 0;

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="simulacion"; nombre del main
      argv[1]=disco(sistema de ficheros) se ha de llamar disco.imagen
     */
    if (argc != 2) {
        printf("ERROR: simulacion => main: Faltan argumentos!!! El número permitido de argumentos son 2. \n");
        return (EXIT_FAILURE);
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: simulacion => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
        //creamos el directorio de simulación
        struct tm *tm;
        time_t tiempo = time(NULL);
        tm = localtime(&tiempo);
        memset(dir_sim, 0, strlen(dir_sim));
        sprintf(dir_sim, "/simul_%d%02d%02d%02d%02d%02d/",
                tm -> tm_year + 1900,
                tm -> tm_mon + 1,
                tm -> tm_mday,
                tm -> tm_hour,
                tm -> tm_min,
                tm -> tm_sec);

        printf("Creación del directorio de simulacion %s\n", dir_sim);
        //mi_creat (ruta, permisos);
        if (mi_creat(dir_sim, 7) < 0) {
            printf("ERROR: simulacion => main: Error al crear el directorio %s\n", dir_sim);
        } else {
            //Llamamos al enterrador
            signal(SIGCHLD, enterrador);
            //Creamos los 100 procesos de escritura
            int i;
            for (i = 0; i < num_procesos; i++) {
                if (fork() == 0) { //quiere decir que hemos podido crear un proceso hijo					
                    escrituras();
                    exit(0);
                }
                usleep(200);
            }
            printf("Se han creado %d procesos\n", i);

            //Mientras no hayan acabado todos los procesos, pause();
            while (acabados < num_procesos) { //Mientras queden procesos	
                pause();
            }
            //verificamos escrituras
            verificacion();

            if (bumount(argv[1]) == -1) {
                printf("ERROR: simulacion => main: Error al cerrar (bumount) el sistema de ficheros.\n");
                return (EXIT_FAILURE);
            }
        }
    }

    return 0;
}

void enterrador() {
    while (wait3(NULL, WNOHANG, NULL) > 0) acabados++;
}

int escrituras() {
    //declara el directorio del proceso añadiendo su pid al nombre
    char dir_proceso [60];
    memset(dir_proceso, 0, strlen(dir_proceso));
    sprintf(dir_proceso, "%sproceso_%d/", dir_sim, getpid()); 

    printf("\tCreación del directorio del proceso %d\n", getpid());
    //creamos el directorio de proceso
    if (mi_creat(dir_proceso, 7) < 0) {
        printf("ERROR: simulacion => escrituras: Error al crear el directorio %s\n", dir_proceso);
    }

    //declara el fichero del proceso
    char nombre_f [60];
    memset(nombre_f, 0, strlen(nombre_f));
    sprintf(nombre_f, "%sprueba.dat", dir_proceso);

    printf("\t\tCreación del fichero 'prueba.dat' en el proceso %d\n", getpid());
    //creamos el fichero del proceso						
    if (mi_creat(nombre_f, 7) < 0) {
        printf("ERROR: simulacion => escrituras: Error al crear el fichero %s\n", nombre_f);
    }
    
    struct registro reg;
    //actualizar la semilla de numeros aleatorios
    srand(time(NULL) + getpid()); 

    int cubo = 256 * 256 * 256;
    int cuadrado = 256 * 256;
    int posMax = ((((12 + 256 + (cuadrado)+(cubo)) - 1) * BLOCKSIZE) / sizeof (struct registro));

    int j;
    printf("\t\t\tRealización de %d escrituras de registro en %s\n", num_escrituras, nombre_f);
    for (j = 0; j < num_escrituras; j++) {
        //creamos el registro de simulación
        reg.fecha = time(NULL);
        reg.pid = getpid(); //getpid()
        reg.nEscritura = j + 1;
        reg.posicion = rand() % posMax;

        //Escribir el registro con mi_write				
        int bytes_escritos = mi_write(nombre_f, &reg, reg.posicion * sizeof (struct registro), sizeof (struct registro));
        if (bytes_escritos <= 0) {
            printf("ERROR: simulacion => escrituras: Error al escribir el registro %d en la posición %d\n", reg.nEscritura, reg.posicion);
            return -1;
        }
        usleep(50);
    }
    printf("\t\t\tFinalizadas las %d escrituras de registro en el proceso %s\n", num_escrituras, nombre_f);
    return 1;
}

int verificacion() {
    printf("\n--------------------Inicio verificación--------------------------\n");
    struct entrada ent;
    struct STAT stSim, stPrueba;
    struct registro reg, menor_pos, mayor_pos, primera_esc, ultima_esc; // mas_reciente,menos_reciente ;
    int pid, numEntradasSim;
    mi_stat(dir_sim, &stSim); //leemos la informacion del directorio de simulacion

    numEntradasSim = stSim.nlinks; //calculamos las entradas del directorio de simulacion	

    //directorio del proceso
    char d_proc[60];

    //directorio de información del proceso
    char dir_info[60];

    //fichero de información del proceso
    char info_txt[1024];
    char buffer[256];

    //Creamos el fichero de información
    memset(info_txt, 0, strlen(info_txt));
    memset(dir_info, 0, strlen(dir_info));
    sprintf(dir_info, "/informe.txt"); //sprintf(dir_info,"%s/informe.txt",dir_sim);

    //mi_creat (ruta, permisos);
    if (mi_creat(dir_info, 7) < 0) {
        printf("ERROR: simulacion => verificación: Error al crear el directorio %s\n", dir_info);
    }
    
    //para cada entrada del directorio de simulacion
    int k;
    for (k = 0; k < numEntradasSim; k++) {
        mi_read(dir_sim, &ent, k * sizeof (struct entrada), sizeof (struct entrada)); //lee la entrada k del directorio
        memset(d_proc, 0, strlen(d_proc));
        sprintf(d_proc, "%s%s/prueba.dat", dir_sim, ent.nombre);
        pid = atoi(strchr(ent.nombre, '_') + 1); //extraemos el pid
        printf("Verificando %s...\n", ent.nombre);
        //Buscamos el primer registro		
        mi_stat(d_proc, &stPrueba);

        int numRegPrueba = stPrueba.tamEnBytesLog / sizeof (reg); //registros que caben en prueba.dat

        int indiceReg = 0;
        int regValidos = 0;
        int progreso = 0;
        int porcentaje = 0;
        
        //leemos todos los registros de pruebas.dat
        while (indiceReg < numRegPrueba) {
            mi_read(d_proc, &reg, indiceReg * sizeof (struct registro), sizeof (struct registro));
            if (reg.pid == pid) {
                regValidos++;
                if (regValidos == 1) {//como es el primero valido inicializamos todas las variables con este registro
                    memcpy(&primera_esc, &reg, sizeof (reg));
                    memcpy(&ultima_esc, &reg, sizeof (reg));
                    memcpy(&mayor_pos, &reg, sizeof (reg));
                    memcpy(&menor_pos, &reg, sizeof (reg));
                } else {
                    //Comparar la fecha, nº escritura y posición de los registros.
                    if (reg.posicion < menor_pos.posicion) {
                        memcpy(&menor_pos, &reg, sizeof (reg)); //printf("cambiado menor posicion\n");
                    }
                    if (reg.posicion > mayor_pos.posicion) {
                        memcpy(&mayor_pos, &reg, sizeof (reg)); //printf("cambiado mayor posicion\n");
                    }
                    if (reg.nEscritura > ultima_esc.nEscritura) {
                        memcpy(&ultima_esc, &reg, sizeof (reg)); //printf("cambiado ultima escritura\n");
                    }
                    if (reg.nEscritura < primera_esc.nEscritura) {
                        memcpy(&primera_esc, &reg, sizeof (reg)); //printf("cambiado primera escritura\n");
                    }
                }
            }
            indiceReg++;
        }
        printf("%s [VERIFICADO]\n", ent.nombre);
        num_verificados++;
        printf("Se han verificado el %d%% de los procesos\n", num_verificados);

        //Finalmente pasamos a escribir en un fichero de texto (informe.txt)
        info_txt[0] = 0;
        sprintf(buffer, "####### INFORMACIÓN DEL PROCESO %i #######\n\n", pid); //getpid
        strcat(info_txt, buffer);

        sprintf(buffer,
                "%i - Primera escritura:\tfecha: %s\t\t\t\tnúmero de escritura: %i\n\t\t\t\tnúmero de registro: %i\n\n\n",
                primera_esc.pid, asctime(localtime(&primera_esc.fecha)), primera_esc.nEscritura, primera_esc.posicion);
        strcat(info_txt, buffer);

        sprintf(buffer,
                "%i - Última escritura:\tfecha: %s \t\t\t\tnúmero de escritura: %i\n\t\t\t\tnúmero de registro: %i\n\n\n",
                ultima_esc.pid, asctime(localtime(&ultima_esc.fecha)), ultima_esc.nEscritura, ultima_esc.posicion);
        strcat(info_txt, buffer);

        sprintf(buffer,
                "%i - Primera posición:\tfecha: %s \t\t\t\tnúmero de escritura: %i\n\t\t\t\tnúmero de registro: %i\n\n\n",
                menor_pos.pid, asctime(localtime(&menor_pos.fecha)), menor_pos.nEscritura, menor_pos.posicion);
        strcat(info_txt, buffer);

        sprintf(buffer,
                "%i - Última posición:\tfecha: %s \t\t\t\tnúmero de escritura: %i\n\t\t\t\tnúmero de registro: %i\n\n\n",
                mayor_pos.pid, asctime(localtime(&mayor_pos.fecha)), mayor_pos.nEscritura, mayor_pos.posicion);
        strcat(info_txt, buffer);

        mi_stat(dir_info, &stSim);
        mi_write(dir_info, (const void *) info_txt, stSim.tamEnBytesLog, strlen(info_txt) + 1);
    }
    return 1;
}

