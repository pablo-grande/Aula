#include "directorios.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="mi_ln"; nombre del main
      argv[1]=disco(sistema de ficheros)
      argv[2]= fichero
      argv[3]= enlace
     */
    if (argc != 4) {
        printf("ERROR: mi_ln => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return (EXIT_FAILURE);
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: mi_ln => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }

        mi_link(argv[2], argv[3]); //creamos un link entre el fichero y la entrada que viene dada por el enlace

        if (bumount() == -1) {
            printf("ERROR: mi_ln => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }

    }

    return (EXIT_SUCCESS);
}
