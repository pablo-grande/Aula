package Recuento;
/*
 * ALGORITMO CONTAR_PALABRAS2 ES
 *  caracter car;
 *  entero contador;
 * INICIO
 *  Inicializacion;
 *  Visualizacion_mensaje_introduccion_secuencia_de_caracteres;
 *  Lectura_caracter;
 *  Buscar_palabra;
 *  while queden_palabras_por_tratar{
 *      tratamiento_palabra;
 *      saltar_palabra;
 *      Buscar_palabra;
 *  }
 *  Visualización_resultado;
 * FIN;
 *
 * ALGORITMO BUSCAR_PALABRA ES
 * INICIO
 *  Mientras caracter_leido_no_sea_alfabetico_y_caracter_leido_no_sea_caracter;
 *      lectura_caracter;
 * FIN;
 *
 * ALGORITMO TRATAMIENTO_PALABRA ES
 * INICIO
 *  if caracter_es_igual_a_espacio
 *      incrementar_contador;
 * FIN;
 *
 * ALGORITMO SALTAR_PALABRA ES
 * Inicio
 *  Mientras carácter_leido_sea_alfabetico
 *      lectura_caracter;
 * FIN;
 */
/**
 *
 * @author Pablo
 */


public class Contar_palabras_sub {
    public static char car;
    public static final char ESPACIO=' ';
    public static final char FINAL='.';
    public static int contador=0;
    
    public static void buscar_palabra(){
    try{

        while (car==ESPACIO)
            car=(char)System.in.read();
    }catch (Exception e) {}
}

        public static void saltar_palabra(){
            try{
                while ((car!=ESPACIO) && (car!=FINAL)){
                    car=(char)System.in.read();
                }
            }catch (Exception e){}
        }
public static void main (String [] args) {
    try{

        System.out.print("Introducir texto a tratar: ");
        car=(char)System.in.read();
        buscar_palabra();
        while (car!=FINAL){
            contador++;
            saltar_palabra();
            buscar_palabra();
        }
        System.out.println("Hay "+contador+" palabras");

    }catch (Exception e) {}

}
}