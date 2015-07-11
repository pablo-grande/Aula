/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Numeros_racionales;


/**Dado dos numeros introducidos por teclado, ejecutar la seleccion de: sumar, restar, multiplicar o dividir dichos numeros
 * con la seleccion de un menu.
 *
 * @author Pablo
 */
public class menu_racionales {
    public static void main (String[]args){
        try{
            char seleccion=0;
            Numeros_racionales a, b, c;
            boolean Salir=false;

            while (seleccion!=6){
                
            a=Numeros_racionales.lectura();
            
            b=Numeros_racionales.lectura();
            
            System.out.println ("Pulse el numero de la operación que desee hacer con los numeros introducidos: ");
            System.out.println ();
            System.out.println ("1 Sumar");
            System.out.println ("2 Restar");
            System.out.println ("3 Multiplicar");
            System.out.println ("4 Dividir");
            System.out.println ("5 Salir del programa");

            System.out.print("Seleccion: ");
            seleccion=(char)System.in.read();


            switch (seleccion){
                case '1': c=Numeros_racionales.suma(a, b);
                          System.out.println("El resultado de la suma es: "+Numeros_racionales.toString(c));
                break;
                case '2': c=Numeros_racionales.resta(a, b);
                          System.out.println("El resultado de la resta es: "+Numeros_racionales.toString(c));
                break;
                case '3': c=Numeros_racionales.producto(a ,b);
                            System.out.println("El resultado del producto es: "+Numeros_racionales.toString(c));
                break;
                case '4': c=Numeros_racionales.division(a, b);
                            System.out.println("El resultado de la division es: "+Numeros_racionales.toString(c));
                break;
                case '5': Salir=true;
                break;
                default: System.out.println ("Operacion no reconocida.");
            }
            }
        }catch (Exception e){}
 }

}

