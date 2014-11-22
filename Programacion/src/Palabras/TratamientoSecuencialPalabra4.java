/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

/**
 *
 * @author Pablo
 */
public class TratamientoSecuencialPalabra4 {
    
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

    static char caracter;
    static final char FinalSecuencia='.';

    public static void main(String [] argumentos) throws Exception {
        int numPalabras=0;
        Palabra palabra1;
        Palabra palabra2;
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        palabra1=Palabra.lectura();
//        buscarPalabra();
//        palabra1=lecturaPalabra();
//        buscarPalabra();
        while (palabra1.quedanPalabras()) {
            numPalabras++;
            palabra2=Palabra.lectura();
            System.out.println( numCaracteresCoincidentes(palabra1,palabra2));
            palabra1=palabra2;
            palabra1=Palabra.lectura();
        }
        if (numPalabras <2) System.out.println("TEXTO INTRODUCIDO NO APLICABLE TRATAMIENTO");
    }

    public static int numCaracteresCoincidentes(Palabra a, Palabra b)  {
        int numero=0;
        for (int i=0; i<Palabra.longitud(a);i++) {
            if (Palabra.letras(a)[i]==Palabra.letras(a)[i]) numero++;
        }
        return numero;
    }

}
