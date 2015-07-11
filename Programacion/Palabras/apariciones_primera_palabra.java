/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Palabras;

/**
 *
 * @author Pablo Riutort
 */
public class apariciones_primera_palabra {
    public static void main(String[]args){
try{
    int contador=0;
    Palabra a,b;
    System.out.print("Introducir texto: ");
    Palabra.buscarPalabra();
    a=Palabra.lectura();
    if (!(Palabra.vacia(a))) contador++;
    Palabra.buscarPalabra();
    b=Palabra.lectura();
    while (!(Palabra.vacia(b))){
        if (Palabra.iguales(a,b)) contador++;
        Palabra.buscarPalabra();
        b=Palabra.lectura();
    }
    System.out.println("El número de veces que se repite la palabra <<"+Palabra.toString(a)+">> es "+contador);
    System.out.println();
}catch (Exception e){}

    }
}
