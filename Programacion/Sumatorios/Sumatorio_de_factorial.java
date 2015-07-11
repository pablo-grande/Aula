/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sumatorios;

/*Algoritmo Sumatorio_de_factorial

 Inicio

 Leer numero
 Calcular Factorial (numero) = n!
 n! - n = Fin_sumatorio
 Desde 1 a Fin_sumatorio hacer
 +1
 Visualizar resultado
 Fin sumatorio


 */
import java.io.*;

public class Sumatorio_de_factorial {

    public static void main(String[] args) {
        try {
            int numero, numero_1, fin_sumatorio = 0;
            int factorial;
            int sumatorio;

            String entrada;
            System.out.print("Introduzca el numero del sumatorio: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            entrada = in.readLine();
            numero = Integer.parseInt(entrada);
            numero_1 = numero--;
            while (numero_1 != 1) {
                factorial = numero_1 * numero;
                numero_1 = numero_1--;
                fin_sumatorio = factorial - numero;
            }
            for (sumatorio = 1; sumatorio > fin_sumatorio; sumatorio++) {
                sumatorio++;
            }
            System.out.println("El sumatorio es: " + sumatorio);
        } catch (Exception e) {
        }
    }
}
