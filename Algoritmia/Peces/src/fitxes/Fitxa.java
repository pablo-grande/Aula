package fitxes;

/**
 * Classe d'on derivaran totes les fitxes que es col·locaran en el tauler.
 * @author pablo
 */
public abstract class Fitxa {

    private int[] coordx;
    private int[] coordy;

    /**
     * Constructor de la classe Fitxa.
     * @param x Array de coordenades horitzontals dels moviments que pot fer una fitxa.
     * @param y Array de coordenades verticals dels moviments que pot fer una fitxa.
     */
    public Fitxa(int[] x, int[] y) {
        coordx = x;
        coordy = y;
    }

    /**
     * Mètode per saber la quantitat de moviments que pot fer una fitxa
     * @return Torna la longitud de l'array de coordenades horitzontals de moviments d'una fitxa, que és igual a la
     * quantitat de moviments en horitzontal que pot fer, que és igual a la quantitat de moviments en vertical que pot fer.
     */
    protected int getMida() {
        return coordx.length;
    }

    /**
     * Mètode per saber el valor d'un element concret de l'array de moviments horitzontals de la fitxa.
     * @param i Index que indica en quina posició es troba l'element cercat.
     * @return Moviment horitzontal[i].
     */
    protected int elementsCoordx(int i) {
        return coordx[i];
    }

    /**
     * Mètode per saber el valor d'un element concret de l'array de moviments verticals de la fitxa.
     * @param i Index que indica en quina posició es troba l'element cercat.
     * @return Moviment vertical[i].
     */
    protected int elementsCoordy(int i) {
        return coordy[i];
    }
    
    /**
     * Mètode que col·loca la fitxa al tauler. Assigna un -1 a la casella actual per indicar que estarà ocupada per una fitxa normal.
     * @param px Coordenada 'x' de la casella actual.
     * @param py Coordenada 'y' de la casella actual.
     * @param t Punter al tauler sobre el que es troba la casella actual.
     */
    public void posaFitxa (int px, int py, Tauler t){
    }
    
    /**
     * Mètode que lleva la fitxa de la casella actual, posant-la a zero i fals.
     * @param lx Coordenada 'x' de la casella actual.
     * @param ly Coordenada 'y' de la casella actual.
     * @param t Punter al tauler sobre el que es troba la casella actual.
     */
    public void llevaFitxa (int lx, int ly, Tauler t){
        t.assignaTauler(lx, ly, 0, false);
    }

    /**
     * Mètode que indica si, col·locant la fitxa a la casella actual, en mataria alguna altra que ja estigui col·locada.
     * @param x Coordenada 'x' de la casella actual.
     * @param y Coordenada 'y' de la casella actual.
     * @param dim Dimensió del tauler.
     * @param t Punter al tauler sobre el que es troba la casella actual.
     * @return Si la fitxa mata o no.
     */
    public boolean mata(int x, int y, int dim, Tauler t) {
        boolean siMata = false;
        return siMata;
    }
    
    /**
     * Mètode que marcarà sobre el tauler totes les caselles a les que la fitxa actual hi pot matar.
     * @param mx Coordenada 'x' de la casella on es troba la fitxa.
     * @param my Coordenada 'y' de la casella on es troba la fitxa.
     * @param dim Dimensió del tauler.
     * @param t Punter al tauler on es realitzen les operacions.
     */
    public void marcar(int mx, int my, int dim, Tauler t) {
    }
    
    /**
     * Mètode que desmarcarà del tauler totes les caselles a les que la fitxa actual hi pot matava.
     * @param dx Coordenada 'x' de la casella on es troba la fitxa.
     * @param dy Coordenada 'y' de la casella on es troba la fitxa.
     * @param dim Dimensió del tauler.
     * @param t Punter al tauler on es realitzen les operacions.
     */
    public void desmarcar(int dx, int dy, int dim, Tauler t) {
    }

    /**
     * Mètode per assignar a la fitxa els moviments que pot fer. L'empraran les fitxes els moviments de les quals depenguin de la dimensió del tauler.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     * @param n Dimensió del tauler (útil per fitxes que es poden moure d'un extrem a l'altre d'aquest).
     */
    public void inicialitzar(int[] x, int[] y, int n) {
    }

    /**
     * Mètode per assignar a la fitxa els moviments que pot fer. L'empraran les fitxes els moviments de les quals no depenguin de la dimensió del tauler.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     */
    public void inicialitzar(int[] x, int[] y) {
    }
    
    /**
     * Mètode que indica el nom de la fitxa.
     * @return El nom de la fitxa.
     */
    public String getNom() {
        String n = "Fitxes";
        return n;
    }
}
