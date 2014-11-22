/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import java.io.IOException;

/**
 *
 * @author Pablo
 */
public class TratamientoSecuencialPalabra2 {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    static char caracter;

    public static void main(String[] args) throws IOException {

        int numPalabrasPares = 0, numPalabrasImpares = 0;
        Palabra nueva;

        System.out.print("Introduzca la secuencia de caracteres");
        nueva=Palabra.lectura();
       
        while (nueva.quedanPalabras()) {
            if (Palabra.longitud(nueva)%2==0) {
                numPalabrasPares++;
            } else {
                numPalabrasImpares++;
            }
            Palabra.buscarPalabra();
            nueva=Palabra.lectura();
        }
        System.out.println("Número de palabras pares: " + numPalabrasPares + "\nNúmero de palabras impares: " + numPalabrasImpares);
    }
}
