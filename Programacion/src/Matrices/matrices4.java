/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Matrices;

/**
 *
 * @author Pablo Riutort
 */
public class matrices4 {

    public static void main (String[]args) throws Exception{

        int matriz[][]=new int[5][5];
        for (int i=0; i < matriz.length; i++)
        {
            for (int j=0; j<matriz[0].length; j++)
                matriz[i][j]=j;
        }
        for (int i=0; i<matriz.length; i++){
            for (int j=0; j<matriz.length; j++)
                System.out.print("\t"+matriz[i][j]);
            System.out.print("\n");
        }
    }

}
