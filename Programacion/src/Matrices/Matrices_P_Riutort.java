//To change this template, choose Tools  Templates
// and open the template in the editor.
package Matrices;

/** 2 atributos:
 * -Dimension, le damos el valor de la dimension de nuestra matriz (cuadrada).
 * -Componentes Array bidimensional
 *
 * 3 Constructores:
 * -Constructor vacío (sin parámetros): Instanciamos un objeto Matriz 3x3 que coge los valores de inicializacion de los atributos
 * -Parámetro entero que indique la dimension de la matriz: Si ponemos 3, genera un objeto matriz 3x3.
 *
 * metodos
 * -Lectura de matrices. Método vacío, devuelve una Matriz 3x3
 * -Visualizacion de matrices. toString(Matriz3x3)a --> String
 * -toString () --> String
 * -Suma(Matriz a, Matriz b) --> Matriz3x3
 * -Suma(Matriz b)-->Matriz
 * -Resta(Matriz a, Matriz b) --> Matriz3x3
 * -Resta(Matriz b)-->Matriz
 * -Resta()-->Matriz
 * -Producto(Matriz3 a,matriz b) --> Matriz
 * -Producto(Matriz b)--> Matriz3x3
 * -Producto(Matriz a, int num) --> Matriz 
 * -Producto(int num)--> Matriz
 * -Producto(Matriz a) --> Matriz 
 * -Traspuesta()--> Matriz3x3
 * **/
//@author Pablo Riutort Grande
import java.io.*;

public class Matrices_P_Riutort { //Creamos la clase con sus correspondientes constructores

    private int dimension;
    private int[][] componentes;
    // constructor 1

    public Matrices_P_Riutort() {
        dimension = 3; //dimension predefinida
        componentes = new int[dimension][dimension];
    }
    // constructor 2 (Matrices cuadradas)

    public Matrices_P_Riutort(int dim) {
        dimension = dim; //dimension dada por parámetro
        componentes = new int[dimension][dimension];
    }
    // constructor 3 (Matrices cuadradas)

    public Matrices_P_Riutort(int[][] a) {
        dimension = a.length;
        componentes = a;
    }
    

    public Matrices_P_Riutort lectura() throws MiExcepcion, IOException {
        Matrices_P_Riutort nueva = new Matrices_P_Riutort();
        int dim, c=0;
        int[][] comp;
        String entrada;
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Dimensión de la matriz: ");
            System.out.println();
            entrada = buffer.readLine();
            dim = Integer.parseInt(entrada);
            comp = new int[dim][dim];
            for (int i = 0; i <= dim; i++) {
                for (int j = 0; j <= dim; j++) {
                    System.out.print("Introduzca la componente:  ( " + " i " + " , " + " j " + " )");
                    entrada = buffer.readLine();
                    comp[i][j] = Integer.parseInt(entrada);
                     while ((i!=c)&&(j!=c)&&(c<=100))c++;
                    if ((i!=c)||(j!=c))
                        throw new MiExcepcion ( "Se han introducido carácteres no numéricos");
                }
        }
            nueva = new Matrices_P_Riutort(comp);
        return nueva;
        }
    //lectura del teclado


    public String toString(Matrices_P_Riutort a) {
        String texto = "";
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                texto = "\t" + a.componentes[i][j];
            }
            texto += "\n";
        }
        return texto;
    }

    public String toString() {
        String texto = " ";
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                texto = "\t" + this.componentes[i][j];
            }
            texto += "\n";
        }
        return texto;
    }

    public Matrices_P_Riutort suma(Matrices_P_Riutort a, Matrices_P_Riutort b) throws MiExcepcion{
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = (a.componentes[i][j] + b.componentes[i][j]);
            }
        }
        if (a.dimension != b.dimension ) //Control de excepciones
            throw new MiExcepcion( "Las matrices no son operables" );
        return resultado;
    }

    public Matrices_P_Riutort suma(Matrices_P_Riutort a)throws MiExcepcion {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = (a.componentes[i][j] + this.componentes[i][j]);
            }
        }
          if ( a.dimension != this.dimension) //Control de excepciones
            throw new MiExcepcion( "Las matrices no son operables" );
        return resultado;

    }

    public Matrices_P_Riutort resta(Matrices_P_Riutort a, Matrices_P_Riutort b) throws MiExcepcion{
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = (a.componentes[i][j] - b.componentes[i][j]);
            }
        }
         if (a.dimension != b.dimension ) //Control de excepciones
            throw new MiExcepcion( "Las matrices no son operables" );
        return resultado;
    }

   
    public Matrices_P_Riutort resta(Matrices_P_Riutort a) throws MiExcepcion {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = (this.componentes[i][j] - a.componentes[i][j]);
            }
        }
         if (a.dimension != this.dimension ) //Control de excepciones
            throw new MiExcepcion( "Las matrices no son operables" );
        return resultado;
    }
    // cambio de signo de todas las componentes

    public Matrices_P_Riutort cambio_de_signo() {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(this.dimension);
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                resultado.componentes[i][j] = (-1) * (this.componentes[i][j]);
            }
        }
        return resultado;
    }

    public Matrices_P_Riutort producto(Matrices_P_Riutort a, Matrices_P_Riutort b) throws MiExcepcion{
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        int j=0;
        int r =0;
        for (int i = 0; i <= a.dimension; i++) {
            for ( j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = 0;
                for ( r = 0; i <= a.dimension; i++) {
                    for (int s = 0; j <= a.dimension; j++) {
                        resultado.componentes[i][j] += ((a.componentes[r][s]) * (b.componentes[s][r]));
                    }
                }
            }
        }
         if ( j != r ) //Control de excepciones
            throw new MiExcepcion( "Las matrices no son operables" );
        return resultado;
    }

    public Matrices_P_Riutort producto(Matrices_P_Riutort a) {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = 0;
                for (int r = 1; r < a.dimension; r++) {
                    resultado.componentes[i][j] += ((a.componentes[i][r]) * (this.componentes[r][j]));
                }
            }
            } //Al tener el mismo número de columnas y de filas (dado por la componente [r]),
              //siempre serán operables.
        return resultado;
    }

    public Matrices_P_Riutort producto_constante(Matrices_P_Riutort a, int b) {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = b * (a.componentes[i][j]);
            }
        }
        return resultado;
    }

    public Matrices_P_Riutort traspuesta(Matrices_P_Riutort a) {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = a.componentes[j][i];
            }
        }
        return resultado;
    }

    public Matrices_P_Riutort traspuesta() {
        Matrices_P_Riutort resultado = new Matrices_P_Riutort(this.dimension);
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                resultado.componentes[i][j] = this.componentes[j][i];
            }
        }
        return resultado;
    }

   public class MiExcepcion extends Exception {
        MiExcepcion( String cadena ){
           super( cadena ); // constructor param. de Exception
        }
    }

}