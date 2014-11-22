package practicafinal;

import grafica.*;
import fitxes.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Classe on es faran totes les inicialitzacions.
 * @author Nicolás Galindo López & Inés Álvarez Vadillo
 */
public class Inicialitzacions {

    private Grafica principal;
    private boolean capFitxa;
    private Fitxa[] f; //'f' contindrà totes les fitxes que s'han de col·locar.

    /**
     * Mètode que inicialitza la finestra gràfica. Li posa el títol "Les fitxes que no maten", li canvia la icona per una reina negra, dibuixa
     * un tauler d'escacs, dibuixa les caselles de colors gris i negre, i defineix les dimensions del tauler.
     * @param dim Dimensió del tauler.
     */
    public void iniFinestra(int dim, PracticaFinal pf) {
        principal = new Grafica(dim, pf);
        principal.pack();
        principal.addWindowListener(new ExitListener());
        principal.setVisible(true);
    }
    /**
     * Mètode que modifica la finestra gràfica, llevant les barres de botons i opcions que no s'utilitzaran durant el backtracking.
     * @param g Referència a la finestra gràfica.
     */
    public void llevar(Grafica g) {
        g.llevar();
    }

    /**
     * Mètode que retorna la GUI creada a 'iniFinestra'.
     * @return La GUI creada a 'iniFinestra'.
     */
    public Grafica getGraf() {
        return principal;
    }

    /**
     * Mètode que inicialitza les fitxes.
     * @param n Dimensió del tauler
     * @param graf La finestra gràfica.
     */
    public void iniFitxes(int n, Grafica graf) {
        if (graf.getDimTria() != 0) {
            int[] xReina = new int[4 * (2 * n - 1)]; //La longitud de l'array 'xReina' és el número de possibles moviments que pot fer la reina.
            int[] yReina = new int[4 * (2 * n - 1)]; //La longitud de l'array 'yReina' és el número de possibles moviments que pot fer la reina.
            int[] xRei = new int[8]; //La longitud de l'array 'xRei' és el número de possibles moviments que pot fer el rei.
            int[] yRei = new int[8]; //La longitud de l'array 'yRei' és el número de possibles moviments que pot fer el rei.
            int[] xCav = new int[8]; //La longitud de l'array 'xCav' és el número de possibles moviments que pot fer el cavall.
            int[] yCav = new int[8]; //La longitud de l'array 'yCav' és el número de possibles moviments que pot fer el cavall.
            int[] xTorre = new int[2 * (2 * n - 1)]; //La longitud de l'array 'xTorre' és el número de possibles moviments que pot fer la torre.
            int[] yTorre = new int[2 * (2 * n - 1)]; //La longitud de l'array 'yTorre' és el número de possibles moviments que pot fer la torre.
            int[] xAlfil = new int[2 * (2 * n - 1)]; //La longitud de l'array 'xAlfil' és el número de possibles moviments que pot fer l'alfil.
            int[] yAlfil = new int[2 * (2 * n - 1)]; //La longitud de l'array 'yAlfil' és el número de possibles moviments que pot fer l'alfil.
            int[] xProf = new int[4 * (2 * n - 1)]; //La longitud de l'array 'xProf' és el número de possibles moviments que pot fer la fitxa 'professor'.
            int[] yProf = new int[4 * (2 * n - 1)]; //La longitud de l'array 'yProf' és el número de possibles moviments que pot fer la fitxa 'professor'.
            int[] xAlum = new int[4]; //La longitud de l'array 'xAlum' és el número de possibles moviments que pot fer la fitxa 'alumne'.
            int[] yAlum = new int[4]; //La longitud de l'array 'yAlum' és el número de possibles moviments que pot fer la fitxa 'alumne.
            f = new Fitxa[graf.getDimTria()]; //'f' s'emplenarà amb les fitxes triades per l'usuari,
            int compt = 0;                                 // començant per les que costa menys col·locar.
            int index = 0;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Escut(xAlum, yAlum);
                    f[index + i].inicialitzar(xAlum, yAlum);
                }
                index = index + graf.getTria(compt);
            }
            compt++;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Rei(xRei, yRei);
                    f[index + i].inicialitzar(xRei, yRei);
                }
                index = index + graf.getTria(compt);
            }
            compt++;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Cavall(xCav, yCav);
                    f[index + i].inicialitzar(xCav, yCav);
                }
                index = index + graf.getTria(compt);
            }
            compt++;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Torre(xTorre, yTorre);
                    f[index + i].inicialitzar(xTorre, yTorre, n);
                }
                index = index + graf.getTria(compt);
            }
            compt++;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Alfil(xAlfil, yAlfil);
                    f[index + i].inicialitzar(xAlfil, yAlfil, n);
                }
                index = index + graf.getTria(compt);
            }
            compt++;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Aguila(xProf, yProf);
                    f[index + i].inicialitzar(xProf, yProf, n);
                }
                index = index + graf.getTria(compt);
            }
            compt++;
            if (graf.getTria(compt) != 0) {
                for (int i = 0; i < graf.getTria(compt); i++) {
                    f[index + i] = new Reina(xReina, yReina);
                    f[index + i].inicialitzar(xReina, yReina, n);
                }
            }
        } else {
            capFitxa = true;
        }
    }

    /**
     * Funció que indica si l'usuari ha triat alguna fitxa o si no n'ha triat cap.
     * @return Si s'han triat fitxes o no.
     */
    public boolean getCapFitxa() {
        return capFitxa;
    }

    /**
     * Funció que retorna el vector de fitxes que l'usuari ha triat.
     * @return El vector de fitxes que conté totes les fitxes que l'usuari ha triat.
     */
    public Fitxa[] getFitxa() {
        return f;
    }

    class ExitListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }
}
