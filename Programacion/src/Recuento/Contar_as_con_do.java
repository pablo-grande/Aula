/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;
/** Algoritmo Contar_as_con_repetir

caracter car;
entero contador;

Inicio

Inicializacion;
	Visualizar ("Inroduzca la cadena de carácteres deseada: ");
	Repetir {
	Lectura_caracter;
	Tratamiento_caracter;
	} Mientras caracter_leido_no_sea_el_ultimo;
Visualizar_resultado;
Fin;
/**
 *
 * @author Pablo
 */

public class Contar_as_con_do {
    public static void main (String [] args){
        try{
            char car;
            int contador=0;

            System.out.print ("Introduzca la secuencia de carácteres: ");
            do {
                car=(char)System.in.read();
                if (car == 'a')
                    contador++;
            } while (car!= '.');
            System.out.print("El numero de caracteres 'a' es " +contador);
        }catch (Exception e){}
    }
    }
