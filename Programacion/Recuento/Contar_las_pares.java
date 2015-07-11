/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;

/**Algoritmo Contar_las_pares
 * Inicio
 *
 * Obtener primera pareja
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
public class Contar_las_pares {
    public static void main (String[]args){
        try{
            final char FINAL_SECUENCIA='.';
            final char L='l';
            final char A='a';
            char car2,car1=' ';
            int contador=0;

            System.out.print ("Introduzca la secuencia de caracteres: ");
            car2=(char)System.in.read();
            while (car2!= FINAL_SECUENCIA){
                if ((car1==L) && (car2==A))
                        contador++;
                car1=car2;
                car2=(char)System.in.read();
            }
            System.out.println ("El numero de secuencia es " +contador);
        }catch (Exception e){}
    }
}
