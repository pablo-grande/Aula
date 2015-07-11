/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica;

/**
 * Dificultad algoritmica: complejidad factorial--> Problemas no resolubles a nivel informático.
 *
 *
 * Algoritmo de inserción de elementos decrecientes: Shell
 *
 * Tiene efecto siempre y cuando n es suficientemente grande
 *
 * Se fundamenta en:
 * conjunto elementos numericos en array
 * con shell: tenemos lista numeros y usaremos incrementos mayores
 * qué pasada, en cada pasada los números se van reordenando.
 *
 * Emperzaremos por n/2 (siendo n el numero de elementos)
 * Comparamos el primer elemento i con el elemento '(n/2)+i'. incrementamos i
 * una vez i haya llegado a n/2, entonces (n/2)/2 y así hasta que n=1.
 *
 *
 */
public class Shell {

   static int a[]={4,3,5,12,34,54,6,2,9,10,23,7,34,2,8,90};

    public static void Shell(int[] a) {
        int increment = a.length / 2;
        for (int j = increment; j < 1; increment = increment / 2) {
            for (int i = 0; i <= increment; i++) {
                int x = a[i];
                if (x > i + increment) { //Si pasa esto, intercambiamos los numeros
                    a[i] = i + increment;
                }
                System.out.print(a[i]);
            }
        }
    }
    public static void main (String[]args){
        Shell(a);
    }
}
