/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Diseñe un programa que lea los coeficientes de una ecuación de segundo grado
 * ax2+bx+c=0 y calcule sus dos soluciones. Se supone que la ecuación tiene
 * soluciones reales.
 *
 * @author Pablo Riutort
 */
public class Ecuacion {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        //Declaración de variables
        int a, b, c, b2; 
        double resultado1,resultado2,aux,aux2;
        String entrada;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        //Código

        System.out.print("Introduzca el valor 'a': ");
       
        entrada = teclado.readLine();
        a = Integer.parseInt(entrada);
        
        System.out.print("introduzca el valor 'b': ");
      
        entrada = teclado.readLine();
        b = Integer.parseInt(entrada);
        b2=b*b;
        b = b * (-1);

        System.out.print("introduzca el valor 'c': ");
      
        entrada = teclado.readLine();
        c = Integer.parseInt(entrada);
        
        aux = b2 - (4*a*c);
        if (aux < 0){
            System.out.print ("El resultado no pertenece a los números reales");
        }
        else{
        aux2 = Math.sqrt(aux);
        // Math.sqrt ((4*a*c)*-1); --> convert to hexadecimal constant??
        resultado1 = (b - aux2)/(2*a);
        resultado2 = (b + aux2)/(2*a);
        
        System.out.println();
        System.out.println ("Los resultados son: " + resultado1 + " y " + resultado2);
        }
    }
}