/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizar;

import java.io.IOException;

/**
 *
 * @author pablo
 */
public class TratamientoSecuencial2 {

    static final char FinalSecuencia = '.';
    static char caracter;

    public static void main(String[] args) throws IOException {

        int numPalabrasPares = 0, numPalabrasImpares = 0;

        System.out.print("Introduzca la secuencia de caracteres");
        caracter = (char) System.in.read();
        buscarPalabra();
        while (caracter != FinalSecuencia) {
            if (esPar()) {
                numPalabrasPares++;
            } else {
                numPalabrasImpares++;
            }
            buscarPalabra();
        }
        System.out.println("Número de palabras pares: " + numPalabrasPares + "\nNúmero de palabras impares: " + numPalabrasImpares);
    }

    public static void buscarPalabra() throws IOException {
        while ((caracter != FinalSecuencia) && !(((caracter > 'a') && (caracter <= 'z')) || ((caracter > 'A') && (caracter < 'Z')))) {
            caracter = (char) System.in.read();
        }
    }

    public static boolean esPar() throws IOException {
        int NumCaracteres = 0;
        while (((caracter > 'a') && (caracter <= 'z')) || ((caracter > 'A') && (caracter < 'Z'))) {//Condición de carácter alfabético
            NumCaracteres++;
            caracter = (char) System.in.read();
        }
        return (NumCaracteres % 2 == 0);

    }
}
