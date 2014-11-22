package vuitreines;
import vuitreines.escacs.Fitxa;
import vuitreines.escacs.Reina;
import vuitreines.escacs.Tauler;
import escacsgui.gui.Esdeveniment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import escacsgui.gui.GUI;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.awt.*;

/**
 * Programa que col·loca vuit reines en un tauler d'escacs de 8x8 de manera que no es matin entre elles, utilitzant per a això la tècnica del
 * backtracking. Implementa la GUI Esdeveniment donada pel professor per visualitzar gràficament la solució.
 * @author Pablo Riutort
 */
public class VuitReines implements Esdeveniment{
    private Fitxa f; //'f' farà referència a la classe 'Fitxa'.
    private Tauler t; //'t' farà referència a la classe 'Tauler'.
    private int quantfitxes; //'quantfitxes' indicarà quantes fitxes s'han de col·locar.
    private int n; //'n' indicarà les dimensions del tauler (n*n).
    private boolean acabat = false; //'acabat' indicarà que ja s'han col·locat totes les fitxes.
    private int numfitxes = 0; //'numfitxes' indicarà quantes fitxes s'han col·locat.
    private JFrame principal; //'principal' és la finestra gràfica.
    private GUI gui; //'gui' serà la interfície gràfica d'usuari.
    private long temps; //'temps' indicarà quant ha tardat en realitzar-se el mètode.
    private int[] coord; //Array que contindrà les coordenades de la casella on es començaran a fer els càlculs.
    private boolean cancelar = false; //'perDefecte' indicarà si la casella inicial ha estat assignada per defecte.
    /**
     * Constructor de la classe VuitReines.
     */
    public VuitReines(){
        
    }
    /**
     * Mètode que pren una imatge des d'una carpeta del sistema.
     * @return La imatge llegida.
     */
    public Image llegirIcona(){
        BufferedImage icona = null; //Procés per prendre una icona des de la carpeta del projecte.
        try {
            icona = ImageIO.read(principal.getClass().getResource("/Reina.png")); //Es pren la imatge d'una reina negra.
            MediaTracker mt = new MediaTracker(principal); //Procés per evitar que no hi hagi temps de carregar l'imatge.
            mt.addImage(icona,0);
            mt.waitForID(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icona;
    }
    /**
     * Mètode que pren l'alt de la pantalla. Com que les pantalles sempre són més amples que altes, ens asseguram de prendre la dimensió menor.
     * @return L'alt de la pantalla menys 30 (així es deixa espai per la barra de botons del sistema operatiu).
     */
    public int altPantalla(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamany = tk.getScreenSize();
        return ((int)tamany.getHeight() - 30); //No és necessari que la dimensió sigui un número de doble precissió.
    }
    /**
     * Mètode que inicialitza la finestra gràfica. Li posa el títol "Vuit reines", li canvia la icona per una reina negra, dibuixa un tauler d'escacs,
     * dibuixa les caselles de colors gris i negre, i defineix les dimensions del tauler.
     */
    public void iniFinestra(){
        principal = new JFrame("Vuit reines"); //El títol de la finestra serà 'Vuit reines'.
        gui = new GUI(altPantalla(), altPantalla(), n, new Color(0, 0, 0), new Color(210, 210, 210), this);
        principal.add(gui);
        principal.setIconImage(llegirIcona()); //Es canvia la icona de la finestra gràfica.
        principal.pack();
        principal.addWindowListener(new ExitListener());
        principal.setVisible(true);
    }
    /**
     * Mètode que dibuixa una reina a la casella indicada per les coordenades 'i' i 'j'.
     * @param i Coordenada horitzontal.
     * @param j Coordenada vertical.
     */
    public void pinta(int i, int j) {
        gui.posar(f.getNom(), i, j);
    }
    /**
     * Mètode que esborra la reina situada a la casella indicada per les coordenades 'i' i 'j'.
     * @param i Coordenada horitzontal.
     * @param j Coordenada vertical.
     */
    public void esborra(int i, int j){
        gui.buidar(i, j);
    }
    /**
     * Mètode que inicialitzarà les variables i durà a terme la invocació dels altres mètodes en l'ordre adequat.
     * @param dim Dimensió del tauler (n*n).
     * @param quantitat Número de fitxes que s'han de col·locar.
     */
    public void iniciar(){
        numfitxes = 0; //'numfitxes' indicarà la quantitat de fitxes que s'han col·locat ja.
        coord = new int[2]; //Array que contindrà les coordenades de la casella on es començaran a fer els càlculs.
        missatgeIni(); //Es visualitzen els missatges inicials.
        if (!cancelar){
            int[] x = new int[4*(2*n-1)]; //La longitud de l'array 'x' és el número de possibles moviments que pot fer la reina.
            int[] y = new int[4*(2*n-1)]; //La longitud de l'array 'y' és el número de possibles moviments que pot fer la reina.
            t = new Tauler(); //Instanciació de 'tauler'.
            int[][] p = new int[n][n]; //Les dimensions de 'p' són les que ha de tenir el tauler, és a dir, n*n.
            t.iniTauler(p,n); //S'inicialitza el tauler posant totes les caselles a 0.
            f = new Reina(x, y); //Instanciació de 'Reina'.
            f.inicialitzar(x, y, n); //S'emplenen els vectors 'x' i 'y' amb els moviments que pot fer la reina.
            iniFinestra(); //S'inicialitza la finestra gràfica.
            temps = System.nanoTime(); //Es pren el temps actual per calcular quant tarda el mètode.
            metode (coord[0], coord[1]); //Es crida al mètode que col·locarà les fitxes en el tauler.
            temps = System.nanoTime() - temps; //Es calcula el temps total que ha tardat el mètode.
            mostrarRes(); //Es visualitza el resultat trobat a 'metode' a un missatge emergent.
        }
    }
    /**
     * Mètode que visualitza els missatges inicials que permeten triar les dimensions del tauler, el número de fitxes que es volen col·locar 
     * i la casella inicial.
     */
    public void missatgeIni(){
        String[] opcions1 = new String[15]; //La dimensió màxima serà 15x15 perquè el procés no tardi més d'un minut aproximadament.
        for (int i = 0; i < opcions1.length; i++) {
            opcions1[i] = Integer.toString(i + 1);
        }
        Object seleccio1 = JOptionPane.showInputDialog(principal, "Triau valor de 'n'", "Dimensió del tauler = n*n",
                JOptionPane.QUESTION_MESSAGE, null, opcions1, opcions1[0]); //Es visualitza el missatge que permet a l'usuari triar la dimensió del tauler.
        if (seleccio1 != null) {
            for (int i = 0; i < opcions1.length; i++) {
                if (opcions1[i].equals(seleccio1)) {
                    n = Integer.parseInt(opcions1[i]); //Es comprova l'opció que ha triat l'usuari i li assigna el seu valor a 'n'.
                }
            }
            String[] opcions2 = new String[n]; //Les fitxes que es podran col·locar seran com a màxim tantes com llarg sigui el tauler (no hi podria
            for (int i = 0; i < opcions2.length; i++) {//                                                 haver dues reines en una mateixa fila o columna).
                opcions2[i] = Integer.toString(i + 1);
            }
            Object seleccio2 = JOptionPane.showInputDialog(principal, "Número de fitxes", "Quantes fitxes voleu col·locar?", //Es visualitza el missatge
                    JOptionPane.QUESTION_MESSAGE, null, opcions2, opcions2[0]);              //que permet a l'usuari triar quantes fitxes vol col·locar.
            if (seleccio2 != null) {
                for (int i = 0; i < opcions2.length; i++) {
                    if (opcions2[i].equals(seleccio2)) {
                        quantfitxes = Integer.parseInt(opcions2[i]); //Es comprova l'opció que ha triat l'usuari i li assigna el seu valor a 'quantfitxes'.
                    }
                }
                String[] opcions3 = new String[n]; //Com que els arrays comencen per 0, si, per exemple, 'n'=8, les components aniran de 0 a 7.
                for (int i = 0; i < opcions3.length; i++) {
                    opcions3[i] = Integer.toString(i);
                }
                Object opcioX = JOptionPane.showInputDialog(principal, "Component horitzontal", "Triau casella inicial", //Es visualitza el missatge que
                        JOptionPane.QUESTION_MESSAGE, null, opcions3, opcions3[0]);      //permet a l'usuari triar la coordenada X de la casella inicial.
                if (opcioX != null) {
                    for (int i = 0; i < opcions3.length; i++) {
                        if (opcions3[i].equals(opcioX)) {
                            coord[0] = Integer.parseInt(opcions3[i]); //Es comprova l'opció que ha triat l'usuari i li assigna el seu valor a 'coord[0]'.
                        }
                    }
                    Object opcioY = JOptionPane.showInputDialog(principal, "Component vertical", "Triau casella inicial", //Es visualitza el missatge
                            JOptionPane.QUESTION_MESSAGE, null, opcions3, opcions3[0]); //que permet a l'usuari triar la coordenada Y de la casella inicial.
                    if (opcioY != null) {
                        for (int i = 0; i < opcions3.length; i++) {
                            if (opcions3[i].equals(opcioY)) {
                                coord[1] = Integer.parseInt(opcions3[i]); //Es comprova l'opció que ha triat l'usuari i s'assigna el seu valor a 'coord[1]'.
                            }
                        }
                    } else {
                        cancelar = true;
                        String error = "No heu triat cap component vertical per la casella inicial";
                        JOptionPane.showMessageDialog(principal, error, "Procediment interromput", JOptionPane.ERROR_MESSAGE); //Missatge d'error.
                    }
                } else {
                    cancelar = true;
                    String error = "No heu triat cap component horitzontal per la casella inicial";
                    JOptionPane.showMessageDialog(principal, error, "Procediment interromput", JOptionPane.ERROR_MESSAGE); //Missatge d'error.
                }
            } else {
                cancelar = true;
                String error = "No heu triat cap número de fitxes per col·locar al tauler";
                JOptionPane.showMessageDialog(principal, error, "Procediment interromput", JOptionPane.ERROR_MESSAGE); //Es visualitza un missatge d'error.
            }
        } else {
            cancelar = true;
            String error = "No heu triat cap dimensió pel tauler";
            JOptionPane.showMessageDialog(principal, error, "Procediment interromput", JOptionPane.ERROR_MESSAGE); //Es visualitza un missatge d'error.
        }
    }
    /**
     * Mètode que col·loca les reines en el tauler mitjançant backtracking.
     * @param posx Coordenada horitzontal de la casella on es prova el backtracking.
     * @param posy Coordenada vertical de la casella on es prova el backtracking.
     */
    public void metode(int posx, int posy){
        if (!acabat){ //Si l'usuari ha triat un número de fitxes que no és el màxim possible, és necessària aquesta comprovació.
            t.assignaTauler(posx,posy,-1); //S'assigna un -1 a la casella actual, fet que indicarà que està ocupada per una fitxa.
            numfitxes++; //S'incrementa el comptador de fitxes col·locades.
            pinta(posx,posy); //Es pinta una reina a la casella que està buida.
        }
        if (numfitxes == quantfitxes){ //Si s'han col·locat totes les fitxes.
            acabat = true; //Quan acabat sigui vertader, se sortirà de 'metode'.
        }
        int movfig; //'movfig' serà un comptador.
        int possegx;
        int possegy;
        if (!acabat){ //Si encara no s'han col·locat totes les fitxes.
            movfig = 0;
            while (movfig<f.getMida()){ //En aquest bucle es marcaran totes les caselles on la fitxa mata.
                possegx = posx+f.elementsCoordx(movfig); //'possegx' contindrà el resultat de la suma de 'posx' i un dels moviments de la fitxa.
                possegy = posy+f.elementsCoordy(movfig); //'possegy' contindrà el resultat de la suma de 'posy' i un dels moviments de la fitxa.
                if (possegx>=0 && possegx <n && possegy>=0 && possegy<n && t.elemPosTauler(possegx, possegy)!=-1){
                    t.assignaTauler(possegx, possegy, (t.elemPosTauler(possegx, possegy)+1)); //Se suma 1 a la casella actual, per indicar que està
                }                                                                             //ocupada.
                movfig++;
            }
            possegx = 0;
            possegy = 0;
//            ------------------------------------------------------------------
//            En les següents 28 línies se cerca una casella que estigui a zero i s'hi realitza el backtracking. Hi ha dos algorismes diferents que
//            s'executen en funció de quina sigui la casella inicial. Això és perquè el primer és més ràpid, però no serveix per a totes les caselles.
            if (coord[0]==coord[1]){ //S'utilitza aquest algorisme si la casella inicial es troba sobre la diagonal principal.
                if (t.elemPosTauler(possegx, possegy)==0){ //Si hi ha un zero a la casella actual.
                    metode (possegx, possegy); //Es fa la cridada recursiva.
                }
                while ((possegy<n-1) && (t.elemPosTauler(possegx, possegy)!=0)){ //En aquest bucle se cerca una casella que estigui a zero.
                    while ((possegx<n-1)&&(t.elemPosTauler(possegx, possegy)!=0)){
                        possegx++;
                    }
                    if (t.elemPosTauler(possegx, possegy)!=0){ //Si no s'ha trobat cap 0 al final de la columna actual.
                        possegx=0; //Reiniciam 'posx' per tornar al començament de la fila.
                        possegy++; //Passam a la següent fila.
                    }
                    if (possegx==(n-1) && (t.elemPosTauler(possegx, possegy)!=0)){//S'ha de comprovar també la darrera columna.
                        while ((possegy<n-1)&&(t.elemPosTauler(possegx, possegy)!=0)){
                            possegy++;
                        }
                    }
                    if (possegy==(n-1) && (t.elemPosTauler(possegx, possegy)!=0)){//S'ha de comprovar també la darrera fila.
                        while ((possegx<n-1)&&(t.elemPosTauler(possegx, possegy)!=0)){
                            possegx++;
                        }
                    }
                    if (t.elemPosTauler(possegx, possegy)==0){ //Si es troba un 0.
                        metode (possegx, possegy); //Es fa la cridada recursiva.
                        possegy++;
                    }
                } //Se surt d'aquest bucle si no hi ha caselles en blanc.
            }else{
                for (possegx=0; possegx<n;possegx++){
                    for (possegy = 0; possegy<n;possegy++){
                        if (t.elemPosTauler(possegx, possegy)==0){ //Si es troba un 0.
                        metode (possegx, possegy); //Es fa la cridada recursiva.
                        }
                    }
                } //Se surt d'aquest bucle si no hi ha caselles en blanc.
            }
        }
        //----------------------------------------------------------------------
        if (!acabat){//Si no s'ha trobat cap zero i no s'han col·locat totes les fitxes.
            t.assignaTauler(posx,posy,0); //Es posa un 0 a la darrera casella marcada amb un -1, perquè se'n lleva la fitxa.
            numfitxes--; //Es decrementa el número de fitxes col·locades.
            esborra(posx, posy); //S'esborra la fitxa de la casella actual.
            movfig = 0;
            while (movfig<f.getMida()){ //Mentre quedin moviments per fer dins el rang de moviments possibles de la fitxa.
                possegx = posx+f.elementsCoordx(movfig); //'possegx' contindrà el resultat de la suma de 'posx' i un dels moviments de la fitxa.
                possegy = posy+f.elementsCoordy(movfig); //'possegy' contindrà el resultat de la suma de 'posy' i un dels moviments de la fitxa.
                if (possegx>=0 && possegx <n && possegy>=0 && possegy<n && t.elemPosTauler(possegx, possegy)!=0){
                    t.assignaTauler(possegx, possegy, (t.elemPosTauler(possegx, possegy)-1)); //Se resta 1 a la casella actual, per indicar que la
                }                                                                             //fitxa que hi matava ja no hi és.
                movfig++;
            }
        }
    }
    /**
     * Mètode que visualitza el resultat del backtracking. Indica en quines caselles s'han col·locat les reines i el temps que s'ha tardat o,
     * en el cas de que no hi hagi solució, un missatge que ho indica.
     */
    public void mostrarRes(){
        String missError = "No hi ha cap combinació correcta per col·locar les "+quantfitxes+" figures\ntriades en un tauler de "+n+"x"+n+
                " posant-ne una a la casella ("+coord[0]+","+coord[1]+").";
        if (!acabat){
            JOptionPane.showMessageDialog(principal, missError, "Procediment acabat", JOptionPane.ERROR_MESSAGE); //Es visualitza un missatge d'error.
        } else {
            String solucio = "S'han col·locat reines a les caselles següents:\n"; //La primera casella que es visualitzi serà 
            int comptador=1;                                                                                //la que hagi triat l'usuari.
            for (int i=0; i<n; i++){ //Es visualitzen les caselles on hi ha un -1, que són aquelles ocupades per una fitxa.
                for (int j=0; j<n; j++) {
                    if (t.elemPosTauler(i, j)==-1) {
                        solucio = solucio+"Casella número "+comptador+": ("+i+","+j+")";
                        comptador++;
                        if ((i==coord[0] && j==coord[1])){
                            solucio = solucio + " (Definida per l'usuari).\n";
                        } else {
                            solucio = solucio + ".\n";
                        }
                    }
                        
                }
            }
            DecimalFormat nouFormat = new DecimalFormat("#####.##");
            String nouTemps = nouFormat.format(temps/1000000.0); //Manera d'aconseguir que el temps visualitzat només tengui dos decimals.
            solucio = solucio+"\nS'ha tardat "+nouTemps+" milisegons.";
            JOptionPane.showMessageDialog(principal, solucio, "Procediment acabat", JOptionPane.PLAIN_MESSAGE); //Es visualitza un missatge que mostra
        }                                                                                                       //la solució trobada.
    }
    /**
     * Programa principal.
     */
    public static void main(String[] args) {
        VuitReines v = new VuitReines();
        v.iniciar();
    }
    /**
     * Aquest mètode no s'utilitza. Era necessària la seva implementació per poder utilitzar la biblioteca 'escacsgui'.
     */
    @Override
    public void enviarEsdeveniment(String tipus, String info) {
    }
    class ExitListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }
}
