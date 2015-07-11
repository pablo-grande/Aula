package braille;

import java.io.*;

/**
 * 
Prof. Montes de Oca:
1. por linea de comando, a través del netbeans, y en este caso existen 3 posibilidades: 
a. línea de comando con dos argumentos, en tal caso, ambos argumentos se corresponderán con el nombre(path incluido o no, dependerá de tí) de los ficheros de entrada y de salida respectivamente. 
b. linea de comando con un argumento, en tal caso, el argumento se corresponderá con el fichero de entrada y para el fichero de salida la aplicación solicitará al usuario los datos del fichero de salida. 
c. linea de comando sin argumentos, y en este caso, los nombres de los ficheros de entrada y salida serán los de defecto, es decir, entrada.txt y salida.txt.

2. a través de la ejecución interactiva de netbeans. En este caso los nonbres de los ficheros de entrada y salida serán los de defecto.
 *
 * @author Pablo
 */
public class Setembre {

    /**
     * Capturamos los argumentos y determinamos qué tipo de codificación se llevará a cabo
     * @param args Cada argumento corresponde con el nombre de los archivos de texto que utiliza la práctica
     * @see Menu
     */
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        
//En el siguiente switch separamos la ejecución de la aplicación en función del número de argumentos que tengamos

        switch (args.length) {
            case 0:
                //Caso de ningún argumento
                menu.menu();
                break;
            case 1:
                //Caso de un argumento
                menu.menu(args[0]);
                break;
            case 2:
                //Caso de dos argumentos
                menu.menu(args[0], args[1]);
                break;
            default:
                System.out.println("El número de argumentos introducidos no es correcto");
        }
    }
}
