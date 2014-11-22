/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visualizar;
/*Dada una palabra introducida por teclado, acabada por '.',
 *de un máximo de 20 caracteres, visualizar la palabra invertida.
 *
 * Algoritmo Palabra_invertida es
 * Inicio
 * caracter car;
 * vector [] = new car [20];
 *
 * Visualizar mensaje de introducción
 * Lectura palabra
 *
 * Si hay palabra
 *  Visualizacion invertida palabra
 *
 * Sino Visualizacion de inexistencia de palabra
 *
 * Fin si
 *
 *Fin Palabra_invertida
 *
 * Algoritmo Lectura_palabra es
 * Inicio
 * Leer caracter:
 * Mientras queden caracteres por leer de la palabra
 *  Almacenar caracter
 *  Lectura caracter
 * Fin Mientras
 * Fin
 * 
 * Fin Palabra_invertida
 */
/**
 *
 * @author Pablo
 */
public class Palabra_invertida {
    public static int INDICE = 0;
    public static final int MAX = 20;
    public static char palabra [] = new char[MAX];
    
    public static void lectura_palabra(){
        try{
            char car;
            final char FINAL_SECUENCIA = '.';
            
            car=(char)System.in.read();
            while (car!= FINAL_SECUENCIA){
                palabra[INDICE]=car;
                INDICE++;
                car=(char)System.in.read();
            }
        }catch (Exception e){}
    }

    public static void Visualizar_palabra_invertida(){
        try{
            for (int i=INDICE-1; i>=0; i-- ) //Indice representa los componentes, no los caracteres, por eso restamos 1.
                System.out.print (palabra[i]);
            System.out.println ();

    }catch (Exception e){}
}

    public static void main (String [] args){
        try{
            System.out.print("Introducir palabra: ");
            lectura_palabra();
            if (INDICE > 0) Visualizar_palabra_invertida();
            else
                System.out.println ("No hay palabra");
        }catch (Exception e){}
    }
}