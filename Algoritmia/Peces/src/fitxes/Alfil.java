/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxes;

/**
 * Classe que indicarà el comportament que té un alfil. Obté per herència els mètodes de la classe 'Fitxa'.
 * @author pablo
 */
public class Alfil extends FitxaNorm {

    /**
     * Constructor de la classe Alfil.
     * @param x Array de coordenades horitzontals dels moviments que pot fer un alfil.
     * @param y Array de coordenades verticals dels moviments que pot fer un alfil. 
     */
    public Alfil(int[] x, int[] y) {
        super(x, y);
    }

    /**
     * Assignació dels moviments que pot fer un alfil.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     * @param n Dimensió del tauler.
     */
    @Override
    public void inicialitzar(int[] x, int[] y, int n) {
        int z = 0;
        for (int i = -(n - 1); i < n; i++) { //En diagonal, s'ha de poder moure en sentit sud-est de la primera casella a la darrera i viceversa.
            x[z] = i;
            y[z] = i;
            z++;
        }
        for (int i = -(n - 1); i < n; i++) { //En diagonal, s'ha de poder moure en sentit nord-est de la primera casella a la darrera i viceversa.
            x[z] = i;
            y[z] = -i;
            z++;
        }
    }

    /**
     * Mètode que posa el nom de la fitxa a "Alfil".
     * @return El nom de la fitxa és "Alfil".
     */
    @Override
    public String getNom() {
        String n = "Alfil";
        return n;
    }
}
