/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Matrices;

/**
 *
 * @author Pablo
 */
import java.io.*;
public class Matriz {

    public int dimension;
    public int[][] componentes;
    //constructor 1

    public Matriz() {
        dimension = 3;
        componentes = new int[dimension][dimension];
    }
    //constructor 2

    public Matriz(int dim) {
        dimension = dim;
        componentes = new int[dimension][dimension];
    }
    //constructor 3

    public Matriz(int[][] a) {
        dimension = a.length;
        componentes = a;
    }
    //lectura del teclado

    public Matriz lectura() {
        Matriz nueva = new Matriz();
        int dim;
        int[][] comp;
        String entrada;
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Dimensión de la matriz ");
            System.out.println();
            entrada = buffer.readLine();
            dim = Integer.parseInt(entrada);
            comp = new int[dim][dim];
            for (int i = 0; i<=dim; i++) {
                for (int j = 0; j<=dim; j++) {
                    System.out.print("Introduzca la componente: ("+ i + "," + j + ")");
                    entrada = buffer.readLine();
                    comp[i][j] = Integer.parseInt(entrada);
                }
            }
            nueva = new Matriz(comp);
        } catch (Exception e) {
        }
        return nueva;
    }

    public String toString(Matriz a) {
        String m = "";
        for (int i = 0; i<= a.dimension; i++) {
            for (int j = 0; j<=a.dimension; j++) {
                m +="\t" + a.componentes[i][j];
            }
            m += "\n";
        }
        return m;
    }


    public String toString() {
        String m = "";
        for (int i = 0; i<=this.dimension; i++) {
            for (int j = 0; j<=this.dimension; j++) {
                m +="\t" + this.componentes[i][j];
            }
            m +="\n";
        }
        return m;
    }

    public Matriz suma(Matriz a, Matriz b) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = (a.componentes[i][j] + b.componentes[i][j]);
            }
        }
        return c;
    }

    public Matriz suma(Matriz a) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = (a.componentes[i][j] + this.componentes[i][j]);
            }
        }
        return c;
    }

    public Matriz resta(Matriz a, Matriz b) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = (a.componentes[i][j] - b.componentes[i][j]);
            }
        }
        return c;
    }

    public Matriz resta(Matriz a) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i<=  a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = (this.componentes[i][j] - a.componentes[i][j]);
            }
        }
        return c;
    }
    //cambio de signo de todas las componentes

    public Matriz resta() {
        Matriz c = new Matriz(this.dimension);
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                c.componentes[i][j] = (-1)*(this.componentes[i][j]);
            }
        }
        return c;
    }

    public Matriz producto(Matriz a, Matriz b) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = 0;
                for (int r = 0; i<=  a.dimension; i++) {
                    for (int s = 0; j <= a.dimension; j++) {
                        c.componentes[i][j] += ((a.componentes[r][s])*(b.componentes[s][r]));
                    }
                }
            }
        }
        return c;
    }

    public Matriz producto(Matriz a) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = 0;
                for (int r = 0; i<=  a.dimension; i++) {
                    for (int s = 0; j <= a.dimension; j++) {
                        c.componentes[i][j] += ((a.componentes[r][s]) * (this.componentes[s][r]));
                    }
                }
            }
        }
        return c;
    }

    public Matriz producto(Matriz a, int b) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = b * (a.componentes[i][j]);
            }
        }
        return c;
    }

    public Matriz traspuesta(Matriz a) {
        Matriz c = new Matriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = a.componentes[j][i];
            }
        }
        return c;
    }

    public Matriz traspuesta() {
        Matriz c = new Matriz(this.dimension);
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                c.componentes[i][j] = this.componentes[j][i];
            }
        }
        return c;
    }
}

