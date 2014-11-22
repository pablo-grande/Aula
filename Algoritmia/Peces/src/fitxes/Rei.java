package fitxes;

/**
 * Classe que indicarà el comportament que té un rei. Obté per herència els mètodes de la classe 'Fitxa'.
 * @author pablo
 */
public class Rei extends FitxaNorm {

    /**
     * Constructor de la classe Rei.
     * @param x Array de coordenades horitzontals dels moviments que pot fer un rei.
     * @param y Array de coordenades verticals dels moviments que pot fer un rei. 
     */
    public Rei(int[] x, int[] y) {
        super(x, y);
    }

    /**
     * Assignació dels moviments que pot fer una rei.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     * @param n Dimensió del tauler.
     */
    @Override
    public void inicialitzar(int[] x, int[] y) {
        int[] s = {-1, -1, -1, 0, 0, 1, 1, 1};
        System.arraycopy(s, 0, x, 0, s.length);
        int[] t = {1, 0, -1, 1, -1, 1, 0, -1};
        System.arraycopy(t, 0, y, 0, t.length);
    }

    /**
     * Mètode que posa el nom de la fitxa a "Rei".
     * @return El nom de la fitxa és "Rei".
     */
    @Override
    public String getNom() {
        String n = "Rei";
        return n;
    }
}
