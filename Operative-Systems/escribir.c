#include "ficheros.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    printf("\n\n\n\n\n\nInicio ejecución 'escribir.c' \n\n");

    if (argc != 2) {
        printf("ERROR: escribir.c => main: Faltan argumentos!!! El número permitido de argumentos son 2. \n");
        return -1;
    } else {
        if (bmount(argv[1]) == -1) {//abrimos el sistema de ficheros
            printf("ERROR: escribir.c => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return -1;
        }
        printf("El nombre del Sistema de Ficheros es: %s \n", argv[1]);
        char *string = "Esto es una prueba";

        unsigned int ninodo = reservar_inodo('f', 6);
        mi_write_f(ninodo, string, 71680000, strlen(string)); //punteros indirectos 2

        //leemos lo que hemos escrito
        unsigned char leido[BLOCKSIZE];
        mi_read_f(ninodo, leido, 71680000, strlen(string));
        printf("Contenido leido:\n");
        write(1, leido, strlen(string));
        printf("\n");

        if (bumount() == -1) {//desmontamos el sistema de ficheros
            printf("ERROR: escribir.c => main =>Error al cerrar(bumount) el sistema de ficheros.\n");
            return -1;
        }
    }

    return 1;
}
