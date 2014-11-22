/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vuitreines.escacs;

/**
 * Classe que farà la funció d'un tauler d'escacs.
 * @author Pablo Riutort
 */
public class Tauler {
    private int[][] tauler;
    public Tauler(){
    }
    /**
     * Mètode que inicialitza totes les posicions del tauler a zero.
     * @param t Variable que tendrà les coordenades del tauler.
     * @param n Dimensió del tauler.
     */
    public void iniTauler(int[][] t, int n){
        tauler=t;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                t[i][j]=0;
            }
        }
    }
    /**
     * Mètode que indica el valor d'una casella del tauler.
     * @param i Coordenada horitzontal de la casella a la que es vol accedir.
     * @param j Coordenada vertical de la casella a la que es vol accedir.
     * @return Valor de la casella a la posició (i,j).
     */
    public int elemPosTauler(int i, int j){
        return tauler[i][j];
    }
    /**
     * Mètode que assigna a una casella el valor indicat.
     * @param i Coordenada horitzontal de la casella a la que es vol accedir.
     * @param j Coordenada vertical de la casella a la que es vol accedir.
     * @param val Valor que s'assignarà a la casella (i,j).
     */
    public void assignaTauler(int i, int j, int val){
        tauler[i][j]=val;
    }
}