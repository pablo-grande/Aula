/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Búsquedas;
/**Leer desde teclado un carácter y verificar si es (o no) un carácter vocal.
Si es 'a' visualizar: Primera vocal
Si es 'e' visualizar: Segunda vocal.
etc.
Si no es vocal visualizar: No es vocal.

Algoritmo verificar_vocal es
character carácter;

Inicio
Leer_carácter es
	Visualizar: ("Introduzca el carácter deseado: ");
	Leer (carácter);
Fin Leer_carácter;

Tratamiento_y_Visualización es
Si carácter=='a' {
	Visualizar ("Primera vocal: ")
	}
Sino {si carácter=='e' {
	Visualizar ("Segunda vocal: ")
	}
Sino si carácter=='i' {
	Visualizar ("Tercera vocal: ")
	}
Sino si carácter=='o' {
	Visualizar ("Cuarta vocal: ")
	}
Sino si carácter=='u' {
	Visualizar ("Quinta vocal: ")
	}
Sino Visualizar ("No es vocal")
}
Fin Tratamiento_y_visualización;
Fin verificar_vocal;

--> Tratamiento_y_visualizacion_con_casos es
En caso que carácter sea {
	'a' visualizar("primera vocal");
	cortar;
	'e' visualizar("primera vocal");
	cortar;
	'i' visualizar("primera vocal");
	cortar;
	'o' visualizar("primera vocal");
	cortar;
	'u' visualizar("primera vocal");
	cortar;
Sino:Visualizar("No es vocal");
}
Fin visualizacion_y_tratamiento;
/**
 *
 * @author Pablo
 */
import java.io.*;
public class Verificar_vocal {
    public static void main (String [] args){
        try{
            final char FINAL='.';
            final char A='a';
            final char E='e';
            final char I='i';
            final char O='o';
            final char U='u';
            char letra;
            System.out.print ("Introduzca un carácter: ");
            letra =(char) System.in.read();
                switch (letra){
                    case A: System.out.println ("Primer carácter vocal");
                    break;
                    case E: System.out.println ("Segundo carácter vocal");
                    break;
                    case I: System.out.println ("Tercer carácter vocal");
                    break;
                    case O: System.out.println ("Cuarto carácter vocal");
                    break;
                    case U: System.out.println ("Quinto carácter vocal");
                    break;
                    default: System.out.println ("No es una vocal");
                }
            }catch (Exception e){}
}
}