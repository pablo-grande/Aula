/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Búsquedas;

import java.io.IOException;

/**declaraciones
carácter letra;
entero numero;
instrucciones
{
numero = 0;
Leer(letra);
mientras (letra ≠ '.') 
{
si (letra == 'a') numero = numero + 1;
Leer(letra);
}
escribir("El numero de letras 'a' encontradas son "+numero);
}
 
 * @author pablo
 */
public class concepto_secuencia {
    public static void main (String[]args) throws IOException{
        char letra;
        int numero=0;
        
        letra= (char)System.in.read();
        while (letra!='.'){
            if (letra == 'a'){
                numero=numero+1;
            }
            letra= (char)System.in.read();
        }
        System.out.println("El numero de letras 'a' encontradas son "+numero);
    }
    
}
