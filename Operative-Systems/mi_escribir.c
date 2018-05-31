#include "directorios.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="mi_escribir"; nombre del main
      argv[1]=disco(sistema de ficheros)
      argv[2]= /fichero	
     */
    if (argc != 3) {
        printf("ERROR: mi_escribir => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return (EXIT_FAILURE);
        
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: mi_escribir => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }

        escribir_fichero(argv[1], argv[2]);

        if (bumount() == -1) {
            printf("ERROR: mi_escribir => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
    }

    return (EXIT_SUCCESS);
}
