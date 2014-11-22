/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sumatorios;

/**Realizar la suma de los 'n' números introducidos por teclado, donde 'n' --viene predefinido
por el usuario.

Algoritmo suma_hasta_n es
entero a,n;
entero contador=0;
entero contador_n=0;

Inicio
Lectura_de_n es
	{
	Visualizar ("Introduzca el número de números que va a sumar: ");
	Leer (n);
	}
Fin Lectura_de_n;

Lectura_de_numeros es
Mientras contador_n<n
	{
	Visualizar ("Introduzca el número que desea sumar: ");
	Leer (a);
	}
Fin lectura_de_numeros;
	Tratamiento es
	{
	Contador=Contador+a;
	contador_n=contador_n+1;
	}
Fin
Fin Tratamiento;

Visualizar_resultado es
Si Contador_n=n
	{
	Visualizar ("El resultado obtenido es" +contador);
	}
Fin;
Fin Visualizar_resultado;

/**
 *
 * @author Pablo
 */
import java.io.*;
public class Suma_hasta_n_con_do {
    public static void main (String [] args){
        try{
            int contador=0,suma=0,numero,numTotal;
            String entrada;
            BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
            System.out.print ("Introduzca el numero de numeros que va a sumar: ");
            entrada = in.readLine();
            numTotal=Integer.parseInt(entrada);
            do {
            System.out.print("Introduzca un numero a sumar: ");
            entrada=in.readLine();
            numero=Integer.parseInt(entrada);
            suma+=numero;
            contador++;
            }while (contador < numTotal);
            System.out.println ("El resultado es " +suma);
        }catch (Exception e){}
    }
}