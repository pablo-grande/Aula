/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mates;
/**Algoritmo que resuelva una ecuación de primer grado

ax+b=0  a,b € Z+

Leer del teclado = Leer ( );
Visualizar en pantalla = Visualizar ("Texto");


Algoritmo ecuación_de_primer_grado es
entero a,b,x;

Inicio
Lectura_de_numeros es
	Visualizar ("Introduzca 'a'");
	Leer (a);
	Visualizar ("Introduzca 'b'");
	Leer (b);
Fin lectura_de_numeros;

Tratamiento es
	x=(-b/a);
Fin tratamiento;

Visualizacion es
	Visualizar ("El resultado es" + x);
Fin visualizacion;

Fin ecuacion_de_primer_grado;
/**
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class Ecuacion_primer_grado {
    public static void main (String [] args){
        try{
            int a,b;

            String entrada;
            System.out.print ("Introduzca el número 'a' de la fórmula 'ax+b=0': ");
            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            entrada = in.readLine ();
            a = Integer.parseInt(entrada);  /*Leemos a*/
            System.out.print ("Ahora introduzca el número 'b' de la misma expresión: ");
            entrada = in.readLine();
            b = Integer.parseInt(entrada); /*Ahora leemos b*/
            System.out.println ("x=" + (-b/a)); /*Aparece el resultado 'x' en pantalla*/
        }catch (Exception e){}
    }

}
