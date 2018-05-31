#include "directorios.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    /*argc = nº de parámetros
    argv[0]="escribir_fichero"; nombre del main
    argv[1]=disco(sistema de ficheros)
    argv[2]= /fichero	
     */

    if (argc != 3) {
        printf("ERROR: escribir.c => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
        return -1;
    } else {
        if (bmount(argv[1]) == -1) {//abrimos el sistema de ficheros
            printf("ERROR: escribir.c => main: Error al abrir (bmount) el sistema de ficheros.\n");
            return -1;
        }

        char *buffer = "Esto es una prueba";
        unsigned int p_inodo_dir;
        unsigned int p_entrada;
        unsigned int p_inodo;
        char reservar = 1; //escritura
        unsigned char modo = 1; //escritura

        int resultado_busqueda = buscar_entrada(argv[2], &p_inodo_dir, &p_inodo, &p_entrada, reservar, modo);

        if (resultado_busqueda == -1) {
            printf("ERROR: escribir_fichero.c => main=> Error al buscar la entrada");
        } else {
            if (mi_write_f(p_inodo, buffer, 0, sizeof (buffer)) < 0) {
                printf("ERROR: escribir_fichero.c => main=> Error al escribir en el fichero");
            } else {
                //PRUEBA TEMPORAL PARA LEER LO QUE HEMOS ESCRITO
                unsigned char leido[sizeof (buffer)];
                mi_read_f(p_inodo, leido, 0, sizeof (buffer));
                write(1, leido, 19);
            }
        }

        if (bumount() == -1) {//desmontamos el sistema de ficheros
            printf("ERROR: escribir_fichero.c => main =>Error al cerrar(bumount) el sistema de ficheros.\n");
            return -1;
        }
    }

    return 1;
}
