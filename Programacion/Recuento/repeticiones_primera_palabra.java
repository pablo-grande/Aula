/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recuento;

import java.io.IOException;

/**
 * Ejercicio: Dada una secuencia de caracteres acabada en punto, se desea contar
 * cuantas veces aparece la primera palabra. Se supone que la longitud máxima de
 * las palabras es de 20 caracteres. Requerimientos: recorrido de la secuencia
 * con nivel de abstracción igual a palabra. Poder comparar la primera palabra
 * con todas las demás, por lo que implica poder almacenarla. Utilizaremos la
 * técnica del centinela, para fijar el fin de la palabra. En este caso un
 * carácter en blanco.
 *
 *
 * @author pablo
 */
public class repeticiones_primera_palabra {

    public final int MAX = 21;
    char[] primera = new char[MAX];
    char[] segunda = new char[MAX];
    public int contador = 0;
    public char letra = ' ';
    public final char CENTINELA = ' ';
    public final char FINAL = '.';

    public void contar_repeticiones() {
        try {
            presentacion();
            primera = leer_palabra();
            segunda = leer_palabra();
            while (!palabra_vacia()) {
                if (iguales()) {
                    contador++;
                    segunda = leer_palabra();
                }
            }
            fin(contador);
        } catch (IOException e) {
            System.out.print("La introducción de las palabras ha sido incorrecta");
        }
    }

    public void presentacion() {
        System.out.print("Escriba a continuación una secuencia de palabras acabada en punto.");
    }

    public void fin(int c) {
        System.out.print("El numero de repeticiones de la primera palabra es" + contador);
    }

    public char[] leer_palabra() throws IOException {
        char[] nueva = new char[21];
        int indice = 0;
        saltar_blancos();
        while ((indice < MAX) && (letra != ' ') && (letra != FINAL)) {
            nueva[indice] = letra;
            indice++;
        }
        nueva[indice] = CENTINELA;
        return nueva;
    }

    public void saltar_blancos() throws IOException {
        while (letra == ' ') {
            letra = (char) System.in.read();
        }
    }

    public boolean iguales() {
        int i = 0;
        while ((primera[i] == segunda[i]) && (primera[i] != CENTINELA)) {
            i++;
        }
        return (primera[i] == segunda[i]);
    }

    public boolean palabra_vacia() {
        return segunda[0] == CENTINELA;
    }
}