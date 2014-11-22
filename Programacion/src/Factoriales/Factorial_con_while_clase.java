/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Factoriales;

/**
 *
 * @author Pablo Riutort
 */
import java.io.*;

public class Factorial_con_while_clase {
    public static void main (String [] args) {
    try {
    int numero;
    int factorial=1; /*El valor neutro de un producto es el 1, así como de la suma es 0*/
    String entrada;
    System.out.print("Introduzca el numero del que se quiere realizar el factorial: ");
    BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
     entrada=in.readLine();
     numero=Integer.parseInt(entrada);
     if (numero <13) {

     while (numero >0) {
         factorial=factorial*numero;
         numero--;
         }
        System.out.println("El factorial es" + factorial);
     }
     else System.out.println("El numero está fuera de rango"); 
     }catch (Exception e) {}
}
}

