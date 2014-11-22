/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica;

/**
 *
 * @author Pablo Riutort Grande
 */
import java.io.*;

public class Busqueda_fichero_aleatorio_P_Riutort {

    public static void main(String[] args) {
        try {
            int vector[] = {2, 4, 5, 8, 2, 1}; //Vector con una serie de números
            RandomAccessFile fichero = new RandomAccessFile("datos.dat", "rw");//Creamos el fichero aleatorio e indicamos que es de lectura/escritura
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //Creamos un buffer para que el usuario pueda inroducir un numero a buscar más adelante
            fichero.seek(fichero.length());//Esto sirve para poder escribir, movemos el puntero del fichero a la posición de su tamaño (En nuestro caso no hay nada, por tanto 0)
            for (int i = 0; i < vector.length; i++) { //Este for nos permite escribir el vector de antes en el fichero
                fichero.writeInt(vector[i]);
            }
            System.out.print("Introduzca el numero a buscar: "); //Pedimos al usuario un numero a buscar
            String entrada = in.readLine();
            int numero = Integer.parseInt(entrada);


            //Aplicamos el algoritmo de burbuja para ordenar dicho vector
            int aux = 0;
            for (int i = 0; i < vector.length; i++) {
                for (int j = 1; j < vector.length - 1; j++) {
                    if (vector[j] > vector[j + 1]) {
                        aux = vector[j];
                        vector[j] = vector[j - 1];
                        vector[j - 1] = aux;
                    }
                }
            }

            //Aplicamos la búsqueda binaria para encontrar el numero en el vector
            //Recordemos que este algoritmo solo puede ser aplicado a conjuntos ordenados (cosa que ya hemos hecho con el algoritmo de burbuja anteriormente)
            int i = 0, mitad, j = vector.length - 1;
            do {
                mitad = (i + j) / 2;
                if (numero < vector[mitad]) {
                    j = mitad - 1;
                } else {
                    i = mitad + 1;
                }
            } while ((numero != vector[mitad]) && (i < j));
            if (numero == vector[mitad]) {
                System.out.println("El numero ha sido encontrado"); //Mensaje de se ha encontrado
            } else {
                System.out.println("El numero no ha sido encontrado");//En caso de no encontrarse aparece este mensaje
            }
        } catch (Exception e) {
        }
    }
}
