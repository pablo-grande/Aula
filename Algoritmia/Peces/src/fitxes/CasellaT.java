package fitxes;

/**
 * Classe on es creen les caselles que formaran el tauler.
 * @author pablo
 */
public class CasellaT {

    private int val; //Valor enter de la casella.
    private boolean esAlumOProf; //Variable que indica si la fitxa que hi ha a la casella és de tipus 'alumne' o 'professor' o cap de les dues.

    /**
     * Constructor de la classe CasellaT.
     * @param valor Valor enter de la casella.
     * @param alumProf Valor booleà de la casella.
     */
    public CasellaT(int valor, boolean alumProf) {
        val = valor;
        esAlumOProf = alumProf;
    }

    /**
     * Funció que retorna el valor enter de la casella.
     * @return El valor enter de la casella.
     */
    public int valorCas() {
        return val;
    }

    /**
     * Funció que retorna el valor booleà de la casella.
     * @return El valor booleà de la casella.
     */
    public boolean boolCas() {
        return esAlumOProf;
    }
}
