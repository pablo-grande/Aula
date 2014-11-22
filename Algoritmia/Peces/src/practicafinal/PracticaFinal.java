package practicafinal;

import fitxes.Tauler;
import fitxes.CasellaT;

/**
 * Programa que col·loca les fitxes que triï l'usuari en un tauler d'escacs de la mida que vulgui de manera que no es matin entre elles,
 * utilitzant per a això la tècnica del backtracking.
 * @author pablo
 */
public class PracticaFinal {

    private Inicialitzacions ini;
    private Procediment proc;
    private int n; //'n' indicarà les dimensions del tauler (n*n).
    private Visualitzacions vis;
    private Tauler tau; //'t' farà referència a la classe 'Tauler'.

    /**
     * Constructor de la classe PracticaFinal. Inicialitzarà les variables i durà a terme la invocació dels altres mètodes en l'ordre adequat.
     */
    public PracticaFinal() {
    }

    /**
     * Mètode que inicialitzarà les variables i durà a terme la invocació dels altres mètodes en l'ordre adequat.
     * @param dim Dimensió del tauler (n*n).
     * @param quantitat Número de fitxes que s'han de col·locar.
     */
    public void iniciar() {
        ini = new Inicialitzacions();
        vis = new Visualitzacions();
        vis.triar(ini.getGraf());
        if (vis.getPane() == 0) {
            vis.manual(ini.getGraf());
        }
        vis.missatgeIni(ini.getGraf());
        n = vis.getDim();
        tau = new Tauler(); //Instanciació de 'tauler'.
        CasellaT[][] p = new CasellaT[n][n]; //Les dimensions de 'p' són les que ha de tenir el tauler, és a dir, n*n.
        tau.iniTauler(p, n); //S'inicialitza el tauler posant totes les caselles a 0.
        if (!vis.getCancel()) {
            ini.iniFinestra(n, this); //S'inicialitza la finestra gràfica.
            boolean correcte = false;
            while (!ini.getGraf().getIni() || !correcte) {
                if (ini.getGraf().getStop()) {
                    ini.getGraf().dispose();
                    System.exit(0);
                } else if (ini.getGraf().getIni()) {
                    if (tau.elemPosTauler(ini.getGraf().getCasIni(0), ini.getGraf().getCasIni(1)).valorCas() != 0) {
                        vis.coordIncorrectes(ini.getGraf());
                        ini.getGraf().setIni(false);
                    } else {
                        correcte = true;
                    }
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            proc = new Procediment(n, ini.getGraf(), tau);
            proc.start();
        }
    }

    /**
     * Funció que retorna el tauler lògic.
     * @return El tauler lògic.
     */
    public Tauler getTauler() {
        return tau;
    }

    /**
     * Mètode que retorna la referència a la classe Visualitzacions.
     * @return Referència a la classe Visualitzacions.
     */
    public Visualitzacions getVis() {
        return vis;
    }

    /**
     * Programa principal.
     */
    public static void main(String[] args) {
        PracticaFinal p = new PracticaFinal();
        p.iniciar();
    }
}
