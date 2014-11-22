package practicafinal;

import grafica.*;
import fitxes.*;

/**
 * Classe on es troba el mètode que fa el backtracking i els mètodes que aquest empra.
 * @author pablo
 */
public class Procediment extends Thread {

    private Visualitzacions visual;
    private Inicialitzacions inicial;
    private Tauler t; //'t' farà referència a la classe 'Tauler'.
    private Fitxa[] f; //'f' contindrà totes les fitxes que s'han de col·locar.
    private int n; //'n' indicarà les dimensions del tauler (n*n).
    private boolean acabat; //'acabat' indicarà que ja s'han col·locat totes les fitxes.
    private int numFitxes; //'numfitxes' indicarà quantes fitxes s'han col·locat.
    private int posVec; //'posVec' indicarà amb quina posició del vector 'f' s'estan fent els càlculs.
    private Grafica principal; //'principal' és la finestra gràfica.
    private long temps; //'temps' indicarà quant ha tardat en realitzar-se el mètode.
    private boolean mata;
    private boolean stop;
    private boolean capFitxa;
    private boolean iniError;

    /**
     * Constructor de la classe Procediment.
     * @param dim Dimensió del tauler.
     * @param graf Finestra gràfica (GUI).
     * @param tauler Tauler lògic sobre el qual es faran les operacions.
     */
    public Procediment(int dim, Grafica graf, Tauler tauler) {
        t = tauler;
        n = dim;
        principal = graf;
        visual = new Visualitzacions();
        inicial = new Inicialitzacions();
        iniError = false;
    }

    /**
     * Mètode que prepararà i cridarà al backtracking. S'invocarà quan comenci aquest Thread, és a dir, quan l'usuari pitgi iniciar.
     */
    @Override
    public void run() {
        capFitxa = false;
        stop = false;
        numFitxes = 0; //'numfitxes' indicarà quantes fitxes s'han col·locat.
        posVec = 0; //'numfitxes' indicarà la quantitat de fitxes que s'han col·locat ja.
        acabat = false; //'acabat' indicarà que ja s'han col·locat totes les fitxes.
        inicial.iniFitxes(n, principal); //Es creen les fitxes.
        capFitxa = inicial.getCapFitxa();
        if (!capFitxa) {
            f = inicial.getFitxa();
            temps = System.nanoTime(); //Es pren el temps actual per calcular quant tarda el mètode.
            if (principal.fitxesManuals()){
                principal.setTauler();
            }
            inicial.llevar(principal);
            /*
             * Pel fet de que l'usuari pot col·locar fitxes manualment, pot triar una configuració que provoqui que la primera fitxa de
             * totes que intenti col·locar el backtracking estigui sobre una casella incorrecta, i dóni problemes. Per tant, s'ha de comprovar
             * manualment si la fitxa mata per cercar la primera casella lliure.
             */
            if (!(f[0].mata(principal.getCasIni(0), principal.getCasIni(1), n, t))) {
                metode(principal.getCasIni(0), principal.getCasIni(1)); //Es crida al mètode que col·locarà les fitxes en el tauler.
            } else {
                iniError = true;
                cercarZero();
            }
            if (!stop) {
                temps = System.nanoTime() - temps; //Es calcula el temps total que ha tardat el mètode.
                visual.mostrarRes(acabat, capFitxa, principal, f, n, t, temps, iniError); //Es visualitza el resultat trobat a 'metode' a un missatge emergent.
            }
        } else {
            visual.mostrarRes(acabat, capFitxa, principal, f, n, t, temps, iniError); //Es visualitza el resultat trobat a 'metode' a un missatge emergent.
        }
        if (capFitxa) {
            principal.dispose();
        } else {
            while (!principal.getStop()) {
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (principal.getStop()) {
                principal.dispose();
            }
        }
    }

    /**
     * Mètode que pinta la fitxa indicada a la casella indicada.
     * @param i Coordenada 'x' de la casella triada.
     * @param j Coordenada 'y' de la casella triada.
     * @param f Fitxa que s'ha de pintar.
     */
    public void pinta(int i, int j, Fitxa f) {
        principal.pintar(i, j, f.getNom());
    }

    /**
     * Mètode que esborra la imatge de la fitxa que hi ha a la casella indicada.
     * @param i Coordenada 'x' de la casella triada.
     * @param j Coordenada 'y' de la casella triada.
     */
    public void esborra(int i, int j) {
        principal.esborrar(i, j);
    }

    /**
     * Mètode que col·loca les reines en el tauler mitjançant backtracking.
     * @param posx Coordenada horitzontal de la casella on es prova el backtracking.
     * @param posy Coordenada vertical de la casella on es prova el backtracking.
     */
    public void metode(int posx, int posy) {
        if (!acabat && !stop) { //Si l'usuari ha triat un número de fitxes que no és el màxim possible, és necessària aquesta comprovació.
            f[posVec].posaFitxa(posx, posy, t); //Es posa la fitxa al tauler.
            numFitxes++; //S'incrementa el comptador de fitxes col·locades.
            pinta(posx, posy, f[posVec]); //Es pinta una reina a la casella que està buida.
        }
        if (numFitxes == f.length) { //Si s'han col·locat totes les fitxes.
            acabat = true; //Quan 'acabat' sigui vertader, se sortirà de 'metode'.
        }
        if (!acabat) { //Si encara no s'han col·locat totes les fitxes.
            marcarCaselles(posx, posy);
            cercarZero();
        }
        //----------------------------------------------------------------------
        if (!acabat) {//Si no s'ha trobat cap zero i no s'han col·locat totes les fitxes.
            llevarFitxa(posx, posy);
        }
    }

    /**
     * Mètode que lleva la fitxa del tauler.
     * @param x Coordenada 'x' de la casella triada.
     * @param y Coordenada 'y' de la casella triada.
     */
    public void llevarFitxa(int x, int y) {
        f[posVec].llevaFitxa(x, y, t);
        numFitxes--; //Es decrementa el número de fitxes col·locades.
        posVec--; //S'ha de llevar la darrera fitxa col·locada.
        esborra(x, y); //S'esborra la fitxa de la casella actual.
        if (f[posVec] instanceof FitxesQueMaten) {
            f[posVec].desmarcar(x, y, n, t);
        }
    }

    /**
     * Funció que indica si l'usuari ha pitjat el botó d'aturar.
     * @return L'usuari ha pitjat 'aturar' (o no).
     */
    public boolean comprovarStop() {
        if (principal.getStop()) {
            stop = true;
            principal.dispose();
        }
        return stop;
    }

    /**
     * Mètode que cerca una casella que estigui buida per intentar col·locar-hi la següent fitxa.
     */
    public void cercarZero() {
        comprovarStop();
        int possegx = 0;
        int possegy = 0;
        while (possegx < n && !acabat) {
            while (possegy < n && !acabat) {
                if (t.elemPosTauler(possegx, possegy).valorCas() == 0) { //Si la casella està buida.
                    mata = false;
                    if (f[posVec] instanceof FitxesQueMaten) {
                        mata = f[posVec].mata(possegx, possegy, n, t);
                    }
                    if (!mata) {
                        metode(possegx, possegy); //Es fa la cridada recursiva.
                    }
                }
                possegy++;
            }
            possegy = 0;
            possegx++;
        } //Se surt d'aquest bucle si no hi ha caselles en blanc.
    }

    /**
     * Mètode que marca les caselles on la fitxa pot matar.
     * @param x Coordenada 'x' de la casella triada.
     * @param y Coordenada 'y' de la casella triada.
     */
    public void marcarCaselles(int x, int y) {
        if (f[posVec] instanceof FitxesQueMaten) {
            f[posVec].marcar(x, y, n, t);
        }
        posVec++; //Es passa a la següent fitxa que hi ha a 'f'.
    }
}
