#include "ficheros_basico.h"
#include <limits.h>
const static int cubo = 256 * 256 * 256;
const static int cuadrado = 256 * 256;

/*Calcula el tamaño de bloques necesarios para el mapa de bits
 * devuelve el tamaño (en bloques)del mapa de bits.
 */
int tamMB(unsigned int nbloques) {
    int tamBitMap = nbloques / (BLOCKSIZE * 8); //~> NUMERO_DE_BITS / BITS_DE_BLOQUE ~> equivale a: (nbloques/8)/BLOCKSIZE
    int aux = nbloques % (BLOCKSIZE * 8);
    if (aux != 0) { //si el tamaño del MP no ocupa un número exacto de bloques se redondea al alza (se añade otro)
        tamBitMap++;
    }
    return tamBitMap;
}

/*Calcula el tamaño de bloques del array de inodos y devuelve el numero de bloques necesarios.
 */
int tamAI(unsigned int ninodos) {
    int tamArrayInodos = (ninodos * T_INODO) / BLOCKSIZE; // [(numero inodos* tamaño inodo) / tamaño bloque] {tamaño de inodo y bloque EN BYTES}
    int aux = (ninodos * T_INODO) % BLOCKSIZE;
    if (aux != 0) {//si el tamaño del AI no ocupa un número exacto de bloques se redondea al alza (se añade otro)
        tamArrayInodos++;
    }
    return tamArrayInodos;
}

//Inicializa el superbloque

int initSB(unsigned int nbloques, unsigned int ninodos) {
    struct superbloque sbloq;

    //inicializamos la estructura siguiendo los apuntes
    sbloq.posPrimerBloqueMB = posSB + 1;
    sbloq.posUltimoBloqueMB = sbloq.posPrimerBloqueMB + tamMB(nbloques) - 1;
    sbloq.posPrimerBloqueAI = sbloq.posUltimoBloqueMB + 1;
    sbloq.posUltimoBloqueAI = sbloq.posPrimerBloqueAI + tamAI(ninodos);
    sbloq.posPrimerBloqueDatos = sbloq.posUltimoBloqueAI + 1;
    sbloq.posUltimoBloqueDatos = nbloques - 1;
    sbloq.posInodoRaiz = 0;
    sbloq.posPrimerInodoLibre = 1;
    sbloq.cantBloquesLibres = nbloques; //#Inicializacion distinta
    sbloq.cantInodosLibres = ninodos - 1;
    sbloq.totBloques = nbloques; // Se pasará como argumento de línea de comandos al inicializar el sistema  $ ./mi_mkfs <nombre_fichero> <cantidad_bloques>
    sbloq.totInodos = ninodos; // (nbloques/4)

    bwrite(posSB, &sbloq); //guardamos el superbloque
    return 1;
}

/*Inicializa a 0 todos los bits del mapa de bits
 */
int initMB(unsigned int nbloques) {
    struct superbloque sbloq;
    unsigned char buff[BLOCKSIZE]; //declaramos el array del tamaño de un bloque

    memset(buff, 0, BLOCKSIZE); //rellenamos el array con ceros (0)

    //leemos el superbloque para saber donde está el mapa de bits
    if (bread(posSB, (char *) &sbloq) == -1) { //#Aquí no usa (char*)
        printf("ERROR: ficheros_basico.c -> initMB => Error al leer el superbloque \n");
        return -1;
    }

    int i;
    unsigned int bloques_libres = sbloq.cantBloquesLibres; //variable donde leemos y modificamos la cantidad de bloques libres
    //marcamos como ocupado todos los bloques desde el superbloque hasta el final del array de inodos (todos menos los bloques de datos)
    for (i = 0; i <= sbloq.posUltimoBloqueAI; i++) { //#Este bucle lo hace antes del anterior
        escribir_bit(i, 1);
        bloques_libres--;
    }

    sbloq.cantBloquesLibres = bloques_libres; //actualizamos la cantidad de bloques libres
    bwrite(posSB, &sbloq); //guardamos el superbloque

    return 1;
}

/*Enlaza todos los inodos entre si
 * Define una zona de memoria (array de inodos del tamaño de un bloque) que se va rellenando con la lista enlazada de inodos libres
 * Su contenido se escribe en el bloque correspondiente medianta bwrite
 */
int initAI(unsigned int ninodos) {
    struct superbloque sbloq;
    struct inodo inode;

    //leemos el superbloque para saber donde está el array de inodos
    if (bread(0, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> initAI => Error al leer el superbloque \n");
        return-1;
    }

    int i, j;

    int inodosBloque = BLOCKSIZE / T_INODO; //inodos que caben en un bloque
    struct inodo array[inodosBloque]; //array de inodos de tamaño=cantidad de inodos que caben en un bloque

    //int inodosUltimoBloque = BLOCKSIZE%T_INODO; //inodos que hay en el ultimo bloque del array de inodos
    int numInodo = 0;

    //rellenamos cada bloque del array de inodos
    for (i = sbloq.posPrimerBloqueAI; i <= sbloq.posUltimoBloqueAI; i++) {
        for (j = 0; j < inodosBloque; j++) {
            inode.atime = time(NULL);
            inode.mtime = time(NULL);
            inode.ctime = time(NULL);
            inode.nlinks = 0;
            if (numInodo == 0) {//es el directorio raiz(ocupado)
                inode.tipo = 'd'; //directorio
                inode.permisos = 7;
            } else if (numInodo < ninodos - 1) {//inodo intermedio(libre)
                inode.tipo = 'l'; //libre
                inode.punterosDirectos[0] = numInodo + 1; //enlazamos al siguiente inodo
            } else if (numInodo == ninodos - 1) {//ultimo inodo
                inode.tipo = 'l'; //libre
                inode.punterosDirectos[0] = UINT_MAX; //como es el último enlazamos a NULL(usando un número muy grande)
            }
            if (numInodo <= ninodos - 1) {//comprobamos si el inodo existe
                array[j] = inode; //copiamos el inodo en la posición correspondiente del array
                numInodo = numInodo + 1;
            }
        }
        //escribimos el bloque de inodos en la posición correspondiente del array de inodos
        if (bwrite(i, array) == -1) {
            printf("ERROR: ficheros_basico.c => initAI => No se ha podido inicializar el bloque %i del array de inodos\n", i);
            return -1;
        }
    }

    return 1;
}

void leerSB() {
    struct superbloque sbloq;
    //leemos el superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> leerSB => Error al leer el superbloque \n");
    }

    //imprimimos por pantalla la información del superbloque
    printf("\n\n---------- Información SUPERBLOQUE ----------\n");
    printf("Número del primer bloque del mapa de bits: %d\n", sbloq.posPrimerBloqueMB);
    printf("Número del último bloque del mapa de bits: %d\n", sbloq.posUltimoBloqueMB);
    printf("Número del primer bloque del array de inodos: %d\n", sbloq.posPrimerBloqueAI);
    printf("Número del último bloque del array de inodos: %d\n", sbloq.posUltimoBloqueAI);
    printf("Número del primer bloque de datos: %d\n", sbloq.posPrimerBloqueDatos);
    printf("Número del último bloque de datos: %d\n", sbloq.posUltimoBloqueDatos);
    printf("Número del inodo del directorio raiz: %d\n", sbloq.posInodoRaiz);
    printf("Número del primer inodo libre: %d\n", sbloq.posPrimerInodoLibre);
    printf("Número de bloques libres: %d\n", sbloq.cantBloquesLibres);
    printf("Número de inodos libres: %d\n", sbloq.cantInodosLibres);
    printf("Cantidad total de bloques: %d\n", sbloq.totBloques);
    printf("Cantidad total de inodos: %d\n", sbloq.totInodos);
    printf("------------------------------------------------\n");
}

/*Funcion auxiliar de leer_sf
 * LeerMB muestra por pantalla el contenido del mapa de bits
 */
void leerMB() {
    //leemos el superbloque
    struct superbloque sbloq;
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c => leerMB => Error al leer el superbloque \n");
    }

    unsigned char buff[BLOCKSIZE];
    memset(buff, 0, BLOCKSIZE);

    int i;
    //imprimimos por pantalla el contenido del mapa de bits
    printf("\n\n---------- Contenido del mapa de bits ----------\n");
    for (i = 0; i <= sbloq.posUltimoBloqueDatos; i++) {
        if (i == posSB) {
            printf("\nSuperbloque:\n%i", leer_bit(i));
        } else if (i == sbloq.posPrimerBloqueMB) {
            printf("\nMapa de bits:\n%i", leer_bit(i));
        } else if (i == sbloq.posPrimerBloqueAI) {
            printf("\nArray de inodos:\n%i", leer_bit(i));
        } else if (i == sbloq.posPrimerBloqueDatos) {
            printf("\nBloques de datos:\n%i", leer_bit(i));
        } else {
            //lee el bit correspondiente y lo imprime
            printf("%i", leer_bit(i));
        }
    }
    //printf("\n\nBloques leídos: %i\n",i);
    printf("\n----------------------------------------------\n\n");
}

/*Funcion auxiliar de leer_sf
 * LeerAI muestra por pantalla el contenido del array de inodos
 */
void leerAI() {
    struct superbloque sbloq;
    struct inodo inode;
    //leemos el superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c => leerAI => Error al leer el superbloque \n");
    }

    struct tm *ts;
    char atime[80];
    char mtime[80];
    char ctime[80];

    unsigned int i;
    printf("\n\n---------- Información array inodos (solo ficheros)----------\n");
    for (i = 0; i < sbloq.totInodos; i++) {
        inode = leer_inodo(i); //leemos el inodo
        if (inode.tipo == 'f') { //si es de tipo fichero
            ts = localtime(&inode.atime);
            strftime(atime, sizeof (atime), "%a %Y-%m-%d %H:%M:%S", ts);
            ts = localtime(&inode.mtime);
            strftime(mtime, sizeof (mtime), "%a %Y-%m-%d %H:%M:%S", ts);
            ts = localtime(&inode.ctime);
            strftime(ctime, sizeof (ctime), "%a %Y-%m-%d %H:%M:%S", ts);
            printf("ID: %d TIPO: %c ATIME: %s MTIME: %s CTIME: %s\n", i, inode.tipo, atime, mtime, ctime);
        }
    }
    printf("\n--------------------------------------------------------------\n");
}

// ETAPA 3 ---------------------------------------------------------------------------------------------

/*Escribe 0 (en caso de libre) o 1 (En caso de ocupado) en un bit del mapa de bits
 * modifica el mapa de bits en un bloque determinado mediante un buffer
 */
int escribir_bit(unsigned int nbloque, unsigned int bit) {
    struct superbloque sbloq;

    //leemos el superbloque para saber donde está el mapa de bits
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_bit => Error al leer el superbloque \n");
        return-1;
    }
    unsigned int posMB = sbloq.posPrimerBloqueMB;
    unsigned int posByte = nbloque / 8;
    unsigned int posBit = nbloque % 8;
    unsigned int bloqueMB = posByte / BLOCKSIZE;
    unsigned int bloque = bloqueMB + posMB;
    unsigned int posByteAjustado = posByte % BLOCKSIZE;

    unsigned char bufferMB[BLOCKSIZE];

    //leemos el bloque del MB en el que se encuentra el bit que tenemos que modificar
    if (bread(bloque, (char *) &bufferMB) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_bit => Error al leer el bloque del mapa de bits en la posición %i\n", (posSB + bloqueMB));
        return-1;
    }

    unsigned char mascara = 128; // 1000 0000
    mascara >>= posBit; //desplazamiento de bits a la derecha

    if (bit == 1) {//escribimos un '1' (ocupado)
        bufferMB[posByteAjustado] |= mascara; // operador OR para bits
    } else if (bit == 0) {//escribimos un '0' (libre)
        bufferMB[posByteAjustado] &= ~mascara; // AND y NOT para bits
    } else {//error: solo se puede escribir '1' o '0'
        printf("ERROR: ficheros_basico.c -> escribir_bit => El segundo parámetro solo puede valer '1'(ocupado) o '0'(libre)\n");
        return -1;
    }

    //escribimos el bloque del mapa de bits que ha sido modificado
    bwrite(bloque, bufferMB);

    return 1;
}

/*Hace lo mismo que escribir_bit, pero en vez de eescribir, lee el bit correspondiente utilizando el desplazamiento
 * devuelve la máscara modificada con el valor leido en un bloque del mapa de bits
 */
unsigned char leer_bit(unsigned int nbloque) {

    struct superbloque sbloq;

    //leemos el superbloque para saber donde está el mapa de bits
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_bit => Error al leer el superbloque \n");
        return-1;
    }

    unsigned char mascara = 128; //10000000
    unsigned int posMB = sbloq.posPrimerBloqueMB;
    unsigned int posByte = nbloque / 8;
    unsigned int posBit = nbloque % 8;
    unsigned int bloqueMB = posByte / BLOCKSIZE;
    unsigned int bloque = bloqueMB + posMB;
    unsigned int posByteAjustado = posByte % BLOCKSIZE;

    unsigned char bufferMB[BLOCKSIZE];

    //leemos el bloque del MB en el que se encuentra el bit que tenemos que modificar
    if (bread(bloque, (char *) &bufferMB) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_bit => Error al leer el bloque del mapa de bits en la posición %i\n", (posSB + bloqueMB));
        return-1;
    }

    mascara >>= posBit; //desplazamiento de bits a la derecha
    mascara &= bufferMB[posByteAjustado]; //operador AND para bits
    mascara >>= (7 - posBit); //desplazamiento de bits a la derecha
    return mascara;
}

//Encuenta el primer bloque libre del mapa de bits, lo ocupa y devuelve el nº de bloque que hemos reservado

int reservar_bloque() {
    struct superbloque sbloq;
    //Leemos la estructura de superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> reservar_bloque => Error al leer el superbloque \n");
        return-1;
    }
    //~
    if (sbloq.cantBloquesLibres > 0) { //si existe algún bloque libre

        //busqueda con leer bit
        int i = sbloq.posPrimerBloqueDatos;
        while (i < sbloq.totBloques && leer_bit(i) == 1) i++;
        int numBloque = i;
        escribir_bit(numBloque, 1);
        sbloq.cantBloquesLibres--;
        bwrite(posSB, &sbloq); //guardamos el superbloque
        return numBloque;

    } else {
        printf("ERROR: ficheros_basico.c -> reservar_bloque => No quedan bloques libres!!");
        return -1; //no hay bytes libres.
    }
}

/*Pone a 0 el bloque correspondiente en el mapa de bits
 * si no ha habido errores, devuelve el mismo bloque
 */
int liberar_bloque(unsigned int nbloque) { //liberar un bloque corresponde a poner a 0 su bit correspondiente en el mapa de bits (puede quedar basura pero lo interpretamos como espacio libre)
    struct superbloque sbloq;

    //Leemos la estructura de superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> reservar_bloque => Error al leer el superbloque \n");
        return-1;
    }
    sbloq.cantBloquesLibres++; // actualizamos cantidad de bloques libres
    escribir_bit(nbloque, 0); //marcamos el bloque como libre
    bwrite(posSB, &sbloq); //guardamos el superbloque

    return nbloque; //devolvemos el bloque liberado
}


//Escribe el contenido del inodo (pasado por parámetro) en un determinado inodo (pasado por parámetro) en el array de inodos

int escribir_inodo(struct inodo inode, unsigned int ninodo) {
    struct superbloque sbloq;
    int cant_inodos = BLOCKSIZE / T_INODO; //inodos que caben en un bloque
    int posAI = ninodo / cant_inodos; //nº de bloque del array de inodos en el que se escribirá
    int pos_enBloq = ninodo % cant_inodos; // posición del bloque en el que se escribirá
    struct inodo array[cant_inodos]; //array de inodos de tamaño=cantidad de inodos que caben en un bloque

    inode.mtime = time(NULL); //actualizacion fecha y hora de modificación de datos
    inode.ctime = time(NULL); //actualizacion fecha y hora de modificación de inodo

    //leemos el superbloque para saber donde empieza el array de inodos
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_inodo => Error al leer el superbloque \n");
        return-1;
    }

    //leemos el bloque en el que se encuentra el inodo
    if (bread(sbloq.posPrimerBloqueAI + posAI, array) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_inodo => Error al leer el array de inodos \n");
        return -1;
    }

    //escribimos el inodo en la posición correspondiente del bloque
    array[pos_enBloq] = inode;

    //escribimos el bloque modificado en el array de inodos
    if (bwrite(sbloq.posPrimerBloqueAI + posAI, array) == -1) {
        printf("ERROR: ficheros_basico.c -> escribir_inodo => Error al escribir en el array de inodos \n");
        return -1;
    }

    return 1;
}

/*Lee un inodo (pasado por parámetro) del array de inodos
 * devuelve la información leida en una variable tipo inodo
 */
struct inodo leer_inodo(unsigned int ninodo) {

    struct superbloque sbloq;

    //leemos el superbloque para saber donde empieza el array de inodos
    if (bread(posSB, (unsigned char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> leer_inodo => Error al leer el superbloque \n");
    }

    int cant_inodos = BLOCKSIZE / T_INODO; //inodos que caben en un bloque
    int posAI = ninodo / cant_inodos; //nº de bloque del array de inodos en el que se escribirá
    int pos_enBloq = ninodo % cant_inodos; // posición del bloque en el que se encuentra el inodo
    struct inodo array[cant_inodos]; //array de inodos de tamaño=cantidad de inodos que caben en un bloque

    //leemos el bloque en el que se encuentra el inodo
    if (bread(sbloq.posPrimerBloqueAI + posAI, array) == -1) {
        printf("ERROR: ficheros_basico.c -> leer_inodo => Error al leer el array de inodos \n");
    }

    struct inodo inode = array[pos_enBloq]; //guardamos el inodo que queremos leer
    return inode;
}

//Encuentra el primer inodo libre (nos lo da el superbloque), lo reserva y devuelve el número reservado.

int reservar_inodo(unsigned char tipo, unsigned char permisos) {
    struct superbloque sbloq;
    struct inodo inode;

    //Leemos la estructura de superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> reservar_inodo => Error al leer el superbloque \n");
        return-1;
    }
    //comprobamos si quedan inodos libres
    if (sbloq.cantInodosLibres == 0) {
        printf("ERROR: ficheros_basico.c -> reservar_inodo => No quedan inodos libres \n");
        return-1;
    }

    int inodo_libre = sbloq.posPrimerInodoLibre; //posición del inodo que vamos a reservar
    inode = leer_inodo(inodo_libre); //leemos el inodo que vamos a reservar

    //modificamos el inodo para reservarlo
    inode.tipo = tipo;
    inode.permisos = permisos;
    inode.nlinks = 0;
    inode.tamEnBytesLog = 0;
    inode.atime = time(NULL);
    inode.ctime = time(NULL);
    inode.mtime = time(NULL);

    //actualizamos la posición del primer inodo libre con el siguiente de la lista enlazada
    sbloq.posPrimerInodoLibre = inode.punterosDirectos[0]; //punterosDirectos[0] indica el siguiente de la lista
    sbloq.cantInodosLibres--;

    int i;
    for (i = 0; i < 12; i++) {
        inode.punterosDirectos[i] = 0;
    }
    for (i = 0; i < 3; i++) {
        inode.punterosIndirectos[i] = 0;
    }

    bwrite(posSB, &sbloq); //guardamos el superbloque

    //escribimos el inodo para reservarlo
    escribir_inodo(inode, inodo_libre);

    return inodo_libre;
}

// ETAPA 4 -------------------------------------------------------------------------

/*Dado el bloque lógico de un inodo, calcula el número de bloque físico al que hace referencia
 * Si reservar vale 0, consulta el bloque físico y le asigna a *bfisico su posición. Si no existe, devuelve error
 * Si reservar vale 1, nos devuelve la posición del bloque físico. Si no existe, lo reserva y asigna a *bfisico su posición
 */
int traducir_bloque_inodo(unsigned int ninodo, unsigned int blogico, unsigned int *bfisico, char reservar) {
    struct superbloque sbloq;
    struct inodo inode;
    unsigned int buff[256], buffSegundoNivel[256];
    unsigned int *bloque_fisico;
    unsigned int bpunteros; //numero de bloque de punteros que estamos tratando
    unsigned int aux;
    inode = leer_inodo(ninodo); //leemos el inodo indicado por parámetro
    inode.atime = time(NULL); //actualizamos fecha y hora de acceso a datos

    //Leemos la estructura de superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> traducir_bloque_inodo => Error al leer el superbloque \n");
        return -1;
    }

    if (0 <= blogico && blogico < 12) {//si el bloque se encuentra en los punteros directos(12 por definicion de la practica)
        bloque_fisico = &inode.punterosDirectos[blogico]; //devolvemos la dirección del bloque apuntado por el puntero directo correspondiente
        //si el bloque se encuentra en el puntero indirecto 0
    } else if (12 <= blogico && blogico < 256 + 12) {//punteros indirectos 0
        aux = blogico - 12;
        if (inode.punterosIndirectos[0] == 0) {//no existe el bloque de punteros
            if (reservar == 0) {
                return -2;
            } else {//reservar == 1, reservamos el bloque de punteros
                inode.punterosIndirectos[0] = reservar_bloque();
                inode.numBloquesOcupados++;
                inode.ctime = time(NULL);
            }
        }

        bpunteros = inode.punterosIndirectos[0];
        bread(inode.punterosIndirectos[0], buff); //leemos el bloque de punteros apuntado por el puntero indirecto 0
        bloque_fisico = &buff[aux];

        //si el bloque se encuentra en el puntero indirecto 1
    } else if (256 + 12 <= blogico && blogico < cuadrado + 256 + 12) {//punteros indirectos 1
        unsigned int aux1 = blogico - (256 + 12);
        unsigned int aux2 = aux1 / 256;
        unsigned int aux3 = aux1 % 256;

        if (inode.punterosIndirectos[1] == 0) {//no existe el bloque de punteros
            if (reservar == 0) {
                return -2;

            } else {//reservar == 1, reservamos el bloque de punteros
                inode.punterosIndirectos[1] = reservar_bloque();
                inode.numBloquesOcupados++;
                inode.ctime = time(NULL);
            }
        }
        //leemos el bloque de punteros apuntados por el puntero indirecto 1
        bread(inode.punterosIndirectos[1], buffSegundoNivel);

        if (buffSegundoNivel[aux2] == 0) {//no existe el bloque de punteros
            if (reservar == 0) {
                return -2;

            } else {//reservar == 1, reservamos el bloque de punteros
                buffSegundoNivel[aux2] = reservar_bloque();
                inode.numBloquesOcupados++;
                inode.ctime = time(NULL);
                bwrite(inode.punterosIndirectos[1], buffSegundoNivel); //guardamos el bloque de punteros actualizado
            }
        }
        //leemos el bloque apuntado por el bloque nbloque-264/256
        bread(buffSegundoNivel[aux2], buff);
        bpunteros = buffSegundoNivel[aux2];
        //devolvemos el bloque
        bloque_fisico = &buff[aux3];

        //si el bloque se encuentra en el puntero indirecto 2
    } else if (cuadrado + 256 + 12 <= blogico && blogico < cubo + cuadrado + 256 + 12) {
        //punteros indirectos 2
        unsigned int aux1 = blogico - (cuadrado + 256 + 12);
        unsigned int aux2 = aux1 / cuadrado;
        unsigned int aux3 = aux1 % cuadrado;
        unsigned int aux4 = aux3 / 256;
        unsigned int aux5 = aux3 % 256;
        //El número de nuestro bloque físico se encuentra en el puntero número 'aux5' del bloque apuntado
        //por el puntero número 'aux4' del bloque apuntado por el puntero número 'aux2' del bloque apuntado por
        //el puntero a bloques indirectos 2

        if (inode.punterosIndirectos[2] == 0) {//no existe el bloque de punteros
            if (reservar == 0) {
                return -2;

            } else {//reservar == 1, reservamos el bloque de punteros
                inode.punterosIndirectos[2] = reservar_bloque();
            }
        }
        //leemos el bloque de punteros apuntados por el puntero indirecto 2
        bread(inode.punterosIndirectos[2], buff);

        if (buff[aux2] == 0) {//no existe el bloque de punteros
            if (reservar == 0) {
                return -2;

            } else {//reservar == 1, reservamos el bloque de punteros
                buff[aux2] = reservar_bloque();
                inode.numBloquesOcupados++;
                inode.ctime = time(NULL);
                bwrite(inode.punterosIndirectos[2], buff); //guardamos el bloque de punteros actualizado
            }
        }
        //leemos el bloque apuntado por el bloque nbloque-264/256
        bread(buff[aux2], buffSegundoNivel);

        if (buffSegundoNivel[aux4] == 0) {//no existe el bloque de punteros
            if (reservar == 0) {
                return -2;

            } else {//reservar == 1, reservamos el bloque de punteros
                buffSegundoNivel[aux4] = reservar_bloque();
                inode.numBloquesOcupados++;
                inode.ctime = time(NULL);
                bwrite(buff[aux2], buffSegundoNivel); //guardamos el bloque de punteros actualizado
            }
        }
        //leemos el bloque de punteros
        bread(buffSegundoNivel[aux4], buff);
        bpunteros = buffSegundoNivel[aux4];
        //devolvemos el bloque
        bloque_fisico = &buff[aux5];
    } else {//el bloque lógico que se intenta traducir está fuera del rango de los bloques
        if (blogico < 0) printf("ERROR: ficheros_basico.c ->traducir_bloque_inodo => Bloque lógico %d. No se puede traducir un bloque logico inferior a 0\n", blogico);
        else printf("ERROR: ficheros_basico.c ->traducir_bloque_inodo => Bloque lógico %d. No se puede traducir un bloque logico superior a 16.843.019\n", blogico);
    }

    if (reservar == 0) { //Únicamente consultamos
        if (*bloque_fisico == 0) { //Está vacío
            return -2;

        } else {//existe bloque fisico
            *bfisico = *bloque_fisico;
        }
    } else if (reservar == 1) {//consultamos y si no existe bloque fisico lo reservamos
        if (*bloque_fisico != 0) {//existe bloque fisico
            *bfisico = *bloque_fisico; //asigna el bloque fisico (OPCIONAL)
            return *bloque_fisico; //devuelve el bloque fisico
        } else {//no existe
            *bloque_fisico = reservar_bloque(); //reservamos bloque en la posición del 'blogico' del inodo (modifica el inodo)
            inode.numBloquesOcupados++; //contabilizamos el bloque que se ha reservado
            inode.ctime = time(NULL); //actualizamos fecha y hora de modificación de inodo
            escribir_inodo(inode, ninodo); //guardamos el inodo con los cambios

            if (blogico >= 12) {
                bwrite(bpunteros, buff); //guardamos el bloque de punteros con el nuevo bloque reservado
            }
            *bfisico = *bloque_fisico; //asignamos a *bfisico el bloque reservado
        }
    } else {//El valor reservar adquiere un valor diferente de 1 o 0, esto no es posible.
        printf("ERROR: ficheros_basico.c ->traducir_bloque_inodo => El parámetro 'reservar' tiene que ser 0 o 1\n");
        return -1;
    }
    return 1;
}

//Libera el nº de inodo pasado por parámetro y actualiza el superbloque y el inodo liberado.

int liberar_inodo(unsigned int ninodo) {
    struct superbloque sbloq;
    struct inodo inode;
    //Leemos la estructura de superbloque
    if (bread(posSB, (char *) &sbloq) == -1) {
        printf("ERROR: ficheros_basico.c -> liberar_inodo => Error al leer el superbloque \n");
        return-1;
    }
    liberar_bloques_inodo(ninodo, 0); //liberamos los bloques del inodo
    inode = leer_inodo(ninodo); //leemos el inodo indicado por parámetro
    inode.tipo = 'l';
    inode.ctime = time(NULL); //actualizamos fecha y hora de modificación de inodo
    inode.punterosDirectos[0] = sbloq.posPrimerInodoLibre; //lo ponemos al inicio de la lista de inodos libres
    sbloq.posPrimerInodoLibre = ninodo; //actualizamos la posición del primer inodo libre
    sbloq.cantInodosLibres++;

    escribir_inodo(inode, ninodo); //guardamos el inodo con los cambios

    bwrite(posSB, &sbloq); //guardamos el superbloque

    return 1;
}

/*Libera hasta el último bloque lógico del fichero a partir del bloque lógico (pasado por argumento)
 * actualiza la cantidad de inodos libres y guarda el inodo
 */
int liberar_bloques_inodo(unsigned int ninodo, unsigned int blogico) {
    struct superbloque sbloq;
    struct inodo inode;
    inode = leer_inodo(ninodo); //leemos el inodo indicado por parámetro
    unsigned int ultimo_blogico = inode.tamEnBytesLog / BLOCKSIZE;
    unsigned int bloques_ocupados = inode.numBloquesOcupados;
    unsigned int buffer[256];
    unsigned int buffSegundoNivel[256];
    unsigned int buffTercerNivel[256];
    unsigned int bufferAux[256];
    memset(bufferAux, 0, 256);

    int i;
    for (i = blogico; i <= ultimo_blogico; i++) {
        if (0 <= i && i < 12 && inode.punterosDirectos[i] != 0) {//punteros directos (y ocupados)
            liberar_bloque(inode.punterosDirectos[i]); //liberamos el bloque
            inode.punterosDirectos[i] = 0; //marcamos el puntero del inodo como libre
            bloques_ocupados--;
        } else if (12 <= i && i < 256 + 12) {//punteros indirectos 0
            if (inode.punterosIndirectos[0] == 0) {//no tiene asignado bloque de punteros => no hay bloques que liberar en este nivel
                i = 256 + 12; //pasamos al siguiente nivel
            } else {//hay bloques pendientes de liberar en el nivel de punteros indirectos 0
                bread(inode.punterosIndirectos[0], buffer); //leemos el bloque de punteros apuntado por el puntero indirecto 0
                unsigned int aux = i - 12; //posicion en el bloque de punteros
                if (buffer[aux] != 0) { //quiere decir que está ocupado, lo liberamos
                    liberar_bloque(buffer[aux]); //liberamos el bloque
                    buffer[aux] = 0; //marcamos el puntero del inodo como libre
                    bloques_ocupados--;
                    if (memcmp(bufferAux, buffer, sizeof (sbloq)) == 0) {//se han liberado todos los bloques del bloque de punteros
                        liberar_bloque(inode.punterosIndirectos[0]); //liberamos el bloque de punteros
                        inode.punterosIndirectos[0] = 0; //marcamos el puntero como libre
                        bloques_ocupados--;
                        i = 256 + 12; //pasamos al siguiente nivel
                    }
                }
            }
        } else if (256 + 12 <= i && i < cuadrado + 256 + 12) {//punteros indirectos 1
            unsigned int aux1 = i - (256 + 12);
            unsigned int aux2 = aux1 / 256;
            unsigned int aux3 = aux1 % 256;

            if (inode.punterosIndirectos[1] == 0) {//no tiene asignado bloque de punteros indirectos 1 => no hay bloques que liberar en este nivel
                i = cuadrado + 256 + 12; //pasamos al siguiente nivel
            } else {//quedan bloques por liberar
                bread(inode.punterosIndirectos[1], buffer); //leemos el bloque de punteros indirectos 0
                if (buffer[aux2] != 0) {//existe el bloque de punteros
                    bread(buffer[aux2], buffSegundoNivel); //leemos el bloque de punteros
                    if (buffSegundoNivel[aux3] != 0) {//apunta a un bloque de datos
                        liberar_bloque(buffSegundoNivel[aux3]); //liberamos el bloque de datos
                        buffSegundoNivel[aux3] = 0; //marcamos el puntero del inodo como libre
                        bloques_ocupados--;
                        //comprobamos si se han liberado todos los punteros del bloque de punteros
                        if (memcmp(bufferAux, buffSegundoNivel, sizeof (sbloq)) == 0) {//se han liberado todos los bloques del bloque de punteros
                            liberar_bloque(buffer[aux2]); //liberamos el bloque de punteros
                            buffer[aux2] = 0; //marcamos el puntero como libre
                            bloques_ocupados--;
                            //comprobamos si se han liberado todos los bloques de punteros
                            if (memcmp(bufferAux, buffer, sizeof (sbloq)) == 0) {//se han liberado todos los bloques del bloque de punteros indirectos 1
                                liberar_bloque(inode.punterosIndirectos[1]); //liberamos el bloque de punteros
                                inode.punterosIndirectos[1] = 0; //marcamos el puntero como libre
                                bloques_ocupados--;
                                i = cuadrado + 256 + 12; //pasamos al siguiente nivel
                            }
                        }
                    }
                }
            }
        } else if (cuadrado + 256 + 12 <= i && i < cubo + cuadrado + 256 + 12) {//punteros indirectos 2
            unsigned int aux1 = i - (cuadrado + 256 + 12);
            unsigned int aux2 = aux1 / cuadrado;
            unsigned int aux3 = aux1 % cuadrado;
            unsigned int aux4 = aux3 / 256;
            unsigned int aux5 = aux3 % 256;

            if (inode.punterosIndirectos[2] == 0) {//no existe el bloque de punteros
                i = ultimo_blogico + 1; //no quedan más bloques por liberar, salimos del FOR
            } else {
                bread(inode.punterosIndirectos[2], buffer); //leemos el bloque de punteros indirectos 2
                if (buffer[aux2] != 0) {//existe el bloque de punteros
                    bread(buffer[aux2], buffSegundoNivel); //leemos el bloque de punteros indirectos 1
                    if (buffSegundoNivel[aux4] != 0) {//existe el bloque de punteros
                        bread(buffSegundoNivel[aux4], buffTercerNivel); //leemos el bloque de punteros indirectos 0
                        if (buffTercerNivel[aux5] != 0) {//apunta a un bloque de datos
                            liberar_bloque(buffTercerNivel[aux5]); //liberamos el bloque de datos
                            buffTercerNivel[aux5] = 0; //marcamos el puntero como libre
                            bloques_ocupados--;
                            //comprobamos si se han liberado todos los punteros del bloque de punteros
                            if (memcmp(bufferAux, buffTercerNivel, sizeof (sbloq)) == 0) {//se han liberado todos los bloques del bloque de punteros 0
                                liberar_bloque(buffSegundoNivel[aux4]); //liberamos el bloque de punteros
                                buffSegundoNivel[aux4] = 0; //marcamos el puntero como libre
                                bloques_ocupados--;
                                //comprobamos si se han liberado todos los bloques de punteros
                                if (memcmp(bufferAux, buffSegundoNivel, sizeof (sbloq)) == 0) {//se han liberado todos los bloques del bloque de punteros indirectos 1
                                    liberar_bloque(buffer[aux2]); //liberamos el bloque de punteros
                                    buffer[aux2] = 0; //marcamos el puntero como libre
                                    bloques_ocupados--;
                                    //comprobamos si se han liberado todos los bloques de punteros
                                    if (memcmp(bufferAux, buffer, sizeof (sbloq)) == 0) {//se han liberado todos los bloques del bloque de punteros indirectos 2
                                        liberar_bloque(inode.punterosIndirectos[2]); //liberamos el bloque de punteros
                                        inode.punterosIndirectos[2] = 0; //marcamos el puntero como libre
                                        bloques_ocupados--;
                                        i = ultimo_blogico + 1; //no quedan más bloques por liberar, salimos del FOR
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    inode.numBloquesOcupados = bloques_ocupados; //actualizamos los bloques del inodo
    escribir_inodo(inode, ninodo); //guardamos el inodo

    return 1;
}
