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
public class TratamientoSecuencialPalabra1 {

    public static void main(String[] args) throws IOException {
        Palabra nueva;
        final char FIN = '.';
        final char INICIOSEC = '¿';
        final char FINALSEC = '?';
        System.out.print("Introduce la secuencia de caracteres: ");
        nueva=Palabra.lectura();
        while ((nueva.letras(nueva)[0] != INICIOSEC)&& (nueva.letras(nueva)[nueva.longitud(nueva)]!= FIN)){
            nueva=Palabra.lectura();
        }
        
        while (nueva.letras(nueva)[nueva.longitud(nueva)]!= FINALSEC){
            Palabra.toString(nueva);
            System.out.print(nueva);
            nueva=Palabra.lectura();
        }
       while ((nueva.letras(nueva)[0] != INICIOSEC)&& (nueva.letras(nueva)[nueva.longitud(nueva)]!= FINALSEC)){
           nueva=Palabra.lectura();
       }
    }
}