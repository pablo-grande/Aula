/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Búsquedas;

import java.io.IOException;

/**
 * Versión mejorada del Programa que busca y contabiliza las vocales introducidas por teclado hasta encontrar el carácter final ('.')
 *
 * @author pablo
 */
public class busqueda_vocal_mejorada {
    public static void main (String[]args) throws IOException{
        char letra;
        boolean trobat=false;
       
        do{
        letra=(char)System.in.read();
         if ((letra=='a')||(letra=='e')||(letra=='i')||(letra=='o')||(letra=='u'))
         trobat=true;
        }while(!trobat || letra != '.');
            
     if (trobat == true){
         System.out.println ("La primera lletra es: "+letra);
     }else{
         System.out.println ("No hi ha cap vocal");
     }
    }
}
