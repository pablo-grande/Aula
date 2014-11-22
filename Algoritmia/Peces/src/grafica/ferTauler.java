package grafica;

import practicafinal.*;
import fitxes.*;
import java.awt.*;
import javax.swing.*;

/**
 * Classe que crea un tauler de les dimensions especificades.
 * @author pablo
 */
public class ferTauler extends JPanel {

    private Tauler tLogic;
    private Visualitzacions v;
    private PracticaFinal pf;
    private Fitxa f;
    private JPanel finestra;
    private Casella[][] vecCas;
    private Dimension tauDim;
    private int n;
    private Color marroClar;
    private Color marroFosc;
    private boolean manual;
    private int xAnt;
    private int yAnt;
    private boolean fitxaPosada;

    /**
     * Constructor de la classe. Crea el tauler gràfic.
     * @param dim Dimensió del tauler (dim*dim).
     * @param prac Referència a la classe PracticaFinal
     */
    public ferTauler(int dim, PracticaFinal prac) {
        manual = false;
        pf = prac;
        v = pf.getVis();
        n = v.getDim();
        finestra = new JPanel();
        Dimension dimTauler = new Dimension(altPantalla(), altPantalla());
        this.add(finestra, BorderLayout.EAST);
        finestra.setPreferredSize(dimTauler);
        finestra.setLayout(new GridLayout(dim, dim));
        tauDim = new Dimension((int) (altPantalla() * 0.93), (int) (altPantalla() * 0.93));
        finestra.setPreferredSize(tauDim);
        vecCas = new Casella[dim][dim];
        marroClar = new Color(205, 170, 125);
        marroFosc = new Color(92, 51, 23);
        /*
         * Dins aquests for es pintarà el tauler.
         */
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                JPanel tauler = new JPanel(new GridLayout());
                ferVecCas(dim, i, j);
                vecCas[i][j].setX(i);
                vecCas[i][j].setY(j);
                tauler.add(vecCas[i][j]);
                finestra.add(tauler);
                if ((i + j) % 2 == 0) { //Condició per pintar una casella de marró fosc.
                    tauler.setBackground(marroFosc);
                } else { //Condició per pintar una casella de marró clar.
                    tauler.setBackground(marroClar);
                }
            }
        }
    }

    /**
     * Mètode que col·loca una imatge a la casella triada.
     * @param i Coordenada x de la casella.
     * @param j Coordenada y de la casella.
     * @param s La imatge a col·locar.
     */
    public void posarImg(int i, int j, String s) {
        vecCas[i][j].posaImg(llegirImg(finestra, s));
    }

    /**
     * Mètode que esborra una imatge de la casella triada.
     * @param i Coordenada x de la casella.
     * @param j Coordenada y de la casella.
     */
    public void esborrarImg(int i, int j) {
        vecCas[i][j].esborra();
    }

    /**
     * Mètode que crea un vector de caselles.
     * @param dim Dimensió del tauler.
     * @param x Coordenada x de la casella.
     * @param y Coordenada y de la casella.
     */
    private void ferVecCas(int dim, int x, int y) {
        vecCas[x][y] = new Casella(x / dim, y / dim, (int) (altPantalla() * 0.93) / dim);
    }

    /**
     * Mètode que pren una imatge des d'una carpeta del sistema.
     * @return La imatge llegida.
     */
    private Image llegirImg(JPanel panell, String nom) {
        Image img = null;
        try {
            img = Toolkit.getDefaultToolkit().getImage("src/" + nom + ".png");
            MediaTracker mt = new MediaTracker(panell);
            mt.addImage(img, 0);
            mt.waitForID(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    /**
     * Mètode que pren l'alt de la pantalla. Com que les pantalles sempre són més amples que altes, ens asseguram de prendre la dimensió menor.
     * @return L'alt de la pantalla al 83% (així es deixa espai per la barra de botons del sistema operatiu).
     */
    private int altPantalla() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamany = tk.getScreenSize();
        return ((int) (tamany.getHeight() * 0.83)); //No és necessari que la dimensió sigui un número de doble precisió.
    }

    /**
     * Mètode que repinta el tauler gràfic.
     */
    public void setTauler() {
        Color grocFosc = new Color(205, 149, 12);
        Color grocClar = new Color(255, 180, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    if (tLogic.elemPosTauler(i, j).valorCas() == -1) {
                        vecCas[i][j].setBackground(grocFosc);
                    } else {
                        vecCas[i][j].setBackground(marroFosc);
                    }
                } else {
                    if (tLogic.elemPosTauler(i, j).valorCas() == -1) {
                        vecCas[i][j].setBackground(grocClar);
                    } else {
                        vecCas[i][j].setBackground(marroClar);
                    }
                }
            }
        }
    }

    /**
     * Funció que indica si l'usuari ha col·locat fitxes manualment.
     * @return L'usuari ha col·locat fitxes manualment (o no).
     */
    public boolean fitxesManuals() {
        return manual;
    }

    
}
