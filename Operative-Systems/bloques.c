#include "bloques.h"
#include "semaforo_mutex_posix.h"

static sem_t *mutex;
static int descriptor = 0; //También conocido como el descriptor del fichero

/*Hace el open del fichero que se usará como dispositivo
 * devuelve el descriptor del fichero
 */
int bmount(const char *camino) {
    //Inicializamos el semáforo
    mutex = initSem();
    descriptor = open(camino, O_RDWR | O_CREAT, 0666);

    if (descriptor == -1) { //Este es el caso de error.
        printf("ERROR: bloques.c > bmout > 'El fichero ya existe y no tiene permiso de escritura'.\n");
    }
    return descriptor;
}

/*Hace el close del fichero
 * devuelve 0 si se ha cerrado correctamente, -1 en caso contrario
 */
int bumount() {
    int aux = close(descriptor);
    if (aux == -1) {
        printf("ERROR: bloques.c > bumout > El fichero NO se ha cerrado correctamente.\n");
    }
    //Cerramos el semáforo
    deleteSem();

    return aux;
}

/*Escribe el contenido de un buffer de memoria (pasado como puntero) en el bloque del sistema de ficheros (el otro argumento)
 * devuelve el nº de bytes que ha podido escribir o -1 si ha habido un error
 */
int bwrite(unsigned int bloque, const void *buf) {

    int desplazamiento = bloque * BLOCKSIZE;

    int offset = lseek(descriptor, desplazamiento, SEEK_SET); //Es eldesplazamiento en nº de bytes.
    if (offset == -1) {
        printf("ERROR: bloques.c > bwrite > Error moviendo el puntero al bloque %d\n", bloque);
        return -1;
    }

    int numBytes = write(descriptor, buf, BLOCKSIZE);
    if (numBytes == -1) {
        printf("ERROR: bloques.c > bwrite > No se ha podido escribir.\n");
    }
    return numBytes;
}

/*Copia el contenido de un bloque del sistema de ficheros (pasado por argumento) en un buffer de memoria (puntero pasado por argumento)
 * devuelve   el nº de   bytttes o -1 si ha habido un error
 */
int bread(unsigned int bloque, void *buf) {

    int desplazamiento = bloque * BLOCKSIZE;

    int offset = lseek(descriptor, desplazamiento, SEEK_SET); //Es el desplazamiento en nº de bytes.
    if (offset == -1) {
        printf("ERROR: bloques.c > bread > Error moviendo el puntero al bloque %d\n", bloque);
        return -1;
    }

    int numBytes = read(descriptor, buf, BLOCKSIZE);
    if (numBytes == -1) {
        printf("ERROR: bloques.c > bread > No se ha podido leer.\n");
        return -1;
    }
    return numBytes;
}

void mi_waitSem() {
    waitSem(mutex);
}

void mi_signalSem() {
    signalSem(mutex);
}