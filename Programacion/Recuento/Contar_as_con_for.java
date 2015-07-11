/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;

/**
 *
 * @author Pablo
 */

public class Contar_as_con_for {
    public static void main (String [] args){
        try{
            char car; final char objetivo='a';
            int contador=0; final char final_secuencia='.';

            System.out.print ("Introduzca la secuencia de carácteres: ");
            for (car=(char)System.in.read();car!=final_secuencia;car=(char)System.in.read())
                if (car == 'a')
                    contador++;
            System.out.print("El numero de caracteres 'a' es " +contador);
        }catch (Exception e){}
    }
    }