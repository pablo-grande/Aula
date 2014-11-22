/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Matrices;
import java.io.*;
/**
 *
 * @author Pablo Riutort
 */
public class ContenidoMatrices {

    public static void main (String[]args){
        try{
        BufferedReader buffer = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("Numero de componentes: ");
        int n=Integer.parseInt(buffer.readLine());
        int [] vector=new int[n];
        for (int k=0;k<n;k++){
            System.out.print ("Posición numero" +(k+1)+":");
            vector[k]=Integer.parseInt(buffer.readLine());
    }
    for (int k=0;k<n;k++)
        System.out.println("Contenido posición" + (k+1)+"es"+ vector[k]);
    }catch (Exception e){}
}
}