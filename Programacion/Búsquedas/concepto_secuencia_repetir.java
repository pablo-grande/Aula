/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Búsquedas;

import java.io.IOException;

/**{
numero= 0;
repetir {
Leer(letra);
si (letra == 'a') numero = numero+1;
} mientras ( letra ≠ '.');
escribir("El numero de letras 'a' halladas son "+numero);
}
 *
 * @author pablo
 */
public class concepto_secuencia_repetir {
    public static void main (String[]args) throws IOException{
        int numero=0;
        char letra;
        do{
            letra=(char)System.in.read();
            if (letra == 'a'){
                numero=numero+1;
            }
        }while(letra!='.');
        System.out.println ("El número de letras 'a' halladas son "+numero);
    }
    
}
