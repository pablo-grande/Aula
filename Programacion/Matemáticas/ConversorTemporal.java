/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Dada una medida de tiempo expresada en horas, minutos y segundos con valores
 * arbitrarios, elabore un programa que transforme dicha medida en una expresión
 * correcta. Por ejemplo, dada la medida 3h 118m 195s, el programa deberá
 * obtener como resultado 5h 1m 15s.
 *
 * @author Pablo Riutort
 */
public class ConversorTemporal {

    public static void main(String[] args) throws IOException {
        //Declaración de variables
        int h, m, s, aux=0;
        String entrada;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        //Instrucciones;
        System.out.print("Introduzca las horas: ");
        entrada = teclado.readLine();
        h = Integer.parseInt(entrada);
        System.out.print("Introduzca los minutos: ");
        entrada = teclado.readLine();
        m = Integer.parseInt(entrada);
        System.out.print("Introduzca los segundos: ");
        entrada = teclado.readLine();
        s = Integer.parseInt(entrada);
        
        if (s>60){
            aux = s % 60;
            s = aux;
        }
        m = m + aux;
  
        if (m>60){
            aux = m % 60;
            m = aux;
        }   
        
        aux = aux/10; //Si no hago esto no funciona... no entiendo por qué

        h = h + aux; 
        
        System.out.println();
        System.out.println ("El resultado es: " + h + ":" + m + ":" + s);
        
    }
}
