/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Complex;

/**
 * Clase complejos
 *
 * @author pablo
 */
public class Complejos {
    
    private float part_real,part_imaginaria;
    Complejos parametre = new Complejos();
    
    private Complejos (){
        part_real=0;
        part_imaginaria=0;  
    }
    

    private Complejos (float pReal, float pImag){
        part_real = pReal;
        part_imaginaria = pImag;
    }
    
    /*Método que devuelve el valor real de un número complejo*/
    
    public float real(){
        return part_real;
    }
    
    /*Método que devuelve la parte imaginaria de un número complejo
     * param: Complex*/
    
    public float imaginaria (){
        return part_imaginaria;
    }
    
    /*Método que devuelve la variable parámetro que contiene la suma de los valores de un número complejo
     * param: a,b*/
    
    public Complejos suma (Complejos a, Complejos b){
        parametre.part_real = a.part_real+b.part_real;
        parametre.part_imaginaria = a.part_imaginaria+b.part_imaginaria;
        return parametre;
    }
    
     /*Método que devuelve la variable parámetro que contiene la resta de los valores de un número complejo
     * param: a,b*/
    
    public Complejos resta (Complejos a, Complejos b){
        parametre.part_real = a.part_real-b.part_real;
        parametre.part_imaginaria = a.part_imaginaria-b.part_imaginaria;
        return parametre;
    }
    
     /*Método que devuelve la variable parámetro que contiene el producto de los valores de un número complejo
     * param: a,b*/
    
     public Complejos producte (Complejos a, Complejos b){
        parametre.part_real = a.part_real*b.part_real;
        parametre.part_imaginaria = a.part_imaginaria*b.part_imaginaria;
        return parametre;
    }
     
     /*Método que devuelve un número complejo por pantalla
     * param: Complex*/
     
     public String imatge (){
         return ""+part_real+""+part_imaginaria+"i";
     }
     
     /*Método que cambia el valor real de un número complejo
     * param: Complex*/
     
     public void canviReal(float nou){
         part_real = nou;
     }
     
     /*Método que cambia el valor imaginario de un número complejo
     * param: Complex*/
     
     public void canviImag(float nou){
         part_imaginaria = nou;
     }

}
