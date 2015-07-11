/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mates;
/**Al leer un número entero, visualizar el valor absoluto de dicho número

Algoritmo valor_absoluto
entero a;
Inicio
Lectura_numero es
	Visualizar ("Introduzca el número deseado: ");
	Leer (a);
Fin lectura_numero;

Tratamiento es
	Si a>0 entonces
            Visualizar (a)
        Sino
            a=a*-1;
            Visualizar
	Fin;
Fin tratamiento;

Visualizar es
	Visualizar ("El resultado es " +a);
Fin visualizar;
Fin valor_absoluto;
/**
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class Valor_absoluto {
    public static void main (String [] args){
        try{
            int numero;

            String entrada;
            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            System.out.print ("Introduzca un numero: ");
            entrada = in.readLine();
            numero = Integer.parseInt(entrada);
            if (numero > 0){
            System.out.println ("Su valor absoluto es: " + (numero));
            }
            else
            System.out.println ("Su valor absolutro es: " + (numero * -1));
        }catch (Exception e){}
    }
}
