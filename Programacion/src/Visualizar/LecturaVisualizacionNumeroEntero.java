/*
 * Este programa lleva a término la lectura por teclado y visualización
 * por pantalla de un número entero
 * 
 * Se compone de dos tareas:
 * Leer el número por teclado
 * Visualizar el número por pantalla
 */
package Visualizar;
import java.io.*;
/**
 *  Fecha: 15/10/2012
 * @author Pablo Riutort
 */
public class LecturaVisualizacionNumeroEntero {
    
    public static void main (String[]args) throws IOException{
        int numero;
        String entrada;
        BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
        System.out.print ("Introduzca un número: ");
        entrada = teclado.readLine();
        numero=Integer.parseInt(entrada);
        System.out.println ("El número introducido es: " +numero);
    }
}
