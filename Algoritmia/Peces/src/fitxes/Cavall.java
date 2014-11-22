package fitxes;

/**
 * Classe que indicarà el comportament que té un cavall. Obté per herència els mètodes de la classe 'Fitxa'.
 * @author pablo
 */
public class Cavall extends FitxaNorm {

    /**
     * Constructor de la classe Cavall.
     * @param x Array de coordenades horitzontals dels moviments que pot fer un cavall.
     * @param y Array de coordenades verticals dels moviments que pot fer un cavall. 
     */
    public Cavall(int[] x, int[] y) {
        super(x, y);
    }

    /**
     * Assignació dels moviments que pot fer un cavall.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     */
    @Override
    public void inicialitzar(int[] x, int[] y) {
        int[] s = {-2, -2, -1, -1, 1, 1, 2, 2};
        System.arraycopy(s, 0, x, 0, s.length);
        int[] t = {1, -1, 2, -2, 2, -2, 1, -1};
        System.arraycopy(t, 0, y, 0, t.length);
    }

    /**
     * Mètode que posa el nom de la fitxa a "Cavall".
     * @return El nom de la fitxa és "Cavall".
     */
    @Override
    public String getNom() {
        String n = "Cavall";
        return n;
    }
}
