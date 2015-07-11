/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Búsquedas;
/*Algoritmo
 * Inicio
 *
 * Leer caracter
 * Mientras no sea punto hacer
 * Leer caracter
 *  Si caracter es vocal entonces
 *  guardar caracter y actualizar variables
 * Fin si
 * Fin mientras
 * Si es el final de la secuencia de caracteres entonces
 *  visualizar variable
 * Fin si
 * Fin Ultima_vocal
 */
/**
 *
 * @author Pablo
 */
import java.io.*;
public class Ultima_vocal {
    public static void main (String[]args){
        try{
            char letra;
            final char FINAL_SECUENCIA='.';
            final char VOCAL_A='a';
            final char VOCAL_E='e';
            final char VOCAL_I='i';
            final char VOCAL_O='o';
            final char VOCAL_U='u';
            char vocal=' ';

            System.out.print ("Introduzca la secuencia de caracteres: ");
            letra=(char) System.in.read();
            while (letra != FINAL_SECUENCIA){
                if ((letra == VOCAL_A) || (letra == VOCAL_E) || (letra == VOCAL_I) || (letra == VOCAL_O) || (letra == VOCAL_U)){
                    vocal = letra;
                }
                letra=(char) System.in.read();

            }
            if (vocal == ' '){
                System.out.println ("No hay vocales");
            }
            else
                System.out.println ("La ultima vocal es " +vocal);
        } catch (Exception e){}
    }

}
