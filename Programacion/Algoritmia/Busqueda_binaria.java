/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica;

/**Busqueda binaria o dicotómica. Consiste en:
 *
 * Conjunto de numeros previamente ordenado.
 * El numero de elementos representa el numero de elementos que hay en el conjunto de numeros
 * La busqueda consiste en dividir los elementos en 2 partes iguales, por el mediano.
 * Una vez dividido verificamos si el valor que se encuentra en el elemento mediano es igual al dato que buscamos
 * Si lo es, hemos acabado, sino, preguntamos si es menor o mayor.
 * A partir de estos datos datos, sabremos donde continuar la busqueda
 * Repetimos el algoritmo hasta encontrar el numero deseado.
 *
 *
 * @author Pablo Riutort
 */
public class Busqueda_binaria{

    public static boolean Busqueda_binaria (int vector[], int numero){
        int i=0, mitad, j=vector.length-1;
        do{
            mitad = (i+j)/2;
            if (numero < vector [mitad])
                j=mitad-1;
            else
                i=mitad+1;
        }while ((numero != vector[mitad]) && (i<j));
        return (numero==vector[mitad]);
    }
}