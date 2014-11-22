/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxes;

/**
 * Classe que indicarà el comportament que té una fitxa 'alumne'. Obté per herència els mètodes de la classe 'Fitxa'.
 * Una fitxa 'alumne' només es pot moure una casella en vertical o en horitzontal, i no mata ningú. És a dir, és una fitxa
 * que només ocupa espai sobre el tauler.
 * @author pablo
 */
public class Escut extends Fitxa {

    /**
     * Constructor de la classe 'alumne'.
     * @param x Array de coordenades horitzontals dels moviments que pot fer una reina.
     * @param y Array de coordenades verticals dels moviments que pot fer una reina. 
     */
    public Escut(int[] x, int[] y) {
        super(x, y);
    }

    /**
     * Assignació dels moviments que pot fer una fitxa 'alumne'.
     * @param x Array de coordenades horitzontals dels moviments que pot fer.
     * @param y Array de coordenades verticals dels moviments que pot fer.
     */
    @Override
    public void inicialitzar(int[] x, int[] y) {
        int[] s = {-1, 0, 0, 1};
        System.arraycopy(s, 0, x, 0, s.length);
        int[] t = {0, 1, -1, 0};
        System.arraycopy(t, 0, y, 0, t.length);
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
     * Mètode que posa el nom de la fitxa a "Escut".
     * @return El nom de la fitxa és "Escut".
     */
    @Override
    public String getNom() {
        String n = "Shield";
        return n;
    }
}
