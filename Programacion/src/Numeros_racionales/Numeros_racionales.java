/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Numeros_racionales;

/**
 *
 * @author Pablo
 */
import java.io.*;
public class Numeros_racionales{
    private int num,den; //Dos enteros que representan la clase de los numeros_racionales.
    //Constructor de la clase{
    public Numeros_racionales(int pnum, int pdem){
        num=pnum;
        den=pdem;
        }
    //} 
    public static Numeros_racionales lectura(){
        //Desarrollamos todo lo necesario para leer un racional desde el teclado.
        int numerador=0, denominador=0;
        String entrada;
        try{
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print ("Introducir numerador: ");
        entrada = in.readLine();
        numerador=Integer.parseInt(entrada);//��"Parse int" pasa un string a entero!!
        System.out.print ("Puede introducir el denominador: ");
        entrada=in.readLine();
        denominador=Integer.parseInt(entrada);
        }catch (Exception e){}
        return new Numeros_racionales (numerador,denominador);
    }
    public static String toString (Numeros_racionales a){
            return a.num+"/"+a.den;
    }
    /*Ahora declaramos las operaciones que se pueden hacer con los numeros racionales.
     * Teniendo en cuenta sus propiedades matem�tcas a la hora de operar:
     * Empezamos con la suma:
     */
    public static Numeros_racionales suma(Numeros_racionales a, Numeros_racionales b){
        return new Numeros_racionales((a.num*b.den)+(a.den*b.num), (a.den*b.den));
    }
    //La resta
    public static Numeros_racionales resta(Numeros_racionales a, Numeros_racionales b){
        return new Numeros_racionales((a.num*b.den)-(a.den*b.num), (a.den*b.den));
        }
    //Multiplicaci�n
    public static Numeros_racionales producto(Numeros_racionales a, Numeros_racionales b){
        return new Numeros_racionales((a.num*b.num),(a.den*b.den));
    }
    public static Numeros_racionales division(Numeros_racionales a, Numeros_racionales b){
        return new Numeros_racionales((a.num/b.den), (a.den*b.num));
    }
}