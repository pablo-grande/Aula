#Este makefile hace uso de los targets para ir compilando los archivos.

all: mi_mkfs escribir escribir_fichero leer leer_sf mi_mkdir mi_chmod mi_ls mi_stat mi_cat mi_ln mi_rm simulacion

mi_mkfs: mi_mkfs.o semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o
		gcc -pthread -o mi_mkfs bloques.o ficheros_basico.o ficheros.o mi_mkfs.o directorios.o semaforo_mutex_posix.o -g

mi_mkfs.o: mi_mkfs.c
		gcc -c mi_mkfs.c -g

bloques.o:  bloques.c bloques.h
		gcc -c bloques.c -g

ficheros_basico.o: ficheros_basico.c ficheros_basico.h
		gcc -c ficheros_basico.c -g

ficheros.o: ficheros.c ficheros.h
		gcc -c ficheros.c -g

directorios.o: directorios.c directorios.h
		gcc -c directorios.c -g

semaforo_mutex_posix.o: semaforo_mutex_posix.c semaforo_mutex_posix.h
		gcc -c semaforo_mutex_posix.c -g


##Otros métodos##

#escribir
escribir:  semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o escribir.o
		gcc -pthread -o  escribir semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o escribir.o -g

escribir.o: escribir.c
		gcc -c escribir.c -g

#escribir_fichero
escribir_fichero:  semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o escribir_fichero.o
		gcc -pthread -o  escribir_fichero semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o escribir_fichero.o -g

escribir_fichero.o: escribir_fichero.c
		gcc -c escribir_fichero.c -g

#leer
leer: bloques.o semaforo_mutex_posix.o ficheros_basico.o ficheros.o leer.o
		gcc -pthread -o leer semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o leer.o -g

leer.o: leer.c
		gcc -c leer.c -g

#leer_sf
leer_sf: semaforo_mutex_posix.o bloques.o ficheros_basico.o leer_sf.o 
		gcc -pthread -o leer_sf semaforo_mutex_posix.o bloques.o ficheros_basico.o leer_sf.o  -g

leer_sf.o: leer_sf.c
		gcc -c leer_sf.c -g

#mi_mkdir
mi_mkdir:  semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_mkdir.o
		gcc -pthread -o mi_mkdir semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_mkdir.o -g

mi_mkdir.o: mi_mkdir.c 
		gcc -c mi_mkdir.c -g

#mi_chmod
mi_chmod:  semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_chmod.o
		gcc -pthread -o mi_chmod semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_chmod.o -g

mi_chmod.o: mi_chmod.c
		gcc -c mi_chmod.c -g

#mi_ls
mi_ls: semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_ls.o
		gcc -pthread -o mi_ls semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_ls.o -g

mi_ls.o: mi_ls.c
		gcc -c mi_ls.c -g

#mi_stat
mi_stat:  semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_stat.o
		gcc -pthread -o mi_stat semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_stat.o 

mi_stat.o: mi_stat.c
		gcc -c mi_stat.c -g

#mi_cat
mi_cat: semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_cat.o 
	gcc -pthread -o mi_cat semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_cat.o -g

mi_cat.o: mi_cat.c
	gcc -c mi_cat.c -g

#mi_ln
mi_ln: semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_ln.o
	gcc -pthread -o mi_ln semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_ln.o -g

mi_ln.o: mi_ln.c
	gcc -c mi_ln.c -g

#mi_rm
mi_rm: semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_rm.o
	gcc -pthread -o mi_rm semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o mi_rm.o -g

mi_rm.o: mi_rm.c
	gcc -c mi_rm.c -g

#simulacion
simulacion: semaforo_mutex_posix.o bloques.o bloques.o ficheros_basico.o ficheros.o directorios.o simulacion.o
			gcc -pthread -o simulacion semaforo_mutex_posix.o bloques.o ficheros_basico.o ficheros.o directorios.o simulacion.o -g

simulacion.o: simulacion.c
		gcc -c simulacion.c -g


##Limpieza##

clean:
	rm -f -r *.h.gch *.o mi_mkfs leer_sf leer escribir mi_mkdir mi_rm mi_ln mi_cat mi_stat mi_ls mi_chmod escribir_fichero simulacion
