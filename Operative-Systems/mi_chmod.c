#include "directorios.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="mi_mkdir"; nombre del main
      argv[1]=disco(sistema de ficheros)
      argv[2]=permisos
      argv[3] = ruta
     */
    if (argc != 4) {
        printf("ERROR: mi_chmod => main: Faltan argumentos!!! El número permitido de argumentos son 4. \n");
        return (EXIT_FAILURE);
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: mi_chmod => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
        int resultado = mi_chmod(argv[3], atoi(argv[2]));
        if (resultado < 0) {
            printf("ERROR: mi_mkdir => main: Error al crear el directorio/fichero.\n");
            return resultado;
        }

        if (bumount() == -1) {
            printf("ERROR: mi_chmod => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
    }
    return (EXIT_SUCCESS);
}
