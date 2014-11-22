/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizar;
/*
 * Dado un texto de caracteres introducidos por teclado, visualizar:
 * Todas las palabras del texto deben estar invertidas.
 *
 * Algoritmo Texto_palabras_invertidas
 * Inicio
 * Vector palabra
 * Vector palabras del texto
 * char car
 *
 * Visualizar mensaje de introducción de texto
 * Lectura caracter
 * Buscar palabra
 *
 * Mientras queden palabras por tratar
 *  Lectura y tratamiento palabra
 *  Tratamiento palabra
 *  Buscar palabra
 * Fin mientras
 *
 * ALGORITMO BUSCAR_PALABRA ES
 * INICIO
 *  Mientras caracter_leido_no_sea_alfabetico_y_caracter_leido_no_sea_caracter;
 *      lectura_caracter;
 * FIN;
 *
 * ALGORITMO LECTURA Y TRATAMIENTO PALABRA
 * Inicio
 * Leer caracter
 * Mientras queden caracteres por leer de la palabra
 *  Almacenar caracter
 *  Lectura caracter
 * Fin Mientras
 * Fin
 *
 * ALGORITMO TRATAMIENTO_PALABRA ES
 * INICIO
 *  Visualizar_palabra_al_reves
 * FIN;
 *
 */

/**
 *
 * @author Pablo
 */
public class Texto_palabras_invertidas {

    public static char car;
    public static final int MAX = 20;
    public static char palabra[] = new char[MAX + 1];
    public static final char FINAL_SECUENCIA = '.';
    public static final char ESPACIO = ' ';

    public static void buscar_palabra() {
        try {
            while (car == ESPACIO) {
                car = (char) System.in.read();
            }
        } catch (Exception e) {
        }
    }

    public static void lectura_y_almacenamiento() {
        try {
            int indice = 0;
            while ((car != FINAL_SECUENCIA) && (car != ESPACIO)) {
                palabra[indice] = car;
                indice++;
                car = (char) System.in.read();
            }
            palabra[indice] = ESPACIO;
        } catch (Exception e) {
        }

    }

    public static void tratamiento_palabra() {
        try {
            int indice = 0;
            while (palabra[indice] != ESPACIO) {
                indice++;
            }
            for (int i = indice - 1; i >= 0; i--) //Indice representa los componentes, no los caracteres, por eso restamos 1.
            {
                System.out.print(palabra[i]);
            }
            System.out.println();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        try {
            System.out.print("Introducir texto: ");
            car = (char) System.in.read();
            buscar_palabra();
            while (car != FINAL_SECUENCIA) {
                lectura_y_almacenamiento();
                tratamiento_palabra();
                buscar_palabra();
            }
        } catch (Exception e) {
        }
    }
}