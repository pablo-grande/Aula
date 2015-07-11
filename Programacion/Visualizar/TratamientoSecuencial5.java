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

package Visualizar;


public class TratamientoSecuencial5 {
    static char caracter;
    static final char FinalSecuencia='.';

    public static void main(String [] argumentos) throws Exception {
        int numEnlaces=0;
        char ultimo;
        System.out.print("INTRODUCIR SECUENCIA DE CARACTERES: ");
        caracter=(char) System.in.read();
        buscarPalabra();
        while (caracter!=FinalSecuencia) {
            ultimo=ultimoCaracter();
            buscarPalabra();
            if (caracter==ultimo) numEnlaces++;
        }
        System.out.println("EL NUMERO DE ENLACES ES "+numEnlaces);
    }

    public static void buscarPalabra() throws Exception  {
            while ((caracter!=FinalSecuencia) && !(((caracter>='a')&&(caracter<='z')) || ((caracter>='A')&&(caracter<='Z')))) {
                caracter=(char) System.in.read();
            }
    }

    public static char ultimoCaracter() throws Exception {
        char car=' ';
        while (((caracter>='a')&&(caracter<='z')) || ((caracter>='A')&&(caracter<='Z'))) {
             car=caracter;
            caracter=(char) System.in.read();
        }
        return car;
    }

}