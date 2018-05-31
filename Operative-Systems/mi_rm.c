#include "directorios.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="mi_rm"; nombre del main
      argv[1]=disco(sistema de ficheros)
      argv[2]= /ruta	
     */
    if (argc != 3) {
        printf("ERROR: mi_rm => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return (EXIT_FAILURE);
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: mi_rm => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }

        char camino[strlen(argv[2])];
        strcpy(camino, argv[2]);

        struct STAT stat_inodo;
        if (mi_stat(argv[2], &stat_inodo) < 0) {
            printf("ERROR: mi_rm => main: Error al leer el inodo.\n");
            return (EXIT_FAILURE);
        }

        if (strcmp(camino, "/") == 0) {
            printf("No se puede borrar el directorio raíz\n");
        } else if ((stat_inodo.tipo == 'd') && (stat_inodo.tamEnBytesLog != 0)) {
            printf("No se puede borrar porque el directorio no está vacío.\n");
        } else {
            mi_unlink(camino);
        }

        if (bumount() == -1) {
            printf("ERROR: mi_ln => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
    }
    return (EXIT_SUCCESS);
}
