/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;

/**
 ALGORITMO visualizar_palabras_impares ES
 *
 * INICIO
 *  Inicializacion;
 *  Visualizacion_mensaje_introduccion_secuencia_de_caracteres;
 *  Lectura_caracter;
 *  Buscar_palabra;
 *  while queden_palabras_por_tratar{
 *
 *      saltar_y_almacenar_palabra;
 *      tratamiento_palabra;
 *      Buscar_palabra;
 *  }
 *
 * FIN;
 *
 * ALGORITMO BUSCAR_PALABRA ES
 * INICIO
 *  Mientras caracter_leido_no_sea_alfabetico;
 *      lectura_caracter;
 * FIN;
 *
 * ALGORITMO TRATAMIENTO_PALABRA ES
 * INICIO
 *  Si palabra_es_palindromo
 *      contabilizar;
 * FIN;
 *
 * ALGORITMO SALTAR_Y_ALMACENAR_PALABRA ES
 * Inicio
 *  Mientras caracter_leido_sea_alfabetico
 *      almacenar_caracter;
 *      contabilizar_caracter;
 *      lectura_caracter;
 * FIN;
 */
public class contar_palindromos {
    public static char car;
    public static int indice=0;
    public static int contador;
    public static int num_palindromos=0;
    public static boolean palindromo=true;
    public static final int MAX=20+1;
    public static final char ESPACIO=' ';
    public static final char FINAL='.';
    public static char palabra []= new char [MAX];
    public static void buscar_palabra(){
        try{
            while (car==ESPACIO){
                car=(char)System.in.read();
            }
        }catch (Exception e){}
    }
    public static void almacenar_palabra(){
        try{
            while ((car!=ESPACIO)&&(car!=FINAL)){
                palabra[indice]=car;
                indice++;
                car=(char)System.in.read();
            }
        }catch (Exception e){}
    }
    public static void tratamiento_palabra(){
        try{            
                contador=indice;
                for (int i=0;i<=contador/2;i++){
                    if (palabra[i]!=palabra[contador-1]) palindromo=false;
                    contador--;
                }            
            if (palindromo==true){
                num_palindromos++;
            }
            indice=0;
            palindromo=true;            
        }catch(Exception e){}
    }
    public static void main (String[]args){
        try{
            System.out.print("Introducir secuencia de caracteres: ");
            car=(char)System.in.read();
            buscar_palabra();
            while (car!=FINAL){
                almacenar_palabra();               
                tratamiento_palabra();
                buscar_palabra();
            }System.out.println("Cantidad de palíndromos: "+num_palindromos);
        }catch(Exception e){}
    }
}
