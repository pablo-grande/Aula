/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica;

/**
 *
 * @author Pablo
 */
public class Quicksort {
    public static int[] ordenarQuicksort (int v[], int primero, int ultimo){
    int pivote, i=primero, j=ultimo;
    while (i<j) {
        pivote = v[(primero+ultimo)/2];
        while (v[i] < pivote) {
            i++;
        }
        while (v[j] > pivote) {
            j--;
        }
        if (i <= j) {
            int aux = v[j];
            v[j] = v[i];
            v[i] = aux;
            i++;
            j--;
        }
    }
    if (primero < j) {
        v = ordenarQuicksort (v, primero, j);
    }
    if (ultimo >i) {
        v = ordenarQuicksort (v, i , ultimo);
    }
    return v;

}
}
