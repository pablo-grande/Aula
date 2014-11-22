/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Numeros_racionales;


/**
 *
 * @author Pablo
 */
public class uso_numeros_racionales {
    public static void main (String[]args){
        try{
        Numeros_racionales a,b,c;
        a=Numeros_racionales.lectura();
        b=new Numeros_racionales(3,4);      //Multiplicariamos a por 3/4.
        c=Numeros_racionales.producto(a,b); //Si queremos que lea otros numeros
                                            //escribimos lo mismo que hay en a.

        System.out.print ("El producto es: " +Numeros_racionales.toString(c));
    }catch (Exception e){}
}
}