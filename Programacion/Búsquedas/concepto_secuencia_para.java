/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Búsquedas;

import java.io.IOException;

/**
 * Versión con el control de flujo "para" del programa concepto_secuencia
 *
 * @author pablo
 */
public class concepto_secuencia_para {
    public static void main (String[]args) throws IOException{
        char letra;
        int numero=0;
        
        letra = (char)System.in.read();
        for (numero=0; letra=='a'; numero++){
            numero++;
            }
        if (letra == '.'){
                System.out.println("El número de carácteres 'a' es " +numero);
        }
    }
    
}
