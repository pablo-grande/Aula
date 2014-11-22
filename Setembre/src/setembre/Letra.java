package setembre;

/**
 * Esta clase permite construir el objeto letra, del cual deriva el resto de la
 * práctica. Letra consiste en una serie de especificaciones de lo que es una
 * letra para el braille, estas especificaciones pueden verse más adelante en la
 * especificación de la misma clase.
 *
 * @author Pablo
 */
public class Letra {

    //Una letra en braille será una matriz inicializada a puntos
    private char braille[][];
    //Las 10 primeras letras tienen asociados números a ellas y todas también tienen mayúsculas
    private char numerico;
    private char minuscula;
    private char mayuscula;
    //Carácteres especiales, para codificar en braille
    static final char punto = '.';
    static final char relieve = 'o';
    static final char blanco = ' ';

    /**
     * Letra vacía Esta Letra me servirá para carácteres especiales: Símbolo de
     * carácter mayúscula Símbolo de carácter numérico Blancos
     */
    public Letra() {
        this.braille = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                braille[i][j] = punto;
            }
        }
    }

    /**
     * Letras con carácteres numéricos y mayúsculas asociados.
     *
     * @param numerico corresponde al número que también representa la letra
     * @param minuscula corresponde a la minúscula que también representa la
     * letra
     * @param mayuscula corresponde a la mayúscula que también representa la
     * letra
     */
    public Letra(char numerico, char minuscula, char mayuscula) {
        this.braille = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                braille[i][j] = punto;
            }
        }

        this.numerico = numerico;
        this.minuscula = minuscula;
        this.mayuscula = mayuscula;
    }

    /**
     * Letras solo con carácteres mayúscula asociados
     *
     * @param minuscula corresponde a la minúscula que también representa la
     * letra
     * @param mayuscula corresponde a la mayúscula que también representa la
     * letra
     */
    public Letra(char minuscula, char mayuscula) {
        this.braille = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                braille[i][j] = punto;
            }
        }

        this.minuscula = minuscula;
        this.mayuscula = mayuscula;
    }

    /**
     * Método que captura la matriz de braille
     *
     * @return una matriz de braille
     */
    public char[][] getBraille() {
        return braille;
    }

    /**
     * Método que permite construir una matriz de braille
     *
     * @param braille matriz de carácteres
     */
    public void setBraille(char[][] braille) {
        this.braille = braille;
    }

    /**
     * Método que permite establecer los relieves ('o') de la matriz
     *
     * @param x coordenada de x de la matriz
     * @param y coordenada y de la matriz
     */
    public void setRelieve(int x, int y) {
        this.braille[x][y] = relieve;
    }

    /**
     *
     * @return carácter numérico asociado a una letra
     */
    public char getNumerico() {
        return numerico;
    }

    /**
     *
     * @return carácter minúscula asociado a una letra
     */
    public char getMinuscula() {
        return minuscula;
    }

    /**
     *
     * @return carácter mayúscula asociado a una letra
     */
    public char getMayuscula() {
        return mayuscula;
    }

    /**
     * Método que permite establecer los blancos (' ') de la matriz en el caso
     * de que codifiquemos el espacio en blanco.
     *
     * @param x
     * @param y
     */
    public void setBlanco(int x, int y) {
        this.braille[x][y] = blanco;
    }

    /**
     * Este método pasa de manera ordenada los carácteres que conforman una
     * matriz de braille a un String
     *
     * @return String de la línea de carácteres que conforman la matriz de
     * braille
     */
    public String getString() {
        String linea = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                linea += this.braille[i][j];
            }
        }
        return linea;
    }
}
