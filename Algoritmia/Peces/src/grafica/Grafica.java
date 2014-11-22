package grafica;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import practicafinal.PracticaFinal;

/**
 * Classe on es crea la finestra gràfica.
 * @author pablo
 */
public class Grafica extends JFrame {

    private PracticaFinal pract; //'pract' farà referència a la classe PracticaFinal.
    private int dim; //Dimensió del tauler.
    private ferTauler tauler; //Referència al tauler gràfic.
    private ferBotons botonsSud; //Referència als botons inferiors.
    private ferOpcions opcionsOest; //Referència a la barra d'opcions.

    /**
     * Constructor de la classe 'Grafica'. S'encarrega de la inicialització de la finestra.
     * @param n Dimensó del tauler.
     * @param pf Referència a la classe PracticaFinal.
     */
    public Grafica(int n, PracticaFinal pf) {
        pract = pf;
        dim = n;
        this.setTitle("Les fitxes que no es maten");
        this.setIconImage(llegirIcona("Icona")); //Es canvia la icona de la finestra gràfica.
        this.getContentPane().add(ferCentre(), BorderLayout.CENTER);
        this.getContentPane().add(ferOest(), BorderLayout.WEST);
        this.getContentPane().add(ferSud(), BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocation(300, 10);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Mètode que modifica la finestra gràfica llevant les barres del nord i de l'oest, i en col·loca una nova a l'oest.
     */
    public void llevar() {
        this.getContentPane().add(nouOest(), BorderLayout.WEST);
        this.getContentPane().remove(opcionsOest);
        this.pack();
        this.repaint();
        this.validate();
    }

    /**
     * Funció que fa el centre de la finestra gràfica. Crea el tauler gràfic.
     * @return Un tauler gràfic.
     */
    private JPanel ferCentre() {
        tauler = new ferTauler(dim, pract);
        return tauler;
    }



    /**
     * Funció que fa el sud de la finestra gràfica. Crea els botons d'iniciar i aturar.
     * @return Els botons 'iniciar' i 'aturar'.
     */
    private JPanel ferSud() {
        botonsSud = new ferBotons();
        return botonsSud;
    }

    /**
     * Funció que fa l'oest de la finestra gràfica. Crea les opcions de casella inicial i fitxes que es crearan automàticament.
     * @return Opcions: casella inicial, fitxes automàtiques.
     */
    private JPanel ferOest() {
        opcionsOest = new ferOpcions(dim);
        return opcionsOest;
    }

    /**
     * Funció que crea el nou oest de la finestra gràfica. Crea els missatges que indiquen la tria de l'usuari.
     * @return La tria de l'usuari: casella inicial i fitxes automàtiques.
     */
    private JPanel nouOest() {
        JPanel nou = new JPanel();
        nou.setLayout(new GridLayout(9, 1));
        JLabel tria = new JLabel("  La vostra tria ha estat:");
        JLabel casIni = new JLabel("  Casella inicial: (" + getCasIni(0) + "," + getCasIni(1) + ").");
        JLabel reis = new JLabel("  Número de reis: " + getTria(1));
        JLabel reines = new JLabel("  Número de reines: " + getTria(6));
        JLabel cavalls = new JLabel("  Número de cavalls: " + getTria(2));
        JLabel torres = new JLabel("  Número de torres: " + getTria(3));
        JLabel alfils = new JLabel("  Número d'alfils: " + getTria(4));
        JLabel profs = new JLabel("  Número d'àguiles: " + getTria(5));
        JLabel alums = new JLabel("  Número d'escuts: " + getTria(0));
        nou.add(tria);
        nou.add(casIni);
        nou.add(reis);
        nou.add(reines);
        nou.add(cavalls);
        nou.add(torres);
        nou.add(alfils);
        nou.add(profs);
        nou.add(alums);
        return nou;
    }

    /**
     * Mètode que posa una imatge sobre la casella triada.
     * @param i Coordenada horitzontal de la casella triada.
     * @param j Coordenada vertical de la casella triada.
     * @param s Nom de la imatge.
     */
    public void pintar(int i, int j, String s) {
        tauler.posarImg(i, j, s);
    }

    /**
     * Mètode que esborra la imatge de la casella triada.
     * @param i Coordenada horitzontal de la casella triada.
     * @param j Coordenada vertical de la casella triada.
     */
    public void esborrar(int i, int j) {
        tauler.esborrarImg(i, j);
    }

    /**
     * Funció que retorna el número de fitxes que ha triat l'usuari.
     * @param i L'índex del vector de fitxes triades.
     * @return El número de fitxes del tipus triat per l'índex.
     */
    public int getTria(int i) {
        return opcionsOest.getTria(i);
    }

    /**
     * Funció que retorna el número total de fitxes col·locades.
     * @return El número de fitxes col·locades.
     */
    public int getDimTria() {
        return opcionsOest.getDimTria();
    }

    /**
     * Funció que indica si s'ha pitjat el botó d'iniciar.
     * @return S'ha pitjat 'iniciar' (o no).
     */
    public boolean getIni() {
        return botonsSud.getIni();
    }

    /**
     * Mètode que modifica l'estat del botó iniciar.
     * @param b El valor que es vol assignar al botó 'iniciar'.
     */
    public void setIni(boolean b) {
        botonsSud.setIni(b);
    }

    /**
     * Funció que indica si s'ha d'aturar l'execució del programa.
     * @return Vertader si l'usuari pitja aturar.
     */
    public boolean getStop() {
        return (botonsSud.getStop());
    }

    /**
     * Funció que retorna una coordenada de la casella inicial triada per l'usuari.
     * @param i Índex que indicarà quina coordenada es vol.
     * @return La coordenada triada per l'índex de la casella inicial.
     */
    public int getCasIni(int i) {
        return opcionsOest.getCasIni(i);
    }

    /**
     * Mètode que modifica el tauler lògic.
     */
    public void setTauler() {
        tauler.setTauler();
    }

    /**
     * Funció que indica si s'han col·locat fitxes manualment.
     * @return S'han col·locat fitxes manualment (o no).
     */
    public boolean fitxesManuals() {
        return tauler.fitxesManuals();
    }

    /**
     * Mètode que pren una imatge des d'una carpeta del sistema.
     * @return La imatge llegida.
     */
    private Image llegirIcona(String s) {
        BufferedImage icona = null; //Procés per prendre una icona des de la carpeta del projecte.
        try {
            icona = ImageIO.read(this.getClass().getResource(s + ".png")); //Es pren la imatge d'una reina negra.
            MediaTracker mt = new MediaTracker(this); //Procés per evitar que no hi hagi temps de carregar la imatge.
            mt.addImage(icona, 0);
            mt.waitForID(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icona;
    }
}