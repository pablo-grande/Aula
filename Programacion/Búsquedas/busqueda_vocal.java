/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Búsquedas;

import java.io.IOException;

/**
 * Programa que busca y contabiliza las vocales introducidas por teclado hasta encontrar el carácter final ('.')
 *
 * @author pablo
 */
public class busqueda_vocal {
    public static void main (String[]args) throws IOException{
        char letra;
        
        letra=(char)System.in.read();
        while((letra!='.')&& !((letra=='a')||(letra=='e')||(letra=='i')||(letra=='o')||(letra=='u'))){
            letra=(char)System.in.read();
        }
        if ((letra=='a')||(letra=='e')||(letra=='i')||(letra=='o')||(letra=='u')){
            System.out.print("La primera vocal és: "+letra);
        }else{
            System.out.print("No hi ha cap vocal");
        }
    }
    
}
