/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recuento;

import java.io.IOException;

/**
 *
 * @author pablo
 */
public class EmpiezaAcaba {

    static final char ESPACIO = ' ';
    static final char FIN = '.';
    static char anterior, caracter, siguiente;
    static int contador = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca la secuencia de caracteres: ");
        caracter = (char) System.in.read();
        anterior = caracter;
        while (caracter != FIN) {
            buscarPalabra();
        }
        System.out.println("Número de palabras que empiezan y acaban por el mismo carácter es: " + contador);
    }

    public static void buscarPalabra() throws IOException {
        while (/*(caracter != FIN) && !*/(caracter != ESPACIO)) {
            caracter = (char) System.in.read();
            anterior = caracter;
        }
        if (caracter == ESPACIO) {
            siguiente = (char) System.in.read();
            if (anterior == siguiente) {
                contador++;
            }
        }


    }
}
