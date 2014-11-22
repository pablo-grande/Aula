/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Búsquedas;
/**Dada una secuencia introducida por teclado y finalizada por '.', visualizar el primer carÃ¡cter vocal de dicha secuencia, si la hay, sino, visualizar el mensaje de 'no hay vocales'.

Algoritmo Buscar_vocales es

caracter car;

Inicio

Inicializacion;
Visualizacion_mensaje_secuencia_de_caracteres;
Lecutra_caracter;
mientras (Caracter_leido_no_sea_el_ultimo_caracter) y (caracter_leido_no_sea_vocal) {
	Lectura_caracter
	Si (caracter_leido) no es (Ultimo_caracter)
		Visualizar Caracter_primera_vocal_encontrada;

	Sino
		Visualizar ("No hay vocales");
Fin;


/**
 *
 */
public class Buscar_primer_caracter_vocal {
    public static void main (String[]args){
        try{
            char car;
            final char FINAL_SECUENCIA='.';
            final char A ='a';
            final char E ='e';
            final char I ='i';
            final char O ='o';
            final char U ='u';

            System.out.print("Introduce secuencia de caracteres: ");
            car=(char)System.in.read();
            while ((car !=FINAL_SECUENCIA) && ((car != A) && (car!= E) && (car!= I) && (car!= O) && (car!= U))){
                car=(char)System.in.read();
            }
            if (car!=FINAL_SECUENCIA) System.out.println ("La primera vocal es " + car);
            else System.out.println ("No hay vocales en la secuencia introducida");

        }catch (Exception e){}
    }
}
