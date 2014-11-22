/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Visualizar;

/**
 * Dado un texto introducido por teclado y acabado en punto:
 * visualizar dos palabras por linea de manera que esten en el centro separadas
 * por uno o más espacios y tenga los mismos espacios en blanco a la izquierda y a la derecha
 * de las palabras.
 * cada linea debe tener 40 caracteres.
 *
 * Algoritmo visualizar_palabras_centro Es
 *  Inicio
 *      incializacion;
 *      leer_caracter;
 *      buscar_palabra;
 *      Mientras queden_palabras_por_tratar{
 *          almacenar_palabra1;
 *          buscar_palabra;
 *          si encuentra_palabra
 *              almacenar_palabra2;
 *          tratamiento_palabra;
 *          buscar_palabra;
 *      Saltar_linea;
 *      }
 *  Fin;
 *
 * Algoritmo tratamiento Es
 *  Inicio
 *      si el_total_de_caracteres_de_las_dos_palabras_par
 *        visualizar_palabras_en_el_centro_separadas_por_dos_espacios
 *      sino visualizar_palabras_en_el_centro_separadas_por_un_espacio
 *  Fin;
 *
 * Algoritmo buscar_palabra Es
 *  Inicio
 *      Mientras caracter_no_sea_alfabetico y queden_caracteres_por_taratar
 *          leer_caracter;
 *  Fin;
 *
 * @author Pablo Riutort
 */
public class visualizar_palabras_centro {
public static char car;
public static final int MAX=20+1,ANCHO=40;/*ANCHO determina el numero de caracteres que hay en cada linea*/
public static final char ESPACIO=' ',FIN='.';
public static char palabra1[]= new char [MAX],palabra2[]= new char [MAX];
public static int indice1=0,indice2=0;
public static void buscar_palabra(){   //Buscamos palabra
    try{
        while (car==ESPACIO)
            car=(char)System.in.read();
    }catch(Exception e){}
}
public static void almacenar_palabra1(){  //Almacenamos la primera palabra del texto introducido.
    try{
        while ((car!=' ')&&(car!='.')){
            palabra1[indice1]=car;
            indice1++;   //Incrementamos su �ndice de letras.
            car=(char)System.in.read();
        }
    }catch(Exception e){}
}
public static void almacenar_palabra2(){   //Ahora la segunda palabra del texto introducido.
    try{
        while ((car!=ESPACIO)&&(car!=FIN)){
            palabra2[indice2]=car;
            indice2++;      //Incrementamos su �ndice de letras.
            car=(char)System.in.read();
        }
    }catch(Exception e){}
}
public static void tratamiento(){
    try{
        int x;
        x=indice1+indice2;  //Sumamos los �ndices
        if (x%2==0) x+=2;  //Si son pares, le sumamos 2
        else x++; //sino, 1.   Esto sirve para que independientemente de c�mo sean las palabras de largas, siempre quedar�n centradas.
        for (int i=1;i<=(ANCHO-x)/2;i++) //Ahora ponemos espacios desde 1 hasta la diferencia del indice y el ancho de linea preestablecido entre 2.
            System.out.print(" ");
        for (int i=0;i<indice1;i++)  //Escribimos la primera palabra.
            System.out.print(palabra1[i]);
        System.out.print(" "); //Y un espacio.
        if (((indice1+indice2)%2==0)&&(indice2>0)) System.out.print(" "); //En este caso, si la suma es par, pondremos solo un espacio.
        for (int i=0;i<indice2;i++)  //Reiteramos el proceso anterior con la 2� palabra.
            System.out.print(palabra2[i]);
        for (int i=1;i<=(ANCHO-x)/2;i++)
            System.out.print(" ");
    }catch(Exception e){}
}
public static void main (String[]args){
    try{
        System.out.print("Introducir secuencia de caracteres: ");
        car=(char)System.in.read();
        buscar_palabra();
        while (car!=FIN){
            almacenar_palabra1();
            buscar_palabra();
            almacenar_palabra2();
            tratamiento();
            buscar_palabra();
            indice1=0;indice2=0;
            System.out.println();
        }
    }catch(Exception e){}
}
}