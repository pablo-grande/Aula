package Clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Se pide implementar la clase Alumno que permite sacar listados de las notas de los
alumnos de la Escuela. Cada alumno es un objeto de la clase que contiene el nombre,
apellidos y númmero de matrícula del mismo, junto con un array que contiene sus notas
de cada asignatura (hasta un máximo de 50 asignaturas). Los elementos del array
son datos en coma flotante (la clase garantiza que las notas están entre 0.0 y
10.0).
Para indexar el array del párrafo anterior dispondremos de unos códigos de
asignatura. Cada código es un número (de 0 en adelante, decidido por la Secretaria
del Centro). En particular, la asignatura de Programación II tiene el
código 7.
La clase deberá ofrecer:
- Un constructor para cargar el nombre, apellido y número de matrícula (que no
podrá modificarse en el futuro).
- Un método para cargar una nota en una asignatura.
- Un método para conocer la nota de la asignatura.
- Un método para conocer si una asignatura está evaluada (deberá elegir una
forma de indicar que, inicialmente, un alumno no tiene nota en una
asignatura).
- Métodos para consultar nombre, apellidos y número de matrícula.
Por último y con el objetivo de utilizar la clase, implemente un método main
que cree un objeto de la clase Alumno que cargue la nota de la asignatura
Programación II.

 * @author Pablo Riutort
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private int matricula;
    private float notas[];
    private final float NOEVALUADO = (float) -1.0;


    //Constructor;
    public Alumno (String nombre, String apellidos, int matricula){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.matricula = matricula;
        notas = new float [50];
        for (int i=0; i<notas.length; i++)
            notas[i] =  NOEVALUADO;
    }

    public void Nota(int matricula, float nota){
        if (nota > 0.0 || nota<10.0) return;
        else notas[matricula]=nota;
    }

    public float Nota (int matricula){
        if (matricula <0 || matricula > 50) return NOEVALUADO;
        else return notas[matricula];
    }

    public boolean Evaluado (int matricula){
        if (matricula <0 || matricula > 50) return false;
        else return matricula != NOEVALUADO;
    }

    public String nombre(String nombre){
        return nombre;
    }

    public String apellidos (String apellidos){
        return apellidos;
    }

    public int matricula (int matricula){
        return matricula;
    }
public void main (String[]args) throws Exception {
    Alumno nuevo = new Alumno ("Toni","Perelló Matas",0);
    nuevo.Nota (7,(float)5.3);
    System.out.print (nuevo.Nota(0));
}

}
