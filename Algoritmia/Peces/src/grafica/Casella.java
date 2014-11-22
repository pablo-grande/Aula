package grafica;

import java.awt.*;
import javax.swing.*;

/**
 * Classe on es creen les caselles del tauler gràfic.
 * @author pablo
 */
public class Casella extends JPanel {

    private int x; //Coordenada 'x'  de la casella.
    private int y; //Coordenada 'y' de la casella.
    private int dim; //Dimensió de la casella.
    private Image img; //Imatge que es col·locarà sobre la casella.

    /**
     * Constructor de la classe Casella.
     * @param cx Coordenada horitzontal de la casella.
     * @param cy Coordenada vertical de la casella.
     * @param tamany Dimensió de la casella.
     */
    public Casella(int cx, int cy, int tamany) {
        x = cx; //Coordenada 'x'  de la casella.
        y = cy; //Coordenada 'y' de la casella.
        dim = tamany; //Dimensió de la casella.
        img = null; //Imatge que es col·locarà sobre la casella.
        this.setBackground(null); //Inicialment, la casella no tendrà color de fons.
    }

    /**
     * Mètode per pintar una imatge.
     */
    @Override
    public void paint(Graphics graf) {
        super.paint(graf);
        if (img != null) {
            graf.drawImage(img, 0, 0, dim, dim, this);
        }
    }

    /**
     * Mètode que crida a paint().
     */
    @Override
    public void repaint() {
        Graphics graf = this.getGraphics();
        if (graf != null) {
            paint(graf);
        }
    }

    /**
     * Mètode que esbora la imatge de la casella.
     */
    public void esborra() {
        img = null;
        repaint();
    }

    /**
     * Mètode que posa la imatge triada a la casella.
     * @param i La imatge que es vol posar.
     */
    public void posaImg(Image i) {
        img = i;
        repaint();
    }

    /**
     * Mètode que assigna a la casella una coordenada horitzontal.
     * @param i Coordenada que es vol assignar.
     */
    public void setX(int i) {
        x = i;
    }

    /**
     * Mètode que assigna a la casella una coordenada vertical.
     * @param i Coordenada que es vol assignar.
     */
    public void setY(int i) {
        y = i;
    }

    /**
     * Funció que retorna la coordenada horitzontal de la casella.
     * @return La corrdenada horitzontal de la casella.
     */
    public int xCas() {
        return x;
    }

    /**
     * Funció que retorna la coordenada vertical de la casella.
     * @return La corrdenada vertical de la casella.
     */
    public int yCas() {
        return y;
    }
}
