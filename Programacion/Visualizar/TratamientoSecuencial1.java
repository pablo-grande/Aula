/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizar;

import java.io.IOException;

/**
 * Dado un texto introducido por teclado visualizar las proposiciones
 * interrogativas Viene dada por ¿ y termina por ?
 *
 * @author Pablo Riutort
 */
public class TratamientoSecuencial1 {

    public static void main(String[] args) throws IOException {
        char caracter;
        final char FIN = '.';
        final char INICIOSEC = '¿';
        final char FINALSEC = '?';
        System.out.print("Introduce la secuencia de caracteres: ");
        caracter = (char) System.in.read();
        while ((caracter != FINALSEC) && (caracter != INICIOSEC)) {
            caracter = (char) System.in.read();
        }
        while (caracter != FIN) {
            while (caracter != FINALSEC) {
                System.out.print(caracter);
                caracter = (char) System.in.read();
            }
            System.out.println();
                    while ((caracter != FINALSEC) && (caracter != INICIOSEC)) {
                caracter = (char) System.in.read();
            }
        }
    }
}