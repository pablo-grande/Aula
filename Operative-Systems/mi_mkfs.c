#include "bloques.h"
#include "ficheros_basico.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {

    /*argc = nº de parámetros
      argv[0]="mi_mkfs"; nombre del main
      argv[1]=nombre_fichero
      argv[2]=cantidad_bloques (cantidad de bloques del sistema de ficheros)
     */
    char buffer[BLOCKSIZE];
    unsigned int cantidad_bloques = atoi(argv[2]); //bloques del sistema
    unsigned int cantidad_inodos = cantidad_bloques / 4; //inodos del sistema (heurística)        

    if (argc != 3) {
        printf("ERROR: mi_mkfs => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return (EXIT_FAILURE);
    } else {
        if (cantidad_bloques <= 0) {
            printf("ERROR: mi_mkfs => main: Números de bloques incorrectos (menor o igual a 0)\n");
            return (EXIT_FAILURE);
        } else {
            if (bmount(argv[1]) == -1) {
                printf("ERROR: mi_mkfs => main: Error al montar (bmount) el sistema de ficheros.\n");
                return (EXIT_FAILURE);
            }
            printf("El nombre del Sistema de Ficheros es: %s \n", argv[1]);
            memset(buffer, 0, BLOCKSIZE);

            //Inicializamos cada bloque del sistema de ficheros a 0
            int i;
            for (i = 0; i < cantidad_bloques; i++) {
                if (bwrite(i, buffer) == -1) {
                    printf("ERROR: mi_mkfs => main: Error al ejecutar el bwrite para inicializar el bloque del sistema %i\n", i);
                    return (EXIT_FAILURE);
                }
            }

            if (initSB(cantidad_bloques, cantidad_inodos) == -1) {//inicializa el superbloque
                printf("ERROR: mi_mkfs => main: No se ha podido inicializar el superbloque\n");
                return (EXIT_FAILURE);
            }

            if (initMB(cantidad_bloques) == -1) {//inicializa el mapa de bits
                printf("ERROR: mi_mkfs => main: No se ha podido inicializar el mapa de bits\n");
                return (EXIT_FAILURE);
            }

            if (initAI(cantidad_inodos) == -1) {//inicializa el array de inodos
                printf("ERROR: mi_mkfs => main: No se ha podido inicializar el array de inodos\n");
                return (EXIT_FAILURE);
            }

            if (bumount() == -1) {
                printf("ERROR: mi_mkfs => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
                return (EXIT_FAILURE);
            }
        }
    }
    return (EXIT_SUCCESS);
}
