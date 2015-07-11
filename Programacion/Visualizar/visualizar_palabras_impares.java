/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visualizar;

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
 *      saltar_palabra;
 *      Buscar_palabra;
 *  }
 *  Visualizacion_resultado;
 * FIN;
 *
 * ALGORITMO BUSCAR_PALABRA ES
 * INICIO
 *  Mientras caracter_leido_no_sea_alfabetico_y_caracter_leido_no_sea_caracter;
 *      lectura_caracter;
 * FIN;
 *
 * ALGORITMO TRATAMIENTO_PALABRA ES
 * INICIO
 *  Si numero_numero_de_caracteres_palabra_es_impar
 *      visualizar_palabra;
 * FIN;
 *
 * ALGORITMO SALTAR_PALABRA ES
 * Inicio
 *  Mientras caracter_leido_sea_alfabetico
 *      contabilizar_caracter;
 *      almacenar_caracter;
 *      lectura_caracter;
 * FIN;
 */
public class visualizar_palabras_impares {
    public static char car;
    public static final char ESPACIO=' ';
    public static final char FINAL='.';
    public static final int MAX=20+1;
    public static char palabra []= new char[MAX];
    public static int caracteres_palabra=0;
   
    public static void buscar_palabra(){
    try{

        while (car==ESPACIO)
            car=(char)System.in.read();
       
    }catch (Exception e) {}
}

        public static void saltar_palabra(){
            try{
                while ((car!=ESPACIO) && (car!=FINAL)){
                    
                    palabra[caracteres_palabra]=car;
                    caracteres_palabra++;
                    car=(char)System.in.read();
                }
            }catch (Exception e){}
        }
public static void main (String [] args) {
    try{

        System.out.print("Introducir texto a tratar: ");
        car=(char)System.in.read();
        buscar_palabra();
        System.out.print("Las palabras impares son: ");
        while (car!=FINAL){
           
            saltar_palabra();
            if (caracteres_palabra%2!=0){
                for(int i=0;i<=caracteres_palabra-1;i++)
                    System.out.print(palabra[i]);
            }
            System.out.print(" ");
            caracteres_palabra=0;
            buscar_palabra();
        }        
    } catch (Exception e){}
   }
}
