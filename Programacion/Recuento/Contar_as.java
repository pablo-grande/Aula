/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;
/**Dada una secuencia de carácteres introducida por teclado y acabada en '.', se pide visualizar el número de carácteres 'a' contenidos en dicha secuencia.

Algoritmo contar_as es

Caracter car;
Entero contador;

Inicio

Inicialización;
	Visualizar ("Introudzca la cadena de carácteres: ");
	Lectura_de_carácter
	Mientras_carácter_leído_no_sea_último_carácter {
		Tratamiento_carácter_leído;
		Lectura_caracter;
	}
	Visualizar_resultado;

Fin;


Tratamiento_caracter es

Inicio

Si (caracter_leído='a') Incrementar_contador;

Fin;
/**
 *
 * @author Pablo
 */

public class Contar_as{
public static void main (String [] args){
    try{
        char car;
        int contador=0;

        System.out.print ("Introduzca la secuencia de carácteres deseada: ");
        car=(char)System.in.read();
        while (car != '.'){
            if (car == 'a')
                contador++;
            car=(char)System.in.read();
        }
        System.out.println("El numero de caracteres 'a' es" +contador);
    }catch (Exception e){}
}
}