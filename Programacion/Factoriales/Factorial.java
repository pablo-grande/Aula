/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Factoriales;

/*Algoritmo de calcular el factorial de un numero introducido por teclado.

Algoritmo Factorial es

entero numero,numero_2,producto;

Inicio
Lectura_numero es
Visualizar ("Introduzca el numero deseado: ");
Mientras numero <=1
	{
	Tratamiento es
	Leer (numero)
	Resta 1 al numero
	Mientras el resultado sea diferente a 1 hacer
	numero-1 * numero = producto
	restar 1 a numero-1 --> numero_1=numero_1-1
	Fin mientras;
	Fin Tratamiento;
	}
Visualizacion es
	Visualizar ("El factorial de" +numero "es" +producto);
Fin visualizar
Fin Factorial

/**
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class Factorial {
public static void main (String [] args){
try{
                int numero, numero_1;
                int factorial=1;
                    String entrada;
                    System.out.print("Introduzca el numero deseado");
                        BufferedReader in=new BufferedReader (new InputStreamReader(System.in));
                        entrada=in.readLine();
                        numero=Integer.parseInt(entrada);
                        numero_1=numero-1;
                        while (numero_1 != 1) {
                            factorial=numero_1*numero;
                            numero_1=numero--;
                    }
                        System.out.println("El factorial de" +numero + "es" + factorial);
            }catch (Exception e) {}
                        }
}
