
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;
/**Algoritmo Contar_palabras
 * Inicio
 *
 * Obtener primera palabra
 * Mientras queden parejas de caracteres por tratar
 *  Tratamiento pareja
 *  Obtener siguiente pareja de caracteres
 * Visualizar resultado
 * Fin
 *
 * Algoritmo Tratamiento pareja es
 *Si pareja es "la" entonces
 *  Incrementar contador
 * Fin si
 *
 * Algoritmo Obtener siguiente pareja
 * Inicio
 *  Convertir segundo caracter de primera pareja
 *  Lectura caracter
 * Fin Obtener siguiente pareja
 * Fin Contar_las_pares

/**
 *
 * @author Pablo
 */
public class Contar_palabras {
    public static void main (String[]args){
        try{
            char letra, letra_2=' ';
            final char ESPACIO=' ';
            final char FINAL_SECUENCIA='.';
            int contador=0;
            System.out.print ("Introudzca la secuencia de carácteres: ");
            letra=(char)System.in.read();
            while (letra!= FINAL_SECUENCIA){
                if ((letra==ESPACIO) && (letra_2!=ESPACIO)){
                    contador++;
                    letra=letra_2;
                    letra=(char)System.in.read();
                    }
            }
            System.out.println ("El número de palabras de la secuencia es: " +contador);
           }catch (Exception e){}
    }

}
