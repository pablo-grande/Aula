/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuento;

/*Algoritmo
 * Inicio
 *
 * Leer caracter
 * Mientras queden caracteres por tratar
 *  Tratamiento caracter
 * Visualizar resultado
 * Fin
 *
 * Algoritmo Tratamiento es
 *Si caracter es "l" entonces{
 *      Leer caracter
 *      Si caracter es "a" entonces
 *          Incrementar contador
 *          Lectura caracter
 * }
 *Sino lectura caracter
 *      Fin si
 *  Fin si
 * Leer caracter
 * Fin Mientras
 * Si contador>0 entonces
 *  Visualizar: El numero de "la" es (contador)
 * sino
 *  Visualizar: no hay caracteres "la"
 * Fin si
 * Fin Contar_las
/**
 *
 * @author Pablo
 */
public class Contar_las_sub {
    public static final char FINAL_SECUENCIA='.';
    public static final char L='l';
    public static final char A='a';
    public static char letra;
    public static int contador=0;

    public static void buscar_l(){
        try{
                if (letra == L){
                    letra=(char)System.in.read();
                }
 else letra=(char)System.in.read();
        }catch (Exception e){}
    }

    public static void buscar_a(){
        try{
             if (letra == A){
                 contador++;
                 letra=(char)System.in.read();}
    }catch (Exception e){}
    }

public static void main (String [] args){
    try{
        System.out.print("Introduzca la secuencia de caracteres: ");
        letra=(char)System.in.read();
        while (letra!=FINAL_SECUENCIA){
            buscar_l();
            buscar_a();
            }
        System.out.println ("Hay "+contador+ " 'la' en el texto.");
      }catch (Exception e){}
}
}
