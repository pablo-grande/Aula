
  //To change this template, choose Tools  Templates
 // and open the template in the editor.
 
package Matrices;


 
  //@author Pablo Riutort
 
import java.io.*;

public class claseMatriz {

    public int dimension;
    public int[][] componentes;
   // constructor 1

    public claseMatriz() {
        dimension = 3;
        componentes = new int[dimension][dimension];
    }
  // constructor 2

    public claseMatriz(int dim) {
        dimension = dim;
        componentes = new int[dimension][dimension];
    }
   // constructor 3

    public claseMatriz(int[][] a) {
        dimension = a.length;
        componentes = a;
    }
    //lectura del teclado

    public claseMatriz lectura() {
        claseMatriz nueva = new claseMatriz();
        int dim;
        int[][] comp;
        String entrada;
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Dimensión de la matriz: ");
            System.out.println();
            entrada = buffer.readLine();
            dim = Integer.parseInt(entrada);
            comp = new int[dim][dim];
            for (int i = 0; i <= dim; i++) {
                for (int j = 0; j <= dim; j++) {
                    System.out.print("Introduzca la componente:  ( "+" i "+" , "+" j "+" )");
                    entrada = buffer.readLine();
                    comp[i][j] = Integer.parseInt(entrada);
                }
            }
            nueva = new claseMatriz(comp);
        } catch (Exception e) {
        }
        return nueva;
    }

    public String toString(claseMatriz a) {
        String texto = " ";
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

    public claseMatriz suma(claseMatriz a, claseMatriz b) {
        claseMatriz resultado = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = (a.componentes[i][j] + b.componentes[i][j]);
            }
        }
        return resultado;
    }

    public claseMatriz suma(claseMatriz a) {
        claseMatriz resultado = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                resultado.componentes[i][j] = (a.componentes[i][j] + this.componentes[i][j]);
            }
        }
        return resultado;
    }

    public claseMatriz resta(claseMatriz a, claseMatriz b) {
        claseMatriz c = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = (a.componentes[i][j] - b.componentes[i][j]);
            }
        }
        return c;
    }

    public claseMatriz resta(claseMatriz a) {
        claseMatriz c = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = (this.componentes[i][j] - a.componentes[i][j]);
            }
        }
        return c;
    }
   // cambio de signo de todas las componentes

    public claseMatriz resta() {
        claseMatriz c = new claseMatriz(this.dimension);
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                c.componentes[i][j] = (-1)*(this.componentes[i][j]);
            }
        }
        return c;
    }

    public claseMatriz producto(claseMatriz a, claseMatriz b) {
        claseMatriz c = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = 0;
                for (int r = 0; i <= a.dimension; i++) {
                    for (int s = 0; j <= a.dimension; j++) {
                        c.componentes[i][j] += ((a.componentes[r][s]) * (b.componentes[s][r]));
                    }
                }
            }
        }
        return c;
    }

    public claseMatriz producto(claseMatriz a) {
        claseMatriz c = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = 0;
                for (int r = 0; i <= a.dimension; i++) {
                    for (int s = 0; j <= a.dimension; j++) {
                        c.componentes[i][j] += ((a.componentes[r][s]) * (this.componentes[s][r]));
                    }
                }
            }
        }
        return c;
    }

    public claseMatriz producto(claseMatriz a, int b) {
        claseMatriz c = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = b * (a.componentes[i][j]);
            }
        }
        return c;
    }

    public claseMatriz traspuesta(claseMatriz a) {
        claseMatriz c = new claseMatriz(a.dimension);
        for (int i = 0; i <= a.dimension; i++) {
            for (int j = 0; j <= a.dimension; j++) {
                c.componentes[i][j] = a.componentes[j][i];
            }
        }
        return c;
    }

    public claseMatriz traspuesta() {
        claseMatriz c = new claseMatriz(this.dimension);
        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
                c.componentes[i][j] = this.componentes[j][i];
            }
        }
        return c;
    }
}
