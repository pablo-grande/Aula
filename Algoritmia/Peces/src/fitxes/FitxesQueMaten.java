package fitxes;

/**
 * Classe filla de 'Fitxa' que englobarà totes les fitxes que tenen la capacitat de matar-ne d'altres.
 * @author pablo
 */
public abstract class FitxesQueMaten extends Fitxa{
    /**
     * Constructor de la classe fitxes que maten
     * @param x Array de coordenades horitzontals dels moviments que pot fer una fitxa.
     * @param y Array de coordenades verticals dels moviments que pot fer una fitxa.
     */
    public FitxesQueMaten(int[] x, int[] y) {
        super(x, y);
    }
    
    /**
     * Mètode que marcarà sobre el tauler totes les caselles a les que la fitxa actual hi pot matar. Per fer-ho, suma 1 a les caselles on mata.
     * @param mx Coordenada 'x' de la casella on es troba la fitxa.
     * @param my Coordenada 'y' de la casella on es troba la fitxa.
     * @param dim Dimensió del tauler.
     * @param t Punter al tauler on es realitzen les operacions.
     */
    @Override
    public void marcar(int mx, int my, int dim, Tauler t) {
        int possegx;
        int possegy;
        for (int movFig = 0; movFig < this.getMida(); movFig++) {
            possegx = mx + this.elementsCoordx(movFig); //'possegx' tendrà el resultat de la suma de 'mx' i un dels moviments de la fitxa.
            possegy = my + this.elementsCoordy(movFig); //'possegy' tendrà el resultat de la suma de 'my' i un dels moviments de la fitxa.
            if (possegx >= 0 && possegx < dim && possegy >= 0 && possegy < dim && t.elemPosTauler(possegx, possegy).valorCas() != -1) {
                t.assignaTauler(possegx, possegy, t.elemPosTauler(possegx, possegy).valorCas() + 1, false); //Se suma 1 a la casella actual,
                                                                                                            // per indicar que està ocupada.
            }
        }
    }
    
    /**
     * Mètode que desmarcarà del tauler totes les caselles a les que la fitxa actual hi pot matava.
     * @param dx Coordenada 'x' de la casella on es troba la fitxa.
     * @param dy Coordenada 'y' de la casella on es troba la fitxa.
     * @param dim Dimensió del tauler.
     * @param t Punter al tauler on es realitzen les operacions.
     */
    @Override
    public void desmarcar(int dx, int dy, int dim, Tauler t) {
        int possegx;
        int possegy;
        for (int movFig = 0; movFig < this.getMida(); movFig++) {
            possegx = dx + this.elementsCoordx(movFig); //'possegx' tendrà el resultat de la suma de 'dx' i un dels moviments de la fitxa.
            possegy = dy + this.elementsCoordy(movFig); //'possegy' tendrà el resultat de la suma de 'dy' i un dels moviments de la fitxa.
            if (possegx >= 0 && possegx < dim && possegy >= 0 && possegy < dim
                    && t.elemPosTauler(possegx, possegy).valorCas() != 0 && t.elemPosTauler(possegx, possegy).valorCas() != -1) {
                t.assignaTauler(possegx, possegy, t.elemPosTauler(possegx, possegy).valorCas() - 1, false); //Se suma 1 a la casella actual,
                                                                                                            // per indicar que està ocupada.
            }
        }
    }
}
