/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mates;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Traducir las siguientes fórmulas a expresiones escritas en Java, declarando
 * para ello las variables que se consideren necesarias:
 * 
* a F= (9/5)C + 32 
* b f(x,y) = (1+(x^2)/y)/((x^3)/1+y) 
* c sqrt [(1+(e^1 / x^2 ) ^ 2]
 *
 * @author Pablo Riutort
 */
public class Funciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //Declaración de variables

        final double e;
        e = Math.E;
       // double aux;
        int x, y, F, f, C,aux, resultado = 0;
        char opcion;
        String entrada;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        // TODO code application logic here
        
        //Este programa no compara adecuadamente la entrada del teclado con los ifs que he puesto

        System.out.print("Escriba qué operación desea realizar: 'a', 'b' o 'c': ");
        opcion = (char) System.in.read();
        if (opcion == 'a') {
            System.out.print("Introduzca el valor C de la expresión: ");
            entrada = teclado.readLine();
            C = Integer.parseInt(entrada);
            resultado = C * (9 / 5) + 32;
            
        } else if (opcion == 'b') {
            System.out.print ("Introduzca el valor x de la función: ");
            entrada = teclado.readLine();
            x = Integer.parseInt(entrada);
            System.out.print ("Ahora introduzca el valor y de la función: ");
            entrada = teclado.readLine();
            y = Integer.parseInt (entrada);
            resultado = (1+(x^2)/y)/((x^3)/1+y);
            
        } else if (opcion == 'c'){
            System.out.print ("Introduzca el valor x de la función: ");
            entrada = teclado.readLine();
            x = Integer.parseInt(entrada);
            x = x^2;
            
            aux = (1+((int)e^1 / x )) ^ 2;
            resultado = (int) Math.sqrt(aux);
        }
        System.out.println("El número resultante es: " + resultado);
    }
}

