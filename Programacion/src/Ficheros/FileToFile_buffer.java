/*
 *
 FLUJOS DE CARACTERES. LECTURA DE ARCHIVO DE TEXTO
 LECTURA DE UN FICHERO DE TEXTO A NIVEL DE LINEAS Y ESCRITURA A UN FICHERO DE TEXTO
 */

package Ficheros;

import java.io.*;

public class FileToFile_buffer {
    public static void main(String[] args)  {
        try {
            FileReader fichero1=new FileReader("c:/pruebas/textoViernes.txt");
            BufferedReader buffer1=new BufferedReader(fichero1);
            FileWriter fichero2=new FileWriter("c:/pruebas/viernessalida1.txt");
            BufferedWriter buffer2=new BufferedWriter(fichero2);
            boolean fin=false;
            while (!fin) {
                String linea=buffer1.readLine();
                if (linea == null) fin=true;
                else {
                    buffer2.write(linea);
                    buffer2.newLine();
                }
               
           }
           buffer1.close(); fichero1.close();
           buffer2.close();fichero2.close();
        }catch (IOException e) {}
    }
}