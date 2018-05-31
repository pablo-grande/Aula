#include "ficheros_basico.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    printf("\n\n\nInicio ejecución leer_sf \n");

    if (argc != 2) {
        printf("ERROR: leer_sf => main: Faltan argumentos!!! El número permitido de argumentos son 2. \n");
        return -1;
    } else {
        if (bmount(argv[1]) == -1) {//abrimos el sistema de ficheros
            printf("ERROR: leer_sf => main: No se puede abrir el sistema que se quiere leer: %s \n", argv[1]);
            return -1;
        }
        //mostramos la información del sistema de ficheros
        leerSB(); //mostramos por pantalla la información del superbloque
        leerMB(); //mostramos por pantalla el contenido del mapa de bits
        leerAI(); //mostramos por pantalla la información de los inodos

        if (bumount() == -1) {//desmontamos el sistema de ficheros
            printf("ERROR: leer_sf => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
            return -1;
        }
    }
    return 1;
}
