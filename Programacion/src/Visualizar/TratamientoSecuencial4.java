/*
 *  ALGORITMO TRATAMIENTOCARACTERES4 {
 *      INICIALIZACIONES;
 *      VISUALIZACIÓN_MENSAJE_INTRODUCCIÓN_TEXTO;
 *      LECTURA_PRIMER_CARACTER;
 *      BUSCAR_PALABRA;
 *      LECTURA_PALABRA;
 *      BUSCAR_PALABRA;
 *      MIENTRAS (QUEDEN_PALABRAS_POR_LEER) {
 *          LECTURA_PALABRA;
 *          TRATAMIENTO;
 *          BUSCAR_PALABRA;
 *      }
 *      IF (NO HAY PALABRAS) (SOLO HAY UNA PALABRA) {
 *              VISUALIZAR_MENSAJE_DE_NO_PODER_APLICAR_TRATAMIENTO;
 *      }
 *}
 *
 *
 */
package Visualizar;


public class TratamientoSecuencial4 {
    static char caracter;
    static final char FinalSecuencia='.';

    public static void main(String [] argumentos) throws Exception {
        char [] palabra1;
        char [] palabra2;
        int numPalabras=1;
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        caracter=(char) System.in.read();
        buscarPalabra();
        palabra1=lecturaPalabra();
        buscarPalabra();
        while (caracter!=FinalSecuencia) {
            numPalabras++;
            palabra2=lecturaPalabra();
            System.out.println((numPalabras-1) + " - " + (numPalabras) + " -> " + numCaracteresCoincidentes(palabra1,palabra2));
            palabra1=palabra2;
            buscarPalabra();
        }
        if (numPalabras <2) System.out.println("TEXTO INTRODUCIDO NO APLICABLE TRATAMIENTO");
    }

    public static void buscarPalabra() throws Exception {
        while ((caracter!=FinalSecuencia) && !(((caracter>='a')&&(caracter<='z'))||((caracter>='A')&&(caracter<='Z')))) {
            caracter=(char) System.in.read();
        }
    }

    public static char [] lecturaPalabra() throws Exception {
        char [] palabra=new char[21];
        int numCaracteres=0;
        while (((caracter>='a')&&(caracter<='z'))||((caracter>='A')&&(caracter<='Z'))) {
            palabra[numCaracteres]=caracter;
            numCaracteres++;
            caracter=(char) System.in.read();
        }
        palabra[numCaracteres]=' ';
        return palabra;
    }

    public static int numCaracteresCoincidentes(char [] pal1,char [] pal2)  {
        int numero=0;
        for (int i=0;pal1[i]!=' ';i++) {
            if (pal1[i]==pal2[i]) numero++;
        }
        return numero;
    }

}
