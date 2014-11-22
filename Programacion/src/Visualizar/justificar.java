/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizar;

/**
 * ALGORITMO JUSTIFICAR TEXTO
 *
 * Selección de justificación de texto: Si pulsa 1 entonces, justificamos a la
 * izquierda(); Si pulsa 2 entonces, justificamos al centro(); Si pulsa 3
 * entonces, justificamos a la derecha(); Si pulsa 4, salimos del programa();
 *
 * Salimos del programa: Cerramos el bucle de la selección Mostrar mensaje de
 * finalización de programa.
 *
 * Justifiación izquierda: Indicamos el path de los ficheros de entrada y de
 * salida. Creamos buffers de entrada y de salida. Cogemos la primera linea
 * mediante el buffer del archivo de texto. mientras no haya acabado escribimos
 * la linea en el archivo pasamos la linea por pantalla salto de linea Repetimos
 * proceso Cerramos buffer Cerramos fichero
 *
 * Control de excepciones()
 *
 * Justificación derecha: * Indicamos el path de los ficheros de entrada y de
 * salida. Creamos buffers de entrada y de salida. Cogemos la primera linea
 * mediante el buffer del archivo de texto. mientras no haya acabado Pasamos la
 * linea por un array Sacamos valor entero del array desde 0 hasta el ancho de
 * linea - valor del array Escribimos espacio (en archivo y en pantalla)
 * escribimos la linea en el archivo pasamos la linea por pantalla salto de
 * linea Repetimos proceso Cerramos buffer Cerramos fichero
 *
 * Control de excepciones()
 *
 * Justifiación central: Indicamos el path de los ficheros de entrada y de
 * salida. Creamos buffers de entrada y de salida. Cogemos la primera linea
 * mediante el buffer del archivo de texto. mientras no haya acabado Pasamos la
 * linea por un array Sacamos valor entero del array desde 0 hasta (el ancho de
 * linea - valor del array)/2 Escribimos espacio (en archivo y en pantalla)
 * escribimos la linea en el archivo pasamos la linea por pantalla desde 0 hasta
 * (el ancho de linea - valor del array)/2 Escribimos espacio (en archivo y en
 * pantalla) salto de linea Repetimos proceso Cerramos buffer Cerramos fichero
 *
 * Control de excepciones()
 *
 *
 * Conrol de excepciones: Capturamos una exception IO y mostramos por pantalla
 * su mensaje
 *
 *
 * @author Pau
 */
import java.io.*;

public class justificar {

    public static final int ANCHO = 100;
    public static final char ESPACIO = ' ';
    public static int longitud = 0;

    public static void main(String[] args) throws IOException { //Este es un subprograma de un pequeño menú de selección.
        char seleccion = 0;
        boolean salir = false;
        try {
            while (!salir) {
                System.out.println("Seleccione la opción que desee: ");
                System.out.println();
                System.out.println("Pulse 1 si desea justificar el texto a la izquierda");
                System.out.println("Pulse 2 si desea justificar el texto al centro");
                System.out.println("Pulse 3 si desea justificar el texto a la derecha");
                System.out.println("Pulse 4 si desea salir");
                System.out.println();
                System.out.print("Seleccion: ");
                seleccion = (char) System.in.read();

                switch (seleccion) {

                    case '1':
                        justificar_texto_izquierda();
                        break;

                    case '2':
                        justificar_texto_centro();//Subprograma justificar texto al centro
                        break;

                    case '3':
                        justificar_texto_derecha();//Justificar texto  a la derecha.
                        break;

                    case '4':
                        salir = true;
                        System.out.println();
                        System.out.println("Programa finalizado.");
                        break;

//                default: System.out.println ("Operacion no reconocida.");
                }
            }
        } catch (Exception e) {
        }
    }

    public static void justificar_texto_izquierda() {
        try {
            FileWriter justificat = new FileWriter("C:/Users/Pau/Desktop/justificat.txt"); //Este es el nuevo fichero, por el que leeremos los resultados.
            FileReader entrada = new FileReader("C:/Users/Pau/Desktop/entrada.txt"); //Y este el de entrada, por el cual nos entra en flujo de datos
            BufferedReader buffer = new BufferedReader(entrada);  //Creamos los buffers de leída y escritura.
            BufferedWriter escribir = new BufferedWriter(justificat);
            String linea = buffer.readLine();  //Un string que se corresponde a la línea del documento.
            while (linea != null) {  //Mientras esta linea no esté vacía.
                escribir.write(linea);  //Escribimos la linea (En el 2º fichero)
                System.out.print(linea); //Sacamos la linea por pantalla
                escribir.write(13);  //Esta secuencia (13 y 10) se corresponde a un salto de linea.
                escribir.write(10);
                System.out.print('\n'); //Lo mismo aquí, sacamos un salto de linea por pantalla.
                linea = buffer.readLine();  //Y volvemos a leer.
            }
            buffer.close();
            escribir.close(); //Lo cerramos todo.
            justificat.close();
        } catch (IOException e) { // Excepción stándar
            System.out.println("Excepcion: " + e.getMessage());

        }
    }

    public static void justificar_texto_derecha() {
        try {
            FileWriter justificat = new FileWriter("C:/Users/Pau/Desktop/justificat.txt");
            FileReader entrada = new FileReader("C:/Users/Pau/Desktop/entrada.txt");
            BufferedReader buffer = new BufferedReader(entrada);
            BufferedWriter escribir = new BufferedWriter(justificat);
            String linea = buffer.readLine();
            while (linea != null) {
                char conjunto[] = linea.toCharArray();  //Aquí pasamos la linea a un array para trabajar mejor con ella.
                longitud = conjunto.length; //Esto saca la medida (int) del array.
                for (int i = 0; i < (ANCHO - longitud); i++) {  //Ponemos espacios en la diferencia entre el ancho predefinido de linea y la linea de caracteres.
                    escribir.write(ESPACIO);
                    System.out.print(ESPACIO);  //Tambien en pantalla.
                }
                escribir.write(conjunto);
                System.out.print(conjunto);
                escribir.write(13);
                escribir.write(10);
                System.out.print('\n');
                linea = buffer.readLine();

            }
            buffer.close();
            escribir.close();
            justificat.close();
        } catch (IOException e) { // Estándar
            System.out.println("Excepcion: " + e.getMessage());

        }
    }

    public static void justificar_texto_centro() {
        try {
            FileWriter justificat = new FileWriter("C:/Users/Pau/Desktop/justificat.txt");
            FileReader entrada = new FileReader("C:/Users/Pau/Desktop/entrada.txt");
            BufferedReader buffer = new BufferedReader(entrada);
            BufferedWriter escribir = new BufferedWriter(justificat);
            String linea = buffer.readLine();
            while (linea != null) {
                char conjunto[] = linea.toCharArray();
                longitud = conjunto.length;
                for (int i = 0; i < (ANCHO - longitud) / 2; i++) {  //Al igual que en justificar a la derecha, aquí pondremos espacios
                    escribir.write(ESPACIO);             // en la primera mitad y en la segunda y en el centro, el texto.
                    System.out.print(ESPACIO);
                }
                escribir.write(conjunto);
                System.out.print(conjunto);
                for (int i = 0; i < (ANCHO - longitud) / 2; i++) {
                    escribir.write(ESPACIO);
                    System.out.print(ESPACIO);
                }
                escribir.write(13);
                escribir.write(10);
                System.out.print('\n');
                linea = buffer.readLine();
            }

            buffer.close();
            escribir.close();
            justificat.close();
        } catch (IOException e) { // Estándar
            System.out.println("Excepcion: " + e.getMessage());
        }
    }
}
