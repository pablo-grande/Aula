/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vuitreines.escacs;

/**
 * Classe d'on derivaran totes les fitxes que es col·locaran en el tauler, en aquest cas, reines.
 * @author Pablo Riutort
 */
public abstract class Fitxa {
    private int[] coordx;
    private int[] coordy;
    /**
     * Constructor de la classe Fitxa.
     * @param x Array de coordenades horitzontals dels moviments que pot fer una fitxa.
     * @param y Array de coordenades verticals dels moviments que pot fer una fitxa.
     */
    public Fitxa (int[] x, int[] y){
        coordx=x;
        coordy=y;
    }
    /**
     * Mètode per saber la quantitat de moviments que pot fer una fitxa
     * @return Torna la longitud de l'array de coordenades horitzontals de moviments d'una fitxa, que és igual a la
     * quantitat de moviments en horitzontal que pot fer, que és igual a la quantitat de moviments en vertical que pot fer.
     */
    public int getMida (){
        return coordx.length;
    }
    /**
     * Mètode per saber el valor d'un element concret de l'array de moviments horitzontals de la fitxa.
     * @param i Index que indica en quina posició es troba l'element cercat.
     * @return Moviment horitzontal[i].
     */
    public int elementsCoordx(int i){
            return coordx[i];
    }
    /**
     * Mètode per saber el valor d'un element concret de l'array de moviments verticals de la fitxa.
     * @param i Index que indica en quina posició es troba l'element cercat.
     * @return Moviment vertical[i].
     */
    public int elementsCoordy(int i){
            return coordy[i];
    }
    /**
     * Mètode per assignar a la fitxa els moviments que pot fer.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     * @param n Dimensió del tauler (útil per fitxes que es poden moure d'un extrem a l'altre d'aquest).
     */
    public void inicialitzar (int[] x, int[] y, int n){
    }
    /**
     * Mètode que indica el nom de la fitxa.
     * @return El nom de la fitxa.
     */
    public String getNom(){
        String n = "FITXES";
        return n;
    }
}