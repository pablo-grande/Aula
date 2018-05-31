#include "ficheros.h"

/*Escribe el contenido de un buffer (buf_original dado por parámetro) en un fichero o directorio (inodo pasado por argumento)
 * offset: posicion inicial de escritura con respeccto al inodo (bytes)
 * nbytes: nº de bytes a escribir
 * devuelve la cantidad de bytes escritos (si es que ha escrito bytes)
 */
int mi_write_f(unsigned int ninodo, const void *buf_original, unsigned int offset, unsigned int nbytes) {
    struct superbloque sbloq;
    struct inodo inode;
    inode = leer_inodo(ninodo);
    unsigned int bfisico; //Para el uso de la función traducir_bloque_inodo
    unsigned int bytes_escritos;
    unsigned char buf_bloque[BLOCKSIZE];
    memset(buf_bloque, 0, BLOCKSIZE);

    if ((inode.permisos & 2) != 2) { //Si no tenemos permisos de escritura devolvemos un error
        printf("ERROR: ficheros.c => mi_write => No se tienen permisos de escritura\n");
        return -1;
    } else { //en caso contrario, escribimos el buffer en la posición indicada	

        //primer bloque lógico a escribir
        int primerBlogico = offset / BLOCKSIZE;
        //último bloque lógico a escribir
        int ultimoBlogico = (offset + nbytes - 1) / BLOCKSIZE;

        //desplazamientos
        int desp1 = offset % BLOCKSIZE; //despl. en el primer bloque
        int desp2 = (offset + nbytes - 1) % BLOCKSIZE; //despl. en el último bloque

        //caso 1
        if (primerBlogico == ultimoBlogico) {

            /*	Hacemos un bread de este bloque (con ayuda de la función traducir_bloque_inodo) 
             * y almacenamos el resultado en un buffer llamado buf_bloque.
             */

            if (traducir_bloque_inodo(ninodo, primerBlogico, &bfisico, 1) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => Error al traducir el bloque lógico %d\n", primerBlogico);
                return -1;
            }

            if (bread(bfisico, buf_bloque) == -1) {//leemos el bloque en el que vamos a escribir
                printf("ERROR:	ficheros.c -> mi_write_f => Error al leer el bloque físico %d\n", bfisico);
                if (bread(posSB, (char *) &sbloq) == -1) printf("\tficheros.c -> mi_write_f => Error al leer el superbloque \n");
                else if (sbloq.totBloques < bfisico) printf("\tficheros.c -> mi_write_f => bfisico fuera de rango\n");
                return -1;
            }

            //Escribimos el contenido de 'buf_original' en la posición correspondiente del buffer
            memcpy(buf_bloque + desp1, buf_original, nbytes);

            /*Hacemos un bwrite del buf_bloque (con los nuevos datos, preservando los que contenía), 
             * en el bloque que nos devuelva la función y guardamos la cantidad de bytes escritos
             */
            if (bwrite(bfisico, buf_bloque) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => (Caso 1) Error al escribir el bloque %d \n", bfisico);
            }

            bytes_escritos = nbytes; //devolvemos la cantidad de bytes escritos

        } else { //caso 2: primerByteLogico != ultimoByteLogico

            /////tratamiento del primer bloque lógico
            /*	Hacemos un bread de este bloque (con ayuda de la función traducir_bloque_inodo) 
             * y almacenamos el resultado en un buffer llamado buf_bloque.
             */

            if (traducir_bloque_inodo(ninodo, primerBlogico, &bfisico, 1) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => Error al traducir el bloque lógico %d\n", primerBlogico);
                return -1;
            }

            if (bread(bfisico, buf_bloque) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => (Tratamiento PBL) Error al leer el bloque %d\n", bfisico);
                return -1;
            }

            memcpy(buf_bloque + desp1, buf_original, BLOCKSIZE - desp1);

            /*Hacemos un bwrite del buf_bloque (con los nuevos datos, preservando los que contenía), 
             * en el bloque que nos devuelva la función
             */

            bytes_escritos = BLOCKSIZE - desp1; //primeros bytes escritos

            if (bwrite(bfisico, buf_bloque) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => (Tratamiento PBL) Error al escribir el bloque %d \n", bfisico);
            }

            //tratamiento de los bloques intermedios     
            int i;
            for (i = primerBlogico + 1; i < ultimoBlogico; i++) {
                if (traducir_bloque_inodo(ninodo, i, &bfisico, 1) == -1) {
                    printf("ERROR: ficheros.c -> mi_write_f => Error al traducir el bloque lógico %d\n", i);
                    return -1;
                }
                //buf_bloque = buf_original + (BLOCKSIZE - desp1) + (i - primerBlogico - 1) * BLOCKSIZE;		  
                int var = bwrite(bfisico, buf_original + (BLOCKSIZE - desp1) + (i - primerBlogico - 1) * BLOCKSIZE); //bytes escritos en el bloque intermedio actual
                if (var != BLOCKSIZE) {//comprobamos si se ha escrito el bloque al completo
                    printf("ERROR: ficheros.c -> mi_write_f => (Tratamiento bloques intermedios) No se ha escrito el bloque %d al completo\n", bfisico);
                }
                bytes_escritos = bytes_escritos + var; //sumamos los bytes escritos en este bloque intermedio
            }

            //tratamiento del último bloque
            if (traducir_bloque_inodo(ninodo, ultimoBlogico, &bfisico, 1) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => Error al traducir el bloque lógico %d\n", ultimoBlogico);
                return -1;
            }

            if (bread(bfisico, buf_bloque) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => (Tratamiento UBL) Error al leer el bloque %d \n", bfisico);
                return -1;
            }

            memcpy(buf_bloque, buf_original + (nbytes - desp2 - 1), desp2 + 1);

            if (bwrite(bfisico, buf_bloque) == -1) {
                printf("ERROR: ficheros.c -> mi_write_f => (Tratamiento UBL) Error al escribir el bloque %d \n", bfisico);
            }

            bytes_escritos = bytes_escritos + desp2 + 1;
        }

        //Finalmente y en todo caso:

        //Leemos el inodo
        inode = leer_inodo(ninodo);

        //Actualizar el tamaño en bytes lógicos si hemos escrito más allá del final del fichero
        if (inode.tamEnBytesLog < offset + bytes_escritos) {//En el caso de que tengamos que aumentar el tamaño del fichero
            inode.tamEnBytesLog = offset + bytes_escritos; //actualizamos el tamaño de bytes lógicos de la metainformación
        }

        //actualizar mtime y el ctime
        inode.ctime = time(NULL);
        inode.mtime = time(NULL);

        //Escribir el inodo
        if (escribir_inodo(inode, ninodo) == -1) {
            printf("ERROR: ficheros.c -> mi_write_f => Error al escribir inodo %d \n", ninodo);
            return -1;
        }
    }
    return bytes_escritos; //si todo va bien bytes_escritos=nbytes
}

//Igual que mi_write_f, solamente que en vez de escribir lee. También devuelve el nº de bytes leidos (en este caso)

int mi_read_f(unsigned int ninodo, void *buf_original, unsigned int offset, unsigned int nbytes) {
    struct inodo inode;
    inode = leer_inodo(ninodo);
    unsigned int bfisico; //Para el uso de la función traducir_bloque_inodo
    unsigned int bytes_leidos = 0;
    unsigned int desp_buffer = 0; //bytes_leidos sin contar los bloques vacíos

    unsigned char buf_bloque[BLOCKSIZE];
    memset(buf_bloque, 0, BLOCKSIZE);


    if ((inode.permisos & 4) != 4) { //Si no tenemos permisos de lectura devolvemos un error
        printf("ERROR: ficheros.c => mi_read_f => No se tienen permisos de lectura\n");
        return -1;
    } else { //en caso contrario, leemos el buffer en la posición indicada

        if (offset + nbytes >= inode.tamEnBytesLog) {
            nbytes = inode.tamEnBytesLog - offset; // leemos sólo los bytes que podemos desde el offset hasta el final de fichero
        }

        if (offset > inode.tamEnBytesLog) {
            nbytes = 0;
            return nbytes; //no leemos nada
        }

        int primerBlogico = offset / BLOCKSIZE; //primer byte lógico a leer	
        int ultimoBlogico = (offset + nbytes - 1) / BLOCKSIZE; //último byte lógico a leer

        //desplazamientos
        int desp1 = offset % BLOCKSIZE; //despl. en el primer bloque
        int desp2 = (offset + nbytes - 1) % BLOCKSIZE; //despl. en el último bloque

        //caso 1
        if (primerBlogico == ultimoBlogico) {

            int resultado_traducir = traducir_bloque_inodo(ninodo, primerBlogico, &bfisico, 0);

            if (resultado_traducir == -1) {
                printf("ERROR: ficheros.c -> mi_read_f => Error al traducir el bloque lógico %d\n", primerBlogico);
                return -1;
            }

            if (resultado_traducir == -2) {//bloque lógico vacío
                bytes_leidos = nbytes; //lo indicamos como leído pero no pasamos nada al buffer de salida
            } else {//sino leemos y pasamos el contenido al buffer
                if (bread(bfisico, buf_bloque) == -1) {
                    printf("ERROR: ficheros.c -> mi_read_f => Error al leer el bloque %d\n", bfisico);
                    return -1;
                }
                memcpy(buf_original, buf_bloque + desp1, nbytes); //copiamos el contenido en el buffer de salida	
                bytes_leidos = nbytes;
            }

        } else { //caso 2 primerBloqueLogico != ultimoBloqueLogico

            //tratamiento del primer bloque lógico

            int resultado_traducir = traducir_bloque_inodo(ninodo, primerBlogico, &bfisico, 0);
            if (resultado_traducir == -1) {
                printf("ERROR: ficheros.c -> mi_read_f => Error al traducir el bloque lógico %d\n", primerBlogico);
                return -1;
            }

            if (resultado_traducir == -2) {//bloque lógico vacío    
                bytes_leidos = BLOCKSIZE - desp1; //lo indicamos como leído pero no pasamos nada al buffer de salida ni desplazamos el puntero
            } else {//leemos el primer bloque		
                if (bread(bfisico, buf_bloque) == -1) {
                    printf("ERROR: ficheros.c -> mi_read_f => (Tratamiento PBL) Error al leer el bloque %d\n", bfisico);
                    return -1;
                }
                memcpy(buf_original, buf_bloque + desp1, BLOCKSIZE - desp1); //guardamos los bytes leídos en el buffer de salida
                bytes_leidos = BLOCKSIZE - desp1; //guardamos la cantidad de bytes leidos
                desp_buffer = bytes_leidos; //posición del puntero de buf_original
            }

            //tratamiento de los bloques intermedios
            int i;
            for (i = primerBlogico + 1; i < ultimoBlogico; i++) {
                int resultado_traducir = traducir_bloque_inodo(ninodo, primerBlogico, &bfisico, 0);
                if (resultado_traducir == -1) {
                    printf("ERROR: ficheros.c -> mi_read_f => Error al traducir el bloque lógico intermedio %d\n", i);
                    return -1;
                }

                if (resultado_traducir == -2) {//bloque lógico vacío
                    bytes_leidos = bytes_leidos + BLOCKSIZE; //lo indicamos como leído pero no pasamos nada al buffer de salida ni desplazamos el puntero
                } else {//leemos el bloque		
                    if (bread(bfisico, buf_bloque) == -1) {
                        printf("ERROR: ficheros.c -> mi_read_f => (Tratamiento bloques intermedios) Error al leer el bloque %d\n", bfisico);
                        return -1;
                    }
                    memcpy(buf_original + desp_buffer, buf_bloque, BLOCKSIZE); //guardamos los bytes leídos en el buffer de salida
                    bytes_leidos = bytes_leidos + BLOCKSIZE; //guardamos la cantidad de bytes leidos
                    desp_buffer = desp_buffer + BLOCKSIZE; //actualizamos la posición del puntero de buf_original
                }
            }

            //tratamiento del último bloque

            resultado_traducir = traducir_bloque_inodo(ninodo, ultimoBlogico, &bfisico, 0);
            if (resultado_traducir == -1) {
                printf("ERROR: ficheros.c -> mi_read_f => Error al traducir el bloque lógico %d\n", ultimoBlogico);
                return -1;
            }

            if (resultado_traducir == -2) {//bloque lógico vacío
                bytes_leidos = desp2 + 1; //lo indicamos como leído pero no pasamos nada al buffer de salida ni desplazamos el puntero
            } else {//leemos el primer bloque		
                if (bread(bfisico, buf_bloque) == -1) {
                    printf("ERROR: ficheros.c -> mi_read_f => (Tratamiento PBL) Error al leer el bloque %d\n", bfisico);
                    return -1;
                }
                memcpy(buf_original, buf_bloque, desp2 + 1); //guardamos los bytes leídos en el buffer de salida
                bytes_leidos = bytes_leidos + desp2 + 1; //guardamos la cantidad de bytes leidos
            }

        }
        //Finalmente y en todo caso:

        //Leemos el inodo
        inode = leer_inodo(ninodo);

        //actualizar sellos de tiempo
        inode.ctime = time(NULL);
        inode.mtime = time(NULL);
        inode.atime = time(NULL);

        //Escribir el inodo
        if (escribir_inodo(inode, ninodo) == -1) {
            printf("ERROR: ficheros.c -> mi_read_f => Error al escribir inodo %d \n", ninodo);
            return -1;
        }
    }
    return bytes_leidos;
}

//Devuelve la información de un fichero/directorio (ninodo) pasado por argumento

int mi_stat_f(unsigned int ninodo, struct STAT *p_stat) {
    struct inodo inode;
    inode = leer_inodo(ninodo);

    p_stat -> tipo = inode.tipo; //Tipo (libre, directorio o fichero)
    p_stat -> permisos = inode.permisos; //Permisos (lectura y/o escritura y/o ejecución)
    p_stat -> atime = inode.atime; //Fecha y hora del último acceso a datos: atime
    p_stat -> mtime = inode.mtime; //Fecha y hora de la última modificación de datos: mtime
    p_stat -> ctime = inode.ctime; //Fecha y hora de la última modificación del inodo: ctime
    p_stat -> nlinks = inode.nlinks; //Cantidad de enlaces de entradas en directorio
    p_stat -> tamEnBytesLog = inode.tamEnBytesLog; //Tamaño en bytes lógicos
    p_stat -> numBloquesOcupados = inode.numBloquesOcupados; //Cantidad de bloques ocupados en la zona de datos

    return 0;
}

/*Trunca (corta) un fichero/directorio (ninodo) pasado por argumento a los bytes (nbytes) pasados por argumento, liberando los bloques que no hagan falta
 * si nbytes = 0 lo liberamos TODO
 */
int mi_truncar_f(unsigned int ninodo, unsigned int nbytes) {
    struct inodo inode;

    inode = leer_inodo(ninodo);
    if ((inode.permisos & 2) != 2) { //Si no tenemos permisos de lectura devolvemos un error
        return -1;
    }

    if (nbytes == 0) {//liberamos todo el inodo		
        liberar_inodo(ninodo);
    } else {
        //liberamos a partir del bloque correspondiente del nbyte

        if (liberar_bloques_inodo(ninodo, nbytes) < 0) {
            printf("ERROR: ficheros_basic.c -> (metodo) -> descripcion error.\n");
            return -1;
        }

    }

    //actualizamos el inodo
    inode.mtime = time(NULL);
    inode.ctime = time(NULL);
    inode.tamEnBytesLog = nbytes;

    escribir_inodo(inode, ninodo); //guardamos el inodo

    mi_signalSem();
    return 0;
}

//Cambia los permisos de un inodo (ninodo) pasado por argumento

int mi_chmod_f(unsigned int ninodo, unsigned char modo) {
    struct inodo inode;
    inode = leer_inodo(ninodo);
    inode.permisos = modo;
    inode.ctime = time(NULL);
    escribir_inodo(inode, ninodo);

    return 1;
}
