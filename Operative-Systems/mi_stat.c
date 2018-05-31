#include "directorios.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
      argv[0]="mi_stat"; nombre del main
      argv[1]=disco(sistema de ficheros)
      argv[2]= /ruta	
     */
    if (argc != 3) {
        printf("ERROR: mi_stat => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return (EXIT_FAILURE);
    } else {
        if (bmount(argv[1]) == -1) {
            printf("ERROR: mi_stat => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }

        struct STAT stat_inodo;
        int res = mi_stat(argv[2], &stat_inodo);
        if (res == -1) {
            printf("ERROR: mi_stat => main: Error al leer el inodo.\n");
            return (EXIT_FAILURE);
        }
        if (res == -2) return 1; //no existe la entrada

        struct tm *ts;
        char atime[80];
        char mtime[80];
        char ctime[80];

        printf("\n---------- Información del inodo ----------\n");
        ts = localtime(&stat_inodo.atime);
        strftime(atime, sizeof (atime), "%a %Y-%m-%d %H:%M:%S", ts);
        ts = localtime(&stat_inodo.mtime);
        strftime(mtime, sizeof (mtime), "%a %Y-%m-%d %H:%M:%S", ts);
        ts = localtime(&stat_inodo.ctime);
        strftime(ctime, sizeof (ctime), "%a %Y-%m-%d %H:%M:%S", ts);
        printf("TIPO: %c\nPERMISOS: %i\nNLINKS: %i \nTAMAÑO: %i bytes\nATIME: %s \nMTIME: %s \nCTIME: %s\n", stat_inodo.tipo, stat_inodo.permisos, stat_inodo.nlinks, stat_inodo.tamEnBytesLog, atime, mtime, ctime);
        printf("\n------------------------------------------\n");

        if (bumount() == -1) {
            printf("ERROR: mi_stat => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return (EXIT_FAILURE);
        }
    }

    return (EXIT_SUCCESS);
}
