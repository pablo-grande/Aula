package practicafinal;

import grafica.*;
import fitxes.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Classe on es troben tots els mètodes que s'encarreguen de les visualitzacions de missatges.
 * @author pablo
 */
public class Visualitzacions {

    private boolean cancel;
    private int dim;
    private Object pane;
    private ImageIcon ii;

    /**
     * Mètode que visualitza els missatges inicials que permeten triar les dimensions del tauler, el número de fitxes que es volen col·locar 
     * i la casella inicial.
     */
    public void missatgeIni(Grafica graf) {
        String[] opcions1 = new String[15]; //La dimensió màxima serà 15x15 perquè el procés no tardi massa.
        for (int i = 0; i < opcions1.length; i++) {
            opcions1[i] = Integer.toString(i + 1);
        }
        ii = new ImageIcon("src/question.png");
        Object seleccio1 = JOptionPane.showInputDialog(graf, "Triau valor de 'n'", "Dimensió del tauler = n*n",
                JOptionPane.QUESTION_MESSAGE, ii, opcions1, opcions1[0]); //Es visualitza el missatge que permet a l'usuari triar la dimensió del tauler.
        if (seleccio1 != null) {
            for (int i = 0; i < opcions1.length; i++) {
                if (opcions1[i].equals(seleccio1)) {
                    dim = Integer.parseInt(opcions1[i]); //Es comprova l'opció que ha triat l'usuari i li assigna el seu valor a 'n'.
                }
            }
        } else {
            cancel = true;
            String error = "No heu triat cap dimensió pel tauler";
            JOptionPane.showMessageDialog(graf, error, "Procediment interromput", JOptionPane.ERROR_MESSAGE); //Es visualitza un missatge d'error.
        }
    }

    /**
     * Mètode que visualitza un missatge que indica que la casella on es vol col·locar manualment una fitxa està ocupada.
     * @param nom Nom de la fitxa.
     */
    public void casOcupada(JPanel panel, String nom) {
        ii = new ImageIcon("src/warning.png");
        String text = "No es pot col·locar cap " + nom + " a la casella triada.";
        JOptionPane.showMessageDialog(panel, text, "Error", JOptionPane.ERROR_MESSAGE, ii); //Es visualitza un missatge d'error.
    }

    /**
     * Mètode que visualitza un missatge que indica a l'usuari què ha de fer si vol desfer o si ha pitjat desfer sense voler.
     */
    public void desfer() {
        ii = new ImageIcon("src/info.png");
        String text = "Si voleu llevar la darrera fitxa col·locada, feu clic sobre el tauler.";
        JOptionPane.showMessageDialog(null, text, "Desfer", JOptionPane.ERROR_MESSAGE, ii); //Es visualitza un missatge d'error.
    }

    /**
     * Mètode que visualitza un missatge que indica a l'usuari que no es pot desfer.
     */
    public void noFitxes() {
        ii = new ImageIcon("src/warning.png");
        String text = "Només es pot desfer si la darrera acció realitzada ha estat col·locar una fitxa.";
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE, ii); //Es visualitza un missatge d'error.
    }

    /**
     * Funció que indica si l'usuari ha pitjat cancelar enlloc de triar una dimensió pel tauler.
     * @return Si l'usuari ha triat una dimensió o si ha pitjat cancelar.
     */
    public boolean getCancel() {
        return cancel;
    }

    /**
     * Funció que retorna la dimensió de la finestra que ha triat l'usuari.
     * @return La dimensió de la finestra gràfica.
     */
    public int getDim() {
        return dim;
    }

    /**
     * Mètode que visualitza un missatge que permet a l'usuari triar si vol veure el manual d'instruccions.
     */
    public void triar(Grafica graf) {
        ii = new ImageIcon("src/question.png");
        Object[] opcions = {"Sí", "No"};
        String s = "Voleu consultar el manual d'instruccions?";
        pane = JOptionPane.showOptionDialog(graf, s, "Benvinguts!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii, opcions, null);
    }

    /**
     * Mètode que visualitza un missatge informatiu que conté el manual d'instruccions.
     */
    public void manual(Grafica graf) {
        ii = new ImageIcon("src/info.png");
        String s = "                                                                                  Manual d'instruccions\n"
                + "Les Peces (o Peces que nos maten) es una aplicació que cerca una posició vàlida a totes les peces d'un joc d'escacs\n"
                + "A continuació es demanarà a l'usuari que trii quina dimensió vol del tauler per efectua aquesta prova\n"
                + "llavors, l'usuari triarà quin nombre de peces vol de cada peça del joc d'escacs mes dues peces inventades (àguila i escut)\n"
                + "Finalment, es triarà la casella sobre la que vol que es comencin a fer els càlculs.\n\n"
                + "Escut: Ocupa una casella inutilitzant-la sense amenaçar les peces del costat.\n"
                + "Àguila: Pot desplaçar-se en diagonal si es dreta a esquerra i en vertical i horitzonal. Només afecta a altres àguiles i a escuts\n";
        JOptionPane.showMessageDialog(graf, s, "Instruccions", JOptionPane.PLAIN_MESSAGE, ii);
    }

    /**
     * Funció que indica si l'usuari vol veure el manual.
     * @return L'usuari vol veure el manual (o no).
     */
    public int getPane() {
        return Integer.parseInt(pane.toString());
    }

    /**
     * Mètode que visualitza el resultat del backtracking. Indica en quines caselles s'han col·locat les reines i el temps que s'ha tardat o,
     * en el cas de que no hi hagi solució, un missatge que ho indica.
     */
    public void mostrarRes(boolean b1, boolean b2, Grafica graf, Fitxa[] f, int n, Tauler t, long temps, boolean b3) {
        if (!b1) {
            ii = new ImageIcon("src/error.png");
            String missError;
            if (b2) {
                missError = "No heu triat cap fitxa.";
            } else {
                missError = "No hi ha cap combinació correcta per col·locar les " + f.length + " figures\ntriades en un tauler de " + n + "x" + n
                        + " començant a la casella triada.";
            }
            JOptionPane.showMessageDialog(graf, missError, "Procediment acabat", JOptionPane.ERROR_MESSAGE, ii); //Es visualitza un missatge d'error.
        } else {
            ii = new ImageIcon("src/info.png");
            String solucio = "Hi ha fitxes a les caselles següents:\n"; //La primera casella que es visualitzi serà 
            int comptador = 1;                                                                                //la que hagi triat l'usuari.
            for (int i = 0; i < n; i++) { //Es visualitzen les caselles on hi ha un -1, que són aquelles ocupades per una fitxa.
                for (int j = 0; j < n; j++) {
                    if (t.elemPosTauler(i, j).valorCas() == -1) {
                        solucio = solucio + "Casella número " + comptador + ": (" + j + "," + i + ")";
                        comptador++;
                        if ((i == graf.getCasIni(0) && j == graf.getCasIni(1))) {
                            solucio = solucio + " (Definida per l'usuari).\n";
                        } else {
                            solucio = solucio + ".\n";
                        }
                    }

                }
            }
            if (b3) {
                solucio = solucio + "\nNo s'ha pogut col·locar cap fitxa a la casella triada.\n";
            }
            DecimalFormat nouFormat = new DecimalFormat("#####.##");
            String nouTemps = nouFormat.format(temps / 1000000.0); //Manera d'aconseguir que el temps visualitzat només tengui dos decimals.
            solucio = solucio + "\nS'ha tardat " + nouTemps + " milisegons.";
            JOptionPane.showMessageDialog(graf, solucio, "Procediment acabat", JOptionPane.PLAIN_MESSAGE, ii); //Es visualitza un missatge que mostra
        }                                                                                                       //la solució trobada.
    }

    /**
     * Mètode que visualitza un missatge que indica que la casella inicial triada per l'usuari no és vàlida.
     */
    public void coordIncorrectes(Grafica g) {
        ii = new ImageIcon("src/warning.png");
        String text = "No es pot començar a la casella triada perquè està ocupada.";
        JOptionPane.showMessageDialog(g, text, "Error", JOptionPane.ERROR_MESSAGE, ii); //Es visualitza un missatge d'error.
    }
}
