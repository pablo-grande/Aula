package Algoritmica;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**CLASE ORDENACION
 *
 * ALGORITMO DE BURBUJA
 * Dado un vector
 * PARA i desde 1 hasta n-1 componentes del vector
 * PARA j desde 1 hasta n-1 componentes del vector
 * Cogemos el primer elemento del vector
 * Lo comparamos con el de al lado
 * SI el elemento escogido es mayor que el de al lado, se intercambian,
 * SINO se pasa al siguiente elemento del vector
 * Vuelta a empezar.
 *
 * ALGORITMO SELECCION DIRECTA
 * Hace n-1 pasadas y selecciona el menor de cada una de las pasadas
 * Primera pasada, coge el menor de todos los numeros y lo coloca al principio
 * Segunda pasado, coge el menor (que ya no es el anterior) y lo coloca después del primero
 *
 * Así hasta n-1 veces (donde n será la longitud de la fila de numeros)
 *
 * Dado un vector
 * PARA i desde 1 hasta n-1 componentes del vector
 * asignamos el menor a la primera posicion
 * PARA j desde i+1 hasta n componentes del vector
 * SI la componente j del vector es menor que la componente i
 *  asignamos j como nueva componente menor
 * }
 *  intercambiamos las componentes
 *}
 *
 * ALGORITMO DE INSERCIÓN DIRECTA (ALGORITMO DE LA BARAJA)
 * Dado un array de n elementos:
 * PARA i desde 2 hasta n componentes del vector
 *     asginamos j = i-1
 *     MIENTRAS j sea menor o igual que 1 y la componente j sea menor que la siguiente hacer
 *        intercambimos sus posiciones
 *   }
 * }
 * 
 * @author Pablo Riutort Grande
 */
public class Ordenacion_P_Riutort {
    public static int vector[]={4,7,8,5,6};
    public static int dimension=vector.length;

   
    //Algoritmo burbuja normal
    
    public static void Burbuja_v0(int vector[], int dimension){
        int aux=0;
        for (int i=0; i<dimension; i++){
            for (int j=1; j<dimension-1; j++){
            if (vector[j]>vector[j+1]){
                 aux=vector[j];
                 vector[j]=vector[j-1];
                 vector[j-1]=aux;
        }
        }
        }
 
    }

    //Algoritmo burbuja optimizado
    //Termina el proceso cuando no existe ningun intercambio en una iteracion comparativa
    public static void Burbuja_v1(int vector[], int dimension){
        int i=0;
        int aux;
        while (i < dimension){
            for (int j=1; j<dimension-1; j++){
            if (vector[j]>vector[j+1]){
                 aux=vector[j];
                 vector[j]=vector[j-1];
                 vector[j-1]=aux;
        }
        }
        i++;
        }
    }

//Algoritmo burbuja optimizado
//empezamos el 2º for desde i+1
    public static void Burbuja_v2(int vector[], int dimension){
        int i=0, aux;
        boolean seguir=true;
        while ((i<dimension)&&(seguir)){
          //  seguir = false; ?
            for (int j=i+1; j<dimension; j++){
                vector[j]=0;
                if (vector[j]>vector[j+1]){
                 aux=vector[j];
                 vector[j]=vector[j-1];
                 vector[j-1]=aux;
               //  seguir=true; ?
                }
            }
            i++;
        }
    }

    public static void Seleccion_directa(int vector[], int dimension){
        int j, aux, menor;

        for (int i=0; i<dimension-1; i++){
            menor=i;
            for (j=i+1; j<dimension; j++){
                if (vector[j]<vector[menor])
                    menor=j;
            }
            aux=vector[i];
            vector[i]=vector[menor];
            vector[menor]=aux;
        }
    }

    public static void Visualizacion(int vector[], int dimension){
        for (int i=0; i<dimension; i++)
        System.out.print (vector[i]);
        System.out.println();
    }

public static void main (String[]args){
   Burbuja_v0(vector, dimension);
   Burbuja_v1(vector, dimension);
   Burbuja_v2(vector, dimension);
   Seleccion_directa(vector, dimension);
  // Insercion_directa(vector, dimension);
   Visualizacion(vector, dimension);
}

}
