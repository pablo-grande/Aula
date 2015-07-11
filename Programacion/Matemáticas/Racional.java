/*
 * DESCRIPCIÓN: CLASE RACIONAL
 */

package Mates;
import java.io.*;


public class Racional {
// ATRIBUTOS
   private  int numerador=0, denominador=1;

// INTERFACE
// CONSTRUCTORES


    public Racional() { }

    public Racional(int pnum, int pden)
    {
        numerador = pnum;
        denominador = pden;
    }
// MÉTODOS

    public void lectura() {
        String entrada;
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("INTRODUCE EL NUMERADOR: ");
            entrada = in.readLine();
            numerador = Integer.parseInt(entrada);
            System.out.print("INTRODUCE EL DENOMINADOR: ");
            entrada = in.readLine();
            denominador = Integer.parseInt(entrada);
        }catch (Exception e) {}
    }

    @Override
    public  String toString(){
        return numerador+"/"+denominador;
    }


    public  static Racional Suma(Racional a, Racional b) {
        return new Racional(((a.numerador*b.denominador)+(a.denominador*b.numerador)),(a.denominador*b.denominador));
    }

//    public  static Racional Suma(Racional a, Racional b) {
//        Racional c=new Racional(a.numerador*b.denominador+a.denominador*b.numerador,a.denominador*b.denominador);
//        return c;
//    }

    public static Racional Resta(Racional a, Racional b) {
        return new Racional(((a.numerador*b.denominador)-(a.denominador*b.numerador)),(a.denominador+b.denominador));
    }

    public  void CambioSigno() {
        numerador=-numerador;
    }
    public static Racional Producto(Racional a, Racional b) {
        return new Racional((a.numerador*b.numerador),(a.denominador*b.denominador));
    }
    public static Racional Division(Racional a, Racional b) {
        return new Racional((a.numerador*b.denominador),(a.denominador*b.numerador));
    }

}