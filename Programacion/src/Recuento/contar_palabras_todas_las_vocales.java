/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;

/**
 * Algoritmo contar_palabras_todas_las_vocales Es
 *  Inicio
 *      incializacion;
 *      visualizar_mensaje_introducir_texto;
 *      leer_caracter;
 *      buscar_palabra;
 *      Mientras queden_palabras_por_tratar{
 *          alamacenar_palabra;
 *          tratamiento_palabra;
 *          buscar_palabra;
 *          }
 *      visualizar_resultado;
 *
 * Algoritmo buscar_palabra Es
 *  Inicio
 *      Mientras caracter_no_sea_alfabetico y queden_caracteres_por_taratar
 *          leer_caracter;
 *  Fin;
 *
 * Algoritmo tratamiento_palabra Es
 *  Inicio
 *      Mientras queden_caracteres_por_tratar{
 *          si caracter_es_vocal_(x)   --(x) es cualquier vocal (a,e,i,o,u)
 *              incrementar_contador_de_(x);
 *      }
 *      si estan_todas_las_vocales
 *          incrementar_contador;
 *  Fin;
 * @author Pablo Riutort
 */
public class contar_palabras_todas_las_vocales {
public static final int MAX=20+1;
public static char car,palabra[]=new char[MAX];
public static int indice=0,contador=0;
public static final char ESPACIO=' ',FIN='.';
public static void buscar_palabra(){
    try{
        while (car==ESPACIO)
            car=(char)System.in.read();
    }catch(Exception e){}
}
public static void almacenar_palabra(){
    try{
        while ((car!=ESPACIO)&&(car!=FIN)){
            palabra[indice]=car;
            indice++;
            car=(char)System.in.read();
        }
    }catch(Exception e){}
}
public static void tratamiento_palabra(){
    try{
        int num_vocal[]={0,0,0,0,0};  /*{a,e,i,o,u}*/
        for (int i=0;i<=indice-1;i++){
            switch (palabra[i]){

                case 'a': num_vocal[0]++;
                break;
                case 'e': num_vocal[1]++;
                break;
                case 'i': num_vocal[2]++;
                break;
                case 'o': num_vocal[3]++;
                break;
                case 'u': num_vocal[4]++;
                break;
            }
            }indice=0;
            if ((num_vocal[0]>=1)&&(num_vocal[1]>=1)&&(num_vocal[2]>=1)&&(num_vocal[3]>=1)&&(num_vocal[4]>=1))
                contador++;
            num_vocal[0]=0;num_vocal[1]=0;num_vocal[2]=0;num_vocal[3]=0;num_vocal[4]=0;
            
    }catch(Exception e){}

}
public static void main (String[]args){
  try{
      System.out.print("Introducir secuencia de caracteres: ");

        car=(char)System.in.read();
        buscar_palabra();
        while (car!=FIN){
            almacenar_palabra();
            tratamiento_palabra();
            buscar_palabra();
        }
        System.out.println(contador);
    }catch(Exception e){}
    }
}