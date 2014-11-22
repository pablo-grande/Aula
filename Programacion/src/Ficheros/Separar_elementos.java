/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ficheros;

/**
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class Separar_elementos {

    public static void main (String [] args) throws IOException{
        char car;
        final char FINAL_SECUENCIA='.';
            FileInputStream fichero=new FileInputStream("C:/Users/Usuario/Desktop/UIB/Programación/enter.txt");
            FileWriter vocales =new FileWriter ("C:/Users/Usuario/Desktop/UIB/Programación/vocales.txt");
            FileWriter consonantes =new FileWriter ("C:/Users/Usuario/Desktop/UIB/Programación/consonantes.txt");
        

            int entrada=fichero.read();
            while (entrada!=-1){
                car=((char)entrada);
                if ((char)entrada!=' '){
                    if ((car=='a')||(car=='e')||(car=='i')||(car=='o')||(car=='u')){
                            vocales.write(car);}
                else
                        consonantes.write(car);
                }
                entrada=fichero.read();
            }
            fichero.close();
            vocales.close();
            consonantes.close();

    }

    }

