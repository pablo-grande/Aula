#include "directorios.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="mi_ls"; nombre del main
      argv[1]=disco(sistema de ficheros)
      argv[2]= /directorio	
     */
    if (argc != 3) {
        printf("ERROR: mi_ls => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return (EXIT_FAILURE);
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: mi_ls => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
        char *buffer = malloc(7000); //char buffer[2000]; //60(tamaño entrada)*101(100 procesos + 1 informe) + extra
        mi_dir(argv[2], buffer); //guardamos el contenido del directorio en el buffer
        printf("%s\n", buffer);

        if (bumount() == -1) {
            printf("ERROR: mi_ls => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
    }
    return (EXIT_SUCCESS);
}
