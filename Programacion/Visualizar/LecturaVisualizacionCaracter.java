/*
 * Este programa lleva a término la lectura por teclado y visualización
 * por pantalla de un carácter
 * 
 * Se compone de dos tareas:
 * Leer el carácter por teclado
 * Visualizar el carácter por pantalla
 */
package Visualizar;
/**
 * Fecha: 15/10/2012
 * @author Pablo Riutort
 */
public class LecturaVisualizacionCaracter {
    
    public static void main (String[]args) throws Exception{
         /*
         * Declaración de variable
         * Caracter sirve para almancenar el caracter introducido por teclado
         */
        char caracter;
        
        System.out.print("Introduzca un caracter por teclado: ");
        
        caracter = (char)System.in.read();
        
        System.out.println ("El caracter leído es: " + caracter);
    }  
}