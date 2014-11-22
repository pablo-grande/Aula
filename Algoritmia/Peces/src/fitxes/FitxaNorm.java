package fitxes;

/**
 * Classe filla de 'FitxesQueMaten' que englobarà les fitxes tradicionals d'escacs.
 * @author pablo
 */
public abstract class FitxaNorm extends FitxesQueMaten {
    /**
     * Constructor de la classe FitxaNorm
     * @param x Array de coordenades horitzontals dels moviments que pot fer una fitxa.
     * @param y Array de coordenades verticals dels moviments que pot fer una fitxa.
     */
    public FitxaNorm(int[] x, int[] y) {
        super(x, y);
    }
    
    /**
     * Mètode que col·loca la fitxa al tauler. Assigna un -1 a la casella actual per indicar que estarà ocupada per una fitxa normal.
     * @param px Coordenada 'x' de la casella actual.
     * @param py Coordenada 'y' de la casella actual.
     * @param t Punter al tauler sobre el que es troba la casella actual.
     */
    @Override
    public void posaFitxa (int px, int py, Tauler t){
        t.assignaTauler(px, py, -1, false);
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

}
