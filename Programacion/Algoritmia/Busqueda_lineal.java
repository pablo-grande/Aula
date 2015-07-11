/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica;

/**Vector de enteros y un numero de enteros
 *
 * Crear un numero de enteros
 *
 * @author Pablo Riutort
 */
public class Busqueda_lineal {

    /*Este algoritmo es de complejidad (vector-length-1)
     * puesto que los algoritmos iterativos tienen la complejidad tan grande como el n�mero de repeticiones que se hacen
     * entonces, este algoritmo es tan complejo como largo es el vector pasado por par�metro-1
     */
    public static boolean busquedaLineal(int[] vector, int numero) {
        int i = 0; //Op1
        while ((vector[i] != numero) && (i < vector.length - 1)) { //Op2
            i++; //Op3
        }
        return (vector[i] == numero); //Op4
    }
}

/*Tmaximo(n)= TOp1 + TOp2 + TOp3 + TOp4
*TOp2= (n-1)* TOp3
*TOp3= Tasignacion =O(1)
 * TOp2= (N-1)*O(1)=n-1=O(n)
 * TOp4= Tasignacion = O(1)
 * Tmaximo(n)= O(1) O(n)+O(1)=MAX (O(1),O(n),O(1))=O(n)
 * Por eso, el algoritmo de busqueda lineal es de complejidad lineal
*/
