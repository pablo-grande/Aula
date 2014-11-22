package fitxes;

/**
 * Classe que indicarà el comportament que té una fitxa 'professor'. Obté per herència els mètodes de la classe 'Fitxa'.
 * La fitxa 'professor' es pot moure a qualsevol casella que estigui lliure, i té els mateixos moviments que una reina, però
 * només mata a fitxes 'alumne' i a altres fitxes 'professor', per rivalitat.
 * @author pablo
 */
public class Aguila extends FitxesQueMaten {

    /**
     * Constructor de la classe Professor.
     * @param x Array de coordenades horitzontals dels moviments que pot fer una reina.
     * @param y Array de coordenades verticals dels moviments que pot fer una reina. 
     */
    public Aguila(int[] x, int[] y) {
        super(x, y);
    }

    /**
     * Assignació dels moviments que pot fer una fitxa 'professor'.
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
//        for (int i = -(n - 1); i < n; i++) { //En diagonal, s'ha de poder moure en sentit sud-est de la primera casella a la darrera i viceversa.
//            x[z] = i;
//            y[z] = i;
//            z++;
//        }
        for (int i = -(n - 1); i < n; i++) { //En diagonal, s'ha de poder moure en sentit nord-est de la primera casella a la darrera i viceversa.
            x[z] = i;
            y[z] = -i;
            z++;
        }
    }

    /**
     * Mètode que col·loca la fitxa al tauler. Assigna -1 i vertader a la casella actual per indicar que estarà ocupada per una fitxa alumne o professor.
     * @param px Coordenada 'x' de la casella actual.
     * @param py Coordenada 'y' de la casella actual.
     * @param t Punter al tauler sobre el que es troba la casella actual.
     */
    @Override
    public void posaFitxa(int px, int py, Tauler t) {
        t.assignaTauler(px, py, -1, true);
    }

    /**
     * Mètode que indica si, col·locant la fitxa a la casella actual, en mataria alguna altra que ja estigui col·locada.
     * @param cx Coordenada x de la casella actual.
     * @param cy Coordenada y de la casella actual.
     * @param dim Dimensió del tauler.
     * @param t Punter al tauler sobre el que es troba la casella actual.
     * @return Si la fitxa mata o no.
     */
    @Override
    public boolean mata(int cx, int cy, int dim, Tauler t) {
        boolean siMata = false;
        int px;
        int py;
        int mov = 0;
        while (mov < this.getMida() && !siMata) {
            px = cx + this.elementsCoordx(mov); //'px' tendrà el resultat de la suma de 'cx' i un dels moviments de la fitxa.
            py = cy + this.elementsCoordy(mov); //'py' tendrà el resultat de la suma de 'cy' i un dels moviments de la fitxa.
            if (px >= 0 && px < dim && py >= 0 && py < dim) {
                if (t.elemPosTauler(px, py).valorCas() == -1) {
                    siMata = true;
                }
            }
            mov++;
        }
        return siMata;
    }

    /**
     * Mètode que posa el nom de la fitxa a "Aguila".
     * @return El nom de la fitxa és "Aguila".
     */
    @Override
    public String getNom() {
        String n = "Aguila";
        return n;
    }
}
