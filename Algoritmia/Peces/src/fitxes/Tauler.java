package fitxes;

/**
 * Classe que crearà el tauler lògic que farà la funció d'un tauler d'escacs.
 * @author pablo
 */
public class Tauler {

    private CasellaT[][] tauler; //'tauler' serà un array de 'CasellaT'.
    /**
     * Constructor de la classe Tauler. No s'utilitza.
     */
    public Tauler() {
    }

    /**
     * Mètode que inicialitza totes les posicions del tauler a zero i fals.
     * @param t Variable que tendrà les coordenades del tauler.
     * @param n Dimensió del tauler.
     */
    public void iniTauler(CasellaT[][] t, int n) {
        tauler = t;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tauler[i][j] = new CasellaT(0, false);
            }
        }
    }

    /**
     * Mètode que indica el valor d'una casella del tauler.
     * @param i Coordenada horitzontal de la casella a la que es vol accedir.
     * @param j Coordenada vertical de la casella a la que es vol accedir.
     * @return Valor de la casella a la posició (i,j).
     */
    public CasellaT elemPosTauler(int i, int j) {
        return tauler[i][j];
    }

    /**
     * Mètode que assigna a una casella el valor indicat.
     * @param i Coordenada horitzontal de la casella a la que es vol accedir.
     * @param j Coordenada vertical de la casella a la que es vol accedir.
     * @param val Valor enter que s'assignarà a la casella (i,j).
     * @param b Valor booleà que s'assignarà a la casella (i,j).
     */
    public void assignaTauler(int i, int j, int val, boolean b) {
        tauler[i][j] = new CasellaT(val, b);
    }
}
