/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package Búsquedas;

import java.io.IOException;


/**
 * Dada un secuencia de caracteres indicar cuales 
son vocales y cuales no. 
 *
 * @author pablo
 */
public class vocales_novocales {

    public static void main(String[] args) throws IOException {
        char letra;
        int contador = 0;

        letra = (char) System.in.read();
        contador++;
       
        while (letra != '.') {
            if ((letra == 'a') || (letra == 'e') || (letra == 'i') || (letra == 'o') || (letra == 'u')) {
                System.out.println ("El caracter número " + contador + " es vocal");
            }
           
            
            else{
                System.out.println ("El caracter número "+contador+" no es vocal");
                 
            }
            letra = (char) System.in.read();
            contador++;
        }
    }
}