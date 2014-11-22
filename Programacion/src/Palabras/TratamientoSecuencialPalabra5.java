/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

/**
 *
 * @author Pablo
 */
public class TratamientoSecuencialPalabra5 {
    
    /*
 *  ALGORITMO PALABRAS_ENLAZADAS {
 *      INICIALIZACIONES;
 *      VISUALIZACIÓN_MENSAJE_USUARIO;
 *      LECTURA_CARACTER;
 *      BUSCAR_PALABRA;
 *      MIENTRAS (QUEDEN_PALABRAS_POR_TRATAR) {
 *          TRATAMIENTO_PALABRA;
 *          BUSCAR_PALABRA;
 *          SI (QUEDAN_PALABRAS_POR_TRATAR) {
 *              SI (EXISTE_ENLACE) INCREMENTADOR_CONTADOR_ENLACES;
 *          }
 *      }
 *      VISUALIZAR_RESULTADO;
 *   }
 * 
 */

    static char caracter;

    public static void main(String [] argumentos) throws Exception {
        int numEnlaces=0;
        Palabra palabra;
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        palabra = Palabra.lectura();
        while (palabra.quedanPalabras()) {
            if (palabra.letras(palabra)[palabra.longitud(palabra)] == palabra.letras(palabra)[0]) numEnlaces++;
            Palabra.buscarPalabra();
        }
        System.out.println("EL NUMERO DE ENLACES ES "+numEnlaces);
    }  
}
