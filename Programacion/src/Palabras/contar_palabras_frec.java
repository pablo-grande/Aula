/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Palabras;

/**
 * cuenta el numero de veces que aparecen las palabras del texto
 * @author Pablo Riutort
 */
public class contar_palabras_frec {
    public static final int MAX=500;
    public static class Frecuencia{
        Palabra palabras[]= new Palabra[MAX+1];
        int contador[]= new int[MAX];
        int elementos;

    }
    public static Frecuencia frec_pal=new Frecuencia();
    public static void inicializacion(){
        frec_pal.elementos=0;
        }
    public static void actualizacion(Palabra b){
        int indice=0;
        try{
            if (!Palabra.vacia(b)){
                frec_pal.palabras[frec_pal.elementos]=b;
                while (b!=frec_pal.palabras[indice]) indice++;
                if (indice==frec_pal.elementos){
                    frec_pal.elementos++;
                    frec_pal.contador[frec_pal.elementos-1]=1;
                    }
                else frec_pal.contador[indice]++;                          
            }
        }catch(Exception e){}
     }
    public static void visualizacion(){
        for (int i=0;i<frec_pal.elementos;i++)
            System.out.println("La palabra "+Palabra.toString(frec_pal.palabras[i])+" aparece "+frec_pal.contador[i]+" veces");
        }
     
    public static void main (String[]args){
        Palabra a;
        try{
            inicializacion();
            System.out.print("Introducir texto: ");
            Palabra.buscarPalabra();
            a=Palabra.lectura();
            while (!(Palabra.vacia(a))){
                actualizacion(a);
                Palabra.buscarPalabra();
                a=Palabra.lectura();
                }
            visualizacion();
            }catch(Exception e){}
        }
    }

