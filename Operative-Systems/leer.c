#include "ficheros.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char **argv) {
    if (argc != 3) {
        printf("ERROR: leer.c => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return -1;
    } else {
        unsigned int ninodo = atoi(argv[2]);
        if (bmount(argv[1]) == -1) {//abrimos el sistema de ficheros
            printf("ERROR: leer.c => main: Error al abrir el sistema de ficheros.\n");
            return -1;
        }

        struct inodo inode = leer_inodo(ninodo);
        int cont = inode.tamEnBytesLog; //cont = número de bytes.
        unsigned char buffer[BLOCKSIZE * 4]; //declaramos un buffer de 4 bloques
        int offset = 0;

        while (mi_read_f(atoi(argv[1]), buffer, offset, sizeof (buffer)) > 0) {
            if (cont >= sizeof (buffer)) {
                write(1, buffer, sizeof (buffer));
                cont = cont - sizeof (buffer);
            } else {
                write(1, buffer, cont - 1);
            }
            offset += sizeof (buffer);
        }

        if (bumount() == -1) {//desmontamos el sistema de ficheros
            printf("ERROR: leer.c => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return -1;
        }
    }
    return 1;
}
