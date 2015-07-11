package Búsquedas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Algoritmo Pares_impares
 * 
 * Inicio
 * Visualizar mensaje de introduccion de secuencia
 * Lectura caracter
 * Buscar palabra
 * Mientras caracter leido no sea final de secuencia hacer
 * Tratamiento palabra
 * Buscar palabra
 * Fin mientras
 * Visualizar contadores de palabras
 * Fin palabras_pares_impares
 * 
 * Algoritmo Tratamiento es
 * mientras caracter leido no sea espacio ni final de secuencia
 *  Incrementar contador letras
 *  leer caracter
 * Fin mientras
 * Si contador letras es par, entonces
 *      Incrementar contador palabras pares
 *  Sino
 *      Incrementar contador palabras impares
 * Fin si
 * Inicializar contador letras
 * Fin tratamiento
 * 
 * Algoritmo buscar_palabra es
 * Mientras caracter sea igual a espacio
 *  leer caracter
 * Fin mientras
 * Fin buscar palabra
 *
 * @author Pablo
 */

public class Palabra_pares_impares {
    public static char car;
    public static final char FINAL_SECUENCIA='.';
    public static final char ESPACIO=' ';
    public static int contador_palabras_pares=0;
    public static int contador_palabras_impares=0;

    public static void buscar_palabra(){
        try{
            while (car == ESPACIO)
                car=(char)System.in.read();
        }catch (Exception e){}
    }

    public static void tratamiento(){
        int contador_letras=0;
        try{
            while ((car!= ESPACIO) && (car!= FINAL_SECUENCIA)){
                contador_letras++;
                car=(char)System.in.read();
                }
            if (contador_letras % 2 == 0)
                contador_palabras_pares++;
            else
                contador_palabras_impares++;

            contador_letras=0;
            }catch (Exception e){}
        }

    public static void main (String [] args){
        try{
            System.out.print ("Introduzca la secuencia a tratar: ");
            car=(char)System.in.read();
            buscar_palabra();
            while (car!= FINAL_SECUENCIA){
                tratamiento();
                buscar_palabra();
                }
            System.out.println ("El numero de palabras pares es: " +contador_palabras_pares);
            System.out.println ("El numero de palabras impares es: "+contador_palabras_impares);
        }catch (Exception e){}
        }
    }