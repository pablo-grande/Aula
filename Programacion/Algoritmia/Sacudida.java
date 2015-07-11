/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica;

/**Algoritmo de la sacudida:
 *
 * de derecha a izquierda aplicar intercambios sucesivos (hacemos que los nºs pequeños se desplacen a la izqda.)
 * y luego de izqda. a derecha para que los nºs grandes se desplacen por el vector.
 *
 * el penúltimo  > el último = intercambio
 * penultimo > antepenultimo = intercambio
 *
 * @author Pablo Riutort
 */
public class Sacudida {

    public static void main(String[] args) {
        try {
            int a[] = {4, 3, 5, 12, 22, 54, 6, 2, 9, 10, 23, 7, 34, 26, 8};
            int izquierda = 1;
            int derecha = a.length;
            int ultimo = a.length - 1;
            int intercambios = -1;
            while ((izquierda < derecha)&&(intercambios!=0)) {
                for (int i = a.length - 1; i >= izquierda; i--) {
                    if (a[i - 1] > a[i]) {
                        int aux = a[i];
                        a[i] = a[i - 1];
                        a[i - 1] = aux;
                        intercambios++;
                    }
                }
                izquierda = ultimo + 1;
                for (int j = 1; j < derecha; j++) {
                    if (a[j - 1] > a[j]) {
                        int aux = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = aux;
                        ultimo = j;
                        intercambios++;
                    }
                }
                derecha = ultimo--;
            }
            for (int l = 0; l <= a.length; l++) {
                System.out.print(a[l]);
                System.out.print(" ");
            }
        } catch (Exception e) {
        }
    }
}
