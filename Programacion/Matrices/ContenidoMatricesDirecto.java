/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrices;


/**
 *
 * @author Pablo Riutort
 */
public class ContenidoMatricesDirecto {

    public static void main(String[] args) {

        int matriz[][] = new int[3][3];

        matriz[0][0]=2;
        matriz[0][1]=4;
        matriz[0][2]=4;
        matriz[1][0]=6;
        matriz[1][1]=6;
        matriz[1][2]=9;
        matriz[2][0]=8;
        matriz[2][1]=10;
        matriz[2][2]=12;

                for (int x=0; x < matriz.length; x++){
                    for (int y=0; y<matriz[x].length; y++)
                        System.out.print(matriz[x][y]+" ");
                    System.out.println("");
                }
    }
}