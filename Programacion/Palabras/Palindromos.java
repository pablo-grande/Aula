/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Palabras;

import java.io.IOException;

/**
 *Un posible algoritmo es:
final enter MAXIM = 20;
estructura Paraula {
caràcter text[MAXIM];
enter llargaria;
}
char lletra;
void comptar_cap-i-cues()
{
enter nombre = 0;
Paraula p;
presentacio();
llegir(lletra);
botar_Blancs();
p = llegirParaula();
while (! buida(p)) {
si esCapicua(p) nombre++;
p = llegirParaula();
}
escriure(n);
}

 * @author pablo
 */
public class Palindromos {

    final int MAXIM = 20;
    char letra;

    void contar_palindromos() throws IOException {
        int contador = 0;
        Palabra p; //Esta palabra llama a la palabra de Palindromos o a la Palabra del paquete Palabra
        presentacion();
        letra = (char) System.in.read();
        Palabra.buscarPalabra();
        p = Palabra.lectura();
        while (!Palabra.vacia(p)) {
            if (esPalindromo(p)) {
                contador++;
            }
              p = Palabra.lectura();
        }
        escribir(contador);
    }

    public void presentacion() {
        System.out.print("Escriba una secuencia de palabra acabada en punto y el programa le dirá cuantas palabras hay que sean palindromos");
    }

    public boolean esPalindromo(Palabra p) {
        boolean es=false;
        int i=0;
        int j = Palabra.longitud(p);
        char []palabra = Palabra.letras(p);
        while (es && (i<j)){
            es = palabra[i]==palabra[j];
            i++;
            j--;
        }
    return es;
    }
    
    public void escribir (int n){
       System.out.print ("El numero de palabras capicuas es "+n);
    }
}
