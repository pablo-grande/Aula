package Visualizar;

public class Escribir_en_linea {
public static char car;
public static final int MAX=20+1,ANCHO=40;/*ANCHO determina el numero de caracteres que hay en cada linea*/
public static final char ESPACIO=' ',FIN='.';
public static char palabra[]= new char [MAX];
public static int indice=0, contador=0;
public static void buscar_palabra(){   //Buscamos palabra
    try{
        while (car==ESPACIO)
            car=(char)System.in.read();
    }catch(Exception e){}
}
public static void almacenar_palabra(){  //Almacenamos la primera palabra del texto introducido.
    try{
        while ((car!=' ')&&(car!='.')){
            palabra[indice]=car;
            indice++;   //Incrementamos su índice de letras.
            contador++;
            car=(char)System.in.read();
        }
    }catch(Exception e){}
}

public static void tratamiento(){
    try{
        for (int i=0; i<indice; i++){
        System.out.print(palabra[i]);
        }
        if (contador>ANCHO) System.out.println(); //En este caso, si la suma es par, pondremos solo un espacio.
    }catch(Exception e){}
}
public static void main (String[]args){
    try{
        System.out.print("Introducir secuencia de caracteres: ");
        car=(char)System.in.read();
        buscar_palabra();
        while (car!=FIN){
            almacenar_palabra();
            buscar_palabra();
            tratamiento();
            buscar_palabra();
            indice=0;
            System.out.println();
        }
    }catch(Exception e){}
}
}