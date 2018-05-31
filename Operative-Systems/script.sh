#script
#!/bin/bash
# $1 --> disco.imagen
# $2 --> directorio de simulacion

#listamos la raiz
echo MI_LS -------------------------------------------
echo 
echo ./mi_ls $1 /
./mi_ls $1 /
echo
#cambiamos permisos al $2 de la simulacion
echo
echo MI_CHMOD -------------------------------------------
echo
echo ./mi_chmod $1 4 $2
./mi_chmod $1 4 $2
echo
#volvemos a listar para ver los permisos del $2 de simulacion
echo
echo MI_LS -------------------------------------------
echo
echo ./mi_ls $1 /
./mi_ls $1 /
echo
#listamos el directorio de simulacion
echo
echo MI_LS -------------------------------------------
echo ./mi_ls $1 $2
./mi_ls $1 $2
echo
#hacemos un mi_cat de informe.txt que ha generado el verificador de la simulacion
echo
echo MI_CAT -------------------------------------------
echo ./mi_cat $1 /informe.txt
./mi_cat $1 /informe.txt
echo
#creamos un enlace dentro del directorio raiz que apunta al informe.txt
echo
echo MI_LN -------------------------------------------
echo ./mi_ln $1 /informe.txt /enlace_informe.txt
./mi_ln $1 /informe.txt /enlace_informe.txt
echo
#hacemos un mi_stat del informe.txt para ver como nlinks ahora vale 1
echo
echo MI_STAT -------------------------------------------
echo ./mi_stat $1 /informe.txt
./mi_stat $1 /informe.txt
echo
#listamos la raiz para ver el enlace creado
echo
echo MI_LS -------------------------------------------
echo ./mi_ls $1 /
./mi_ls $1 /
echo
#borramos el enlace
echo
echo MI_RM -------------------------------------------
echo ./mi_rm $1 /enlace_informe.txt
./mi_rm $1 /enlace_informe.txt
echo
#listamos otra vez para ver que enlace ha sido borrado
echo
echo MI_LS -------------------------------------------
echo ./mi_ls $1 /
./mi_ls $1 /
echo
#llamamos a leer_SF que muestra la informacion del SB, MB y AI
#echo
#echo LEER_SF -------------------------------------------
#echo ./leer_sf $1
#./leer_sf $1
#echo

