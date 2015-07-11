/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmica;

/**
 *
 * @author Pablo
 */
public class Ordenacion {
public static void visualizarVector(int[]a){
    String linea="";
    for(int i=0;i<a.length;i++){
        linea+=a[i]+"   ";
    }
    System.out.println(linea);
}

/**----------------------------------------
 *  version 0
 *-----------------------------------------
 * Algoritmo ordenacion_burbuja(vector A) Es
 * Inicio
 * Para i desde 0 hasta n-1{
 * Para j desde 0 hasta n-1{
 *  Si (A[j]>A[j+1]) Entonces intercambiar(A[j],A[j+1]);
 * Fin para;
 *
 */

public static void burbuja_v0(int[]a){
    int aux;
    int b[]=a;
    for(int i=0;i<b.length-1;i++){
            for(int j=0;j<b.length-1;j++){
            if(b[j]>b[j+1]){
                aux=b[j];
                b[j]=b[j+1];
                b[j+1]=aux;
            }
            }
        }
    System.out.print("Burbuja versión 0 : ");
        visualizarVector(b);
}
/**-----------------------------------------
 *  version 1
 * ----------------------------------------
 *  Algoritmo ordenacion_burbuja(vector A) Es
 * Inicio
 * i=1;
 * seguir=verdadero;
 * Mientras (i<n) y (seguir){
 * seguir=falso;
 *  Para j desde 1 hasta n-1{
 *      Si (A[j]>A[j+1]) Entonces{
 *          intercambiar(A[j],A[j+1]);
 *          seguir=verdadero;
 *      }
 *  Fin para;
 * incrementar i;
 * Fin mientras;
 *
 */
public static void burbuja_v1(int[]a){
    int aux;
    int i=1;
    int b[]=a;
    boolean seguir=true;
    while((i<b.length)&&(seguir)){
        seguir=false;
            for(int j=0;j<b.length-1;j++){
            if(b[j]>b[j+1]){
                aux=b[j];
                b[j]=b[j+1];
                b[j+1]=aux;
                seguir=true;
            }
            }
        i++;
        }
    System.out.print("Burbuja versión 1 : ");
        visualizarVector(b);
}

/**-----------------------------------------
 *  version 2
 * ----------------------------------------
 *  Algoritmo ordenacion_burbuja(vector A) Es
 * Inicio
 * i=1;
 * seguir=verdadero;
 * Mientras (i<n) y (seguir){
 * seguir=falso;
 *  Para j desde i+1 hasta n-1{
 *      Si (A[j]>A[j+1]) Entonces{
 *          intercambiar(A[i],A[j]);
 *          seguir=verdadero;
 *      }
 *  Fin para;
 * incrementar i;
 * Fin mientras;
 *
 */

public static void burbuja_v2(int[]a){
    int aux;
    int i=1;
    int b[]=a;
    boolean seguir=true;
    while((i<b.length)&&(seguir)){
        seguir=false;
            for(int j=i+1;j<b.length-1;j++){
            if(b[j]>b[j+1]){
                aux=b[j];
                b[j]=b[i];
                b[i]=aux;
                seguir=true;
            }
            }
        i++;
        }
    System.out.print("Burbuja versión 2 : ");
        visualizarVector(b);
}
/**------------------------------------------
 *    Seleccion directa
 * -------------------------------------------
     * Algoritmo inserccion_directa(vector a) Es
     * entero menor;
     * inicio
     *      Para i=1 hasta n-1{
     *      menor=i
     *          para j=i+1 hasta n{
     *              si a[j]<a[menor] entonces menor=j;
     *          fin para;
     *      intercambiar(a[i],a[menor];
     *      fin para;
     * Fin
     *
     * @param a
     */
    public static void seleccion_directa(int[] a) {
        int aux;
        int b[] = a;
        int menor;
        for (int i = 0; i < b.length - 1; i++) {
            menor = i;
            for (int j = i+1; j < b.length; j++) {
                if (b[j] < b[menor]) {
                    menor = j;
                }
            }
            aux = b[i];
            b[i] = b[menor];
            b[menor] = aux;
            visualizarVector(b);
        }
        System.out.print("Selección directa : ");
        visualizarVector(b);
    }
    /**
     * ---------------------------------
     * inserciÃ³n directa
     * --------------------------------
     * Algoritmo inserciÃ³n (vector a) Es
     * Inicio
     * Para i=1 hasta n-1{
     *      entero j=i-1;
     *      Mientras (j>1) y (a[i]<a[j]){
     *          decrementar j;
     *      Fin mientras
     *      insertar a[i] en a[j];
     * Fin para;
     */



    /**
     *  Algoritmo de Shell
     *
     */

    public static void shell(int[]b){
    int aux;
    int a[] = b;
    for(int incremento=a.length/2;incremento>0;incremento=incremento/2){
        for(int i=incremento;i<a.length;i++){
            if(a[i]<a[i-incremento]){
                aux=a[i-incremento];
                a[i-incremento]=a[i];
                a[i]=aux;
            }
            }
    }
    System.out.print("Vector ordenado con shell: ");
    visualizarVector(b);
    }
    
    /**Algoritmo de la sacudida:
 *
 * de derecha a izquierda aplicar intercambios sucesivos (hacemos que los nÂºs pequeÃ±os se desplacen a la izqda.)
 * y luego de izqda. a derecha para que los nÂºs grandes se desplacen por el vector.
 *
 * el penÃºltimo  > el Ãºltimo = intercambio
 * penultimo > antepenultimo = intercambio
 *
 * @author aturmeda0
 */
    public static void sacudida(int[]a){
            int izquierda = 1;
            int derecha = a.length;
            int ultimo = a.length - 1;
            int intercambios = -1;
            while ((izquierda < derecha)&&(intercambios!=0)) {
                for (int i = a.length - 1; i >= izquierda; i--) {
                    if (a[i - 1] > a[i]) {
                        int aux = a[i];
                        a[i] = a[i - 1];
                        a[i - 1] = aux;
                        ultimo = i;
                        intercambios++;
                    }
                }
                izquierda = ultimo + 1;
                for (int j = 1; j < derecha; j++) {
                    if (a[j - 1] > a[j]) {
                        int aux = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = aux;
                        ultimo = j;
                        intercambios++;
                    }
                }
                derecha = ultimo--;
            }
            System.out.print("Vector ordenado con sacudida: ");
            visualizarVector(a);
    }

public static void main(String[]args){
    final int[]vector={3,12,56,6,2,87,1000,43,25};
    try{
        System.out.print("Vector original: ");
        visualizarVector(vector);
        burbuja_v0(vector);
        burbuja_v1(vector);
        burbuja_v2(vector);
        seleccion_directa(vector);
        shell(vector);
        sacudida(vector);
    }catch(Exception e){}
}

}
