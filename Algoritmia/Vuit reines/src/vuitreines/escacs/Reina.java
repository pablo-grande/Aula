/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vuitreines.escacs;

/**
 * Classe que indicarà el comportament que té una reina. Obté per herència els mètodes de la classe 'Fitxa'.
 * @author Pablo Riutort
 */
public class Reina extends Fitxa{
    /**
     * Constructor de la classe Reina.
     * @param x Array de coordenades horitzontals dels moviments que pot fer una reina.
     * @param y Array de coordenades verticals dels moviments que pot fer una reina. 
     */
    public Reina (int[] x, int[] y) {
        super(x,y);
    }
    /**
     * Assignació dels moviments que pot fer una reina.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     * @param n Dimensió del tauler.
     */
    @Override
    public void inicialitzar (int[] x, int[] y, int n){
        int z=0;
        for(int i=-(n-1); i<n; i++){ //En vertical, s'ha de poder moure de la primera fila a la darrera i viceversa.
            x[z]=0;
            y[z]=i;
            z++;
        }
        for(int i=-(n-1); i<n; i++){ //En horitzontal, s'ha de poder moure de la primera columna a la darrera i viceversa.
            x[z]=i;
            y[z]=0;
            z++;
        }
        for(int i=-(n-1); i<n; i++){ //En diagonal, s'ha de poder moure en sentit sud-est de la primera casella a la darrera i viceversa.
            x[z]=i;
            y[z]=i;
            z++;
        }
        for(int i=-(n-1); i<n; i++){ //En diagonal, s'ha de poder moure en sentit nord-est de la primera casella a la darrera i viceversa.
            x[z]=i;
            y[z]=-i;
            z++;
        }
    }
    /**
     * Mètode que posa el nom de la fitxa a "REINA".
     * @return El nom de la fitxa és "REINA".
     */
    @Override
    public String getNom(){
        String n = "REINA";
        return n;
    }
}
