/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mates;

/**
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class Primos_y_divisores {
    public static void main (String [] args){
        try{
            int n, resto;
            int i=1;
            int resultado=0;
            String entrada;
            System.out.print ("Introduzca un numero: ");
            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            entrada=in.readLine();
            n=Integer.parseInt(entrada);
            resto=n-1;
            while ((n % resto) == 0){ /*Si es = 0, entonces, es divisible, por lo tanto, esto está mal*/
                resto=n-1;
                resultado = (n & resto);
            }
            System.out.print ("Los divisores del numero " + n + " son: ");
            System.out.print (resultado);
            if ((n % resto) != 0){
                System.out.println (". El numero es primo");
            }

}catch (Exception e) {}
    }

}
