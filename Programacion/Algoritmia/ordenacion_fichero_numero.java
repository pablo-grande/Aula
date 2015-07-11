/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmica;

/** Dado un fichero de enteros, implementar un programa java que ordene en orden creciente el contenido de dicho fichero.
 *
 * Utilizando el método de ordenación "seleccion directa". El nombre será "numeros.dat"
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class ordenacion_fichero_numero{

    public static void Seleccion_directa(int vector[]){
        int j, aux, menor;
        int dimension = vector.length;

        for (int i=0; i<dimension-1; i++){
            menor=i;
            for (j=i+1; j<dimension; j++){
                if (vector[j]<vector[menor])
                    menor=j;
            }
            aux=vector[i];
            vector[i]=vector[menor];
            vector[menor]=aux;
        }
    }

    public static void main (String[]args) throws IOException {
        int e1,e2,valor_i=0,valor_min;
        RandomAccessFile fichero=new RandomAccessFile ("numeros.dat","rw");
        int N=(int) fichero.length()/4;
        for (int i=0;i<N-1;i++){
            int minimo=i;
            fichero.seek(i*4);
            e1=fichero.readInt();
            valor_min=valor_i;
            //bucle de ordenacion
            for (int j=i+1;j<N;j++){
                fichero.seek(j*4);
                e1=fichero.readInt();

                fichero.seek(minimo*4);
                e2=fichero.readInt();
                //Condicion de ordenacion
                if (e1<e2){
                    minimo=j;
                    valor_min=e1;
                }
            }
            fichero.seek(minimo*4); fichero.writeInt(valor_i);
            fichero.seek(i*4); fichero.writeInt(valor_min);
        }
        fichero.close();
    }
}
