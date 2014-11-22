package fitxes;

/**
 * Classe que indicarà el comportament que té una torre. Obté per herència els mètodes de la classe 'Fitxa'.
 * @author pablo
 */
public class Torre extends FitxaNorm {

    /**
     * Constructor de la classe Reina.
     * @param x Array de coordenades horitzontals dels moviments que pot fer una torre.
     * @param y Array de coordenades verticals dels moviments que pot fer una torre. 
     */
    public Torre(int[] x, int[] y) {
        super(x, y);
    }

    /**
     * Assignació dels moviments que pot fer una torre.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     * @param n Dimensió del tauler.
     */
    @Override
    public void inicialitzar(int[] x, int[] y, int n) {
        int z = 0;
        for (int i = -(n - 1); i < n; i++) { //En vertical, s'ha de poder moure de la primera fila a la darrera i viceversa.
            x[z] = 0;
            y[z] = i;
            z++;
        }
        for (int i = -(n - 1); i < n; i++) { //En horitzontal, s'ha de poder moure de la primera columna a la darrera i viceversa.
            x[z] = i;
            y[z] = 0;
            z++;
        }
    }

    /**
     * Mètode que posa el nom de la fitxa a "Torre".
     * @return El nom de la fitxa és "Torre".
     */
    @Override
    public String getNom() {
        String n = "Torre";
        return n;
    }
}
