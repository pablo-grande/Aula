/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Complex;

/**
 * Clase Cuaternion
 *
 * @author pablo
 */
public class Cuaternion {

    private float part_real, part_imaginaria, part_imaginaria2, part_imaginaria3, part_imaginaria4;
    Cuaternion parametre = new Cuaternion();

    private Cuaternion() {
        part_real = 0;
        part_imaginaria = 0;
        part_imaginaria2 = 0;
        part_imaginaria3 = 0;
        part_imaginaria4 = 0;
    }

    private Cuaternion(float pReal, float pImag, float pImag2, float pImag3, float pImag4) {
        part_real = pReal;
        part_imaginaria = pImag;
        part_imaginaria2 = pImag2;
        part_imaginaria3 = pImag3;
        part_imaginaria4 = pImag4;
    }

    /*
     * Método que devuelve el valor real de un número complejo
     */
    public float real() {
        return part_real;
    }

    /*
     * Método que devuelve la parte imaginaria de un número complejo param: Complex
     */
    public float imaginaria (){
      return 0;
    }
    /*
     * Método que devuelve la variable parámetro que contiene la suma de los
     * valores de un número complejo param: a,b
     */
    public Cuaternion suma(Cuaternion a, Cuaternion b) {
        parametre.part_real = a.part_real + b.part_real;
        parametre.part_imaginaria = a.part_imaginaria + b.part_imaginaria;
        parametre.part_imaginaria2 = a.part_imaginaria2 + b.part_imaginaria2;
        parametre.part_imaginaria3 = a.part_imaginaria3 + b.part_imaginaria3;
        parametre.part_imaginaria4 = a.part_imaginaria4 + b.part_imaginaria4;
        return parametre;
    }

    /*
     * Método que devuelve la variable parámetro que contiene la resta de los
     * valores de un número complejo param: a,b
     */
    public Cuaternion resta(Cuaternion a, Cuaternion b) {
        parametre.part_real = a.part_real - b.part_real;
        parametre.part_imaginaria = a.part_imaginaria - b.part_imaginaria;
        parametre.part_imaginaria2 = a.part_imaginaria2 - b.part_imaginaria2;
        parametre.part_imaginaria3 = a.part_imaginaria3 - b.part_imaginaria3;
        parametre.part_imaginaria4 = a.part_imaginaria4 - b.part_imaginaria4;
        return parametre;
    }

    /*
     * Método que devuelve la variable parámetro que contiene el producto de los
     * valores de un número complejo param: a,b
     */
    public Cuaternion producte(Cuaternion a, Cuaternion b) {
        parametre.part_real = a.part_real * b.part_real;
        parametre.part_imaginaria = a.part_imaginaria * b.part_imaginaria;
        parametre.part_imaginaria2 = a.part_imaginaria2 * b.part_imaginaria2;
        parametre.part_imaginaria3 = a.part_imaginaria3 * b.part_imaginaria3;
        parametre.part_imaginaria4 = a.part_imaginaria4 * b.part_imaginaria4;
        return parametre;
    }

    /*
     * Método que devuelve un número complejo por pantalla param: Complex
     */
    public String imatge() {
        return "" + part_real + "" + part_imaginaria + "i"  + part_imaginaria2 + "i2" + part_imaginaria3 + "i3" + part_imaginaria4 + "i4";
    }

    /*
     * Método que cambia el valor real de un número complejo param: Complex
     */
    public void canviReal(float nou) {
        part_real = nou;
    }

    /*
     * Método que cambia el valor imaginario de un número complejo param: Complex
     */
    public void canviImag(float nou, float nou2, float nou3, float nou4) {
        part_imaginaria = nou;
        part_imaginaria2 = nou2;
        part_imaginaria3 = nou3;
        part_imaginaria4 = nou4;

    }
}
