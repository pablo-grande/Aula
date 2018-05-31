#include "ficheros.h"
#include <time.h>

struct entrada {
    char nombre[60]; //En el sistema de ficheros ext2 la longitud del nombre es 255
    unsigned int ninodo;
};

struct cache {
    char ruta[1024];
    unsigned int ninodo;
};

int extraer_camino(const char *camino, char *inicial, char *final);
int buscar_entrada(const char *camino_parcial, unsigned int *p_inodo_dir, unsigned int *p_inodo, unsigned int *p_entrada, char reservar, unsigned char modo);
int mi_creat(const char *camino, unsigned char modo);
int mi_dir(const char *camino, char *buffer);
int mi_link(const char *camino1, const char *camino2);
int mi_unlink(const char *camino);
int mi_chmod(const char *camino, unsigned char modo);
int mi_stat(const char *camino, struct STAT *p_stat);
int mi_read(const char *camino, void *buf, unsigned int offset, unsigned int nbytes);
int mi_write(const char *camino, const void *buf, unsigned int offset, unsigned int nbytes);

//funciones auxiliares
struct entrada leer_entrada(unsigned int ninodo, unsigned int nentrada);
unsigned int escribir_entrada(unsigned int ninodo, unsigned int nentrada, struct entrada varEntrada);
int guardar_entrada_cache(const char *camino, unsigned int ninodo);
int eliminar_entrada_cache(const char *camino);
int buscar_entrada_cache(const char *camino);
