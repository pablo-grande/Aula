/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;

/**
 *Algoritmo codificador_palabras_pares Es
 * Inicio
 *      inicialización;
 *      visualizar_mensaje_introducción_secuencia;
 *      leer_caracter;
 *      buscar_palabra();
 *      Mientras queden_palabras_por_tratar {
 *          contabilizar_palabra;
 *          Si es_palabra_en_posicion_par
 *              codificar_palabra;
 *          Sino visualizar_palabra;
 *      buscar_palabra;
 *      }
 *  Fin;
 * 
 * ALGORITMO BUSCAR_PALABRA ES
 * INICIO
 *  Mientras caracter_leido_no_sea_alfabetico;
 *      lectura_caracter;
 * FIN;
 * 
 * Algoritmo codificar_palabra Es
 * Inicio
 *      Mientras queden caracteres_de_la_palabra_por_tratar{
 *          buscar_caracter_en_alfabeto_normal;
 *          cambiarlo_a_caracter_codificado;
 *          leer_caracter;
 *      }
 * Fin;
 * 
 * @author Pablo
 */
public class codificador_palabras_pares {
    public static char car;
    public static int contador=0,indice=0;
    public static final char ESPACIO=' ',FIN='.';
    public static char alfabeto[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static char alfacod[]={'d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c'};
    public static void buscar_palabra(){
        try{
            while (car==ESPACIO) car=(char)System.in.read();
        }catch (Exception e){}
    }
    public static void codificar_palabra(){
        try{
            while ((car!=ESPACIO)&&(car!=FIN)){
                    while((car!=alfabeto[indice])&&(indice<=25))
                    indice++;
            System.out.print(alfacod[indice]);
            indice=0;
            car=(char)System.in.read();
            }
        }catch(Exception e){}
    }
    public static void visualizar_palabra(){
        try{
            while ((car!=ESPACIO)&&(car!=FIN)){
                System.out.print(car);
                car=(char)System.in.read();
            }
        }catch (Exception e){}
    }
    public static void main(String[]args){
        try{
            System.out.print("Introduzca secuencia de caracteres: ");
            car=(char)System.in.read();
            buscar_palabra();
            while (car!=FIN){
                contador++;
                if (contador%2==0)
                    codificar_palabra();
                else visualizar_palabra();
                System.out.print(" ");
                buscar_palabra();
            }System.out.println();
        }catch(Exception e){}
    }
}
