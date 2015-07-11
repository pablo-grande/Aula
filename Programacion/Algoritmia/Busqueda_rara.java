/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmica;

/**
 *
 * @author Pablo Riutort
 */
import java.io.*;
public class Busqueda_rara{
    public static void leerFichero(int[]vector,RandomAccessFile fichero){
        try{
        for (int i=0;i<fichero.length();i++){
        vector[i]=fichero.readInt();
            }
        } catch (Exception e) {
        }
    }


    public static boolean Busqueda_binaria (int vector[], int numero,RandomAccessFile fichero){
        int i=0, mitad, j=vector.length-1;
        do{
            mitad = (i+j)/2;
            if (numero < vector [mitad])
                j=mitad-1;
            else
                i=mitad+1;
        }while ((numero != vector[mitad]) && (i<j));
        return (numero==vector[mitad]);
    }
public static void main(String[]args){
    int[]num={45,3,2,6,43,7,1,23,0,97,2,5,54,76,2,38,19,10,78,34};
    try{
    RandomAccessFile fichero = new RandomAccessFile( "datos.dat","rw" );
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // inicializamos el fichero con algunos valores 'aleatorios'
    for (int i=0;i<num.length;i++){
        fichero.writeInt(num[i]);
    }
    //leemos todos los enteros del fichero y los guardamos en un vector para hacer el tratamiento
    int[]b=new int[(int)fichero.length()];
    leerFichero(b,fichero);
    // realizamos la ordenacion mediante el metodo de la burbuja optimizada
    int k=0;
    int aux;
    boolean seguir=true;
    while((seguir)&&(k<fichero.length())){
        seguir=false;
            for(int j=k+1;j<b.length-1;j++){
            if(b[j]>b[j+1]){
                aux=b[j];
                b[j]=b[k];
                b[k]=aux;
                seguir=true;
            }
            }
        k++;
    }
    //reescribimos los numeros ya ordenados
    fichero.seek(0);
    for (int p=0;p<b.length;p++){
        fichero.writeInt(b[p]);
    }
    //pedimos el numero que se desea buscar
    System.out.print("NÃºmero a buscar en el fichero: ");
    String entrada = in.readLine();
    int numero = Integer.parseInt(entrada);
    if(Busqueda_binaria(b,numero, fichero))//busca el nÃºmero
        System.out.println("El nÃºmero "+numero+" aparece en el fichero");
    else System.out.println("El nÃºmero "+numero+" no aparece en el fichero");
    } catch (Exception e) {}
    }
}
