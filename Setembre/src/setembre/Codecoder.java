package setembre;

import java.io.*;

/**
 * Esta clase permite codificar o decodificar según las normas establecidas para
 * la práctica y en ambos casos, deja la información resultante a disposición
 * del usuario.
 *
 * @author Pablo
 */
public class Codecoder {

    //String linea1, linea2, linea3;
    String linea1 = "";
    String linea2 = "";
    String linea3 = "";
    //Un string para capturar la entrada del teclado
    String entrada;
    //Un array para poder tratarlo más cómodamente.
    char array[];
    //Una instancia de la clase alfabeto para poder efectuar las comparaciones
    Alfabeto alfa = new Alfabeto();
    //El siguiente booleano nos indica si es la primera vez que codificamos un numero
    static boolean primera = true; //Como un semáforo.
    static final char blanco = ' ';

    public Codecoder() {
    }

    /**
     * Dado un archivo de entrada y otro de salido, codifica el alfabeto de la
     * entrada en braille y el resultado lo pone en salida
     *
     * @param entrada nombre del archivo que contiene el texto inicial
     * @param salida nombre del archivo que contendrá el texto codificado
     */
    public void codificador_archivo(String entrada, String salida) {
        try {
            //Declaramos los strings que pertenecen al path de los archivos de entrada y salida
            //Cada string está conformado por el path del directorio de trabajo actual + / + String (entrada, salida)
            //Por esto es IMPORTANTE que tanto el archivo de entrada como el de salida, se encuentren el mismo directorio
            //donde se ejecuta el programa.

            String path_entrada = System.getProperty("user.dir") + "/" + entrada;
            String path_salida = System.getProperty("user.dir") + "/" + salida;


            FileWriter salida_fichero = new FileWriter(path_salida); //Este es el nuevo fichero, por el que leeremos los resultados.
            FileReader entrada_fichero = new FileReader(path_entrada); //Y este el de entrada, por el cual nos entra en flujo de datos
            BufferedReader buffer = new BufferedReader(entrada_fichero);  //Creamos los buffers de leída y escritura.
            BufferedWriter escribir = new BufferedWriter(salida_fichero);
            String linea = buffer.readLine();  //Un string que se corresponde a la línea del documento.
            array = linea.toCharArray();

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < alfa.alfabeto.length; j++) {
                    //Esto es, para cada una de las letras, comparamos con
                    // con todas las letras del abecedario

                    if (array[i] == alfa.alfabeto[j].getNumerico()) {
                        //Si es un numérico
                        if (primera == true) {
                            //Es la primera vez que codificamos un numero
                            //La siguiente codificación del símbolo numérico solo debe ejecutarse esta vez.

                            //El código para los numéricos.
                            getMatrix(alfa.alfabeto[29].getBraille());

                            //Dejamos la variable a false, para siguientes veces.
                            primera = false;
                        }


                        //Leemos la letra
                        getMatrix(alfa.alfabeto[j].getBraille());



                    } else if (array[i] == ' ') {
                        //Si es blanco, codificamos un blanco
                        getMatrix(alfa.alfabeto[30].getBraille());
                        break;


                    } else if (array[i] == alfa.alfabeto[j].getMayuscula()) {
                        //Si es una mayúscula

                        //El código para las mayúsculas.
                        getMatrix(alfa.alfabeto[28].getBraille());
                        //Y la letra que sigue
                        getMatrix(alfa.alfabeto[j].getBraille());

                    } else if (array[i] == alfa.alfabeto[j].getMinuscula()) {
                        //Si es una letra minuscula

                        //Codificamos la letra
                        getMatrix(alfa.alfabeto[j].getBraille());
                        break;

                    }
                }
            }

            escribir.write(linea1);
            //Esta secuencia (13 y 10) se corresponde a un salto de linea.
            escribir.write(13);
            escribir.write(10);


            escribir.write(linea2);
            //Esta secuencia (13 y 10) se corresponde a un salto de linea.
            escribir.write(13);
            escribir.write(10);


            escribir.write(linea3);
            //Esta secuencia (13 y 10) se corresponde a un salto de linea.
            escribir.write(13);
            escribir.write(10);


            /*
             * Se cierran los flujos de datos antes de que el programa pueda escribir las lineas
             */

            buffer.close();
            escribir.close();
            salida_fichero.close();
            entrada_fichero.close();


        } catch (FileNotFoundException e) {
            System.out.println("Excepción de fichero no existente");
            System.out.println("Excepción: " + e.getMessage());

        } catch (Exception e) { // Excepción stándar
            System.out.println("Excepción: " + e.getMessage());
        }
    }

    public void decodificador_archivo(String entrada, String salida) {
        try {

            //Declaramos los strings que pertenecen al path de los archivos de entrada y salida
            //Cada string está conformado por el path del directorio de trabajo actual + / + String (entrada, salida)
            //Por esto es IMPORTANTE que tanto el archivo de entrada como el de salida, se encuentren el mismo directorio
            //donde se ejecuta el programa.

            String path_entrada = System.getProperty("user.dir") + "/" + entrada;
            String path_salida = System.getProperty("user.dir") + "/" + salida;

            FileWriter salida_fichero = new FileWriter(path_salida); //Este es el nuevo fichero, por el que leeremos los resultados.
            FileReader entrada_fichero = new FileReader(path_entrada); //Y este el de entrada, por el cual nos entra en flujo de datos
            BufferedReader buffer = new BufferedReader(entrada_fichero);  //Creamos los buffers de leída y escritura.
            BufferedWriter escribir = new BufferedWriter(salida_fichero);

            boolean minuscula = true;
            boolean numerico = false;

            //Esta serie de strings corresponden a cada linea del código braille (que se codifica con 3)
            String linea = buffer.readLine();
            String linea2 = buffer.readLine();
            String linea3 = buffer.readLine();

            String lineadef = "";

            for (int i = 0; i < linea.length(); i = i + 2) {
                lineadef += linea.substring(i, i + 2) + linea2.substring(i, i + 2) + linea3.substring(i, i + 2);

               // System.out.println(alfa.alfabeto[28].getString());
                for (int j = 0; j < alfa.alfabeto.length; j++) {

                    if (lineadef.equals(alfa.alfabeto[j].getString())) {
                        if (j == 28) {
                            //es mayúscula
                            minuscula = false;
                            
                        } else if (j == 29) {
                            //es numérico
                            numerico = true;

                        } else if (j == 30) {
                            //es carácter blanco
                            numerico = false;

                        } else {

                            if (!minuscula) {
                                //Si es mayúscula, debemos coger la letra mayúscula a la cual corresponda
                                escribir.write(alfa.alfabeto[j].getMayuscula());
                                minuscula = true;
                                break;
                            }

                            if (numerico) {

                                escribir.write(alfa.alfabeto[j].getNumerico());

                            }
                            else{

                            escribir.write(alfa.alfabeto[j].getMinuscula());
                            }
                        }
                    }
                }
                lineadef = "";
            }

            //Lo cerramos todo
            buffer.close();
            escribir.close();
            salida_fichero.close();
            entrada_fichero.close();
        } catch (FileNotFoundException e) {
            System.out.println("Excepción: " + e.getMessage());

        } catch (Exception e) { // Excepción stándar
            System.out.println("Excepción: " + e.getMessage());
        }
    }

    /**
     * Este sencillo método nos pasa las coordenadas de la matriz de braille a
     * líneas (3 líneas) Este método es el puente entre la matriz de braille
     * construida por el programa y el output en líneas de texto.
     *
     * @param braille Una matriz de braille que viene por parámetro
     */
    public void getMatrix(char[][] braille) {

        for (int i = 0; i < 2; i++) {

            linea1 += braille[0][i];
            linea2 += braille[1][i];
            linea3 += braille[2][i];

        }
    }
}
