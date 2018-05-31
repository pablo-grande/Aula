#include "directorios.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv){
	/*argc = nº de parámetros
	  argv[0]="mi_ls"; nombre del main
	  argv[1]=disco(sistema de ficheros)
	  argv[2]= /fichero	
	 */
	if (argc != 3){
        printf("ERROR: mi_cat => main: Faltan argumentos!!! El número permitido de argumentos son 3. \n");
		exit(1);
    }
    
    
	if (bmount(argv[1]) == -1){
		printf("ERROR: mi_cat => main: Error al abrir (bmount) el sistema de ficheros.\n");
		return (EXIT_FAILURE);
	}

	int bytes_leidos;
	char buffer[BLOCKSIZE*4];//declaramos un buffer de 4 bloques
	int offset = 0;	
				
	memset(buffer, 0, sizeof(buffer));
	while ((bytes_leidos=mi_read(argv[2], buffer, offset, sizeof(buffer))) > 0) {
		write(1, buffer, bytes_leidos);
		//~ printf("%d-(1)leido desde la posicion %d hasta la posición %d del fichero\n",cont,offset,(offset+bytes_leidos));
		offset += bytes_leidos;//sizeof(buffer);
		memset(buffer, 0, sizeof(buffer));
	}

		
	if (bumount() == -1){
		printf("ERROR: mi_cat => main =>Error al desmontar(bumount) el sistema de ficheros.\n");
		exit(1);
	}
			
	exit(0);
}
