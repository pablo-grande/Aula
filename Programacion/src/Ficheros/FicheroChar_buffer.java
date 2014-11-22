/*
 * FLUJOS DE CARACTERES. LECTURA DE ARCHIVO DE TEXTO
 * LECTURA DE UN FICHERO DE TEXTO CARACTER A CARACTER
 */

package Ficheros;

import java.io.*;

public class FicheroChar_buffer {
    public static void main(String[] args) throws Exception  {
            FileReader fichero=new FileReader("c:/pruebas/textoViernes.txt");
            BufferedReader buffer=new BufferedReader(fichero);
            int entrada;
            while ((entrada=buffer.read())!=-1) {
                 System.out.print((char)entrada);
            }
            buffer.close();
            fichero.close();
    }

}
