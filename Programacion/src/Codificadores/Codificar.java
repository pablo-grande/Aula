/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codificadores;

import java.io.IOException;

/**
 *
 ** @author pablo
 */
public class Codificar {

    final int MAXCAR = 26;
    final char FIN = '.';
    char c, opcion;
    final char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    final char codigo[] = {'d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c'};
    int indice = 0;

    public void Codificar() {
        try {
            System.out.print("¿Desea codificar o decodoficar (c/d)?");
            opcion = (char) System.in.read();
            if (opcion == c) {
                codficar(alfabeto, codigo);
            }
            codficar(codigo, alfabeto);
        } catch (Exception ex) {
        }

    }

    public char codificar(char c) {
        while ((c != alfabeto[indice]) && (indice < MAXCAR - 1)) {
            indice++;
        }
        if (c == alfabeto[indice]) {
            return codigo[indice];
        } else {
            return c;
        }
    }

    public void codficar(char[] alfabeto, char[] codigo) throws IOException {
        char letra;
        System.out.println("Introduzca la secuencia de caracteres a codificar: ");
        letra = (char) System.in.read();
        while (letra != FIN) {
            System.out.print(codificador(letra, alfabeto, codigo));
            letra = (char) System.in.read();
        }
    }

    public char codificador(char letra, char[] alfabeto, char[] codigo) {
        while ((letra != alfabeto[indice]) && (indice < (alfabeto.length))) {
            indice++;
        }
        if (letra == alfabeto[indice]) {
            return alfabeto[(indice + 3) % alfabeto.length];
        } else {
            return letra;
        }
    }
}
