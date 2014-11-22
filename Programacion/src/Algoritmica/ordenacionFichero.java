package Algoritmica;

import java.io.*;

public class ordenacionFichero {

    public final static int DIM = 4;
    /*  Un numero [4 bytes].  TOTAL BYTES = 4 bytes  */
    private static int Number;

    public ordenacionFichero() {
    }

    public ordenacionFichero(int numero) {
        Number = numero;
    }

    public void read(RandomAccessFile file) throws IOException, java.text.ParseException {
        Number = file.readInt();
    }

    public static void writeGet(RandomAccessFile file, int numero) throws Exception {
        file.writeInt(numero);
    }

    public static void main(String args[]) throws Exception {
        RandomAccessFile fichero = new RandomAccessFile("prueba.dat", "rw");
        long numeros;
        ordenacionFichero numero = null;
        int i = 0;

        try {
            fichero.seek(fichero.length());
            numeros = fichero.length() / 4;
            int vector[] = new int[(int) numeros];
            System.out.println(numeros);
            fichero.seek(0);
            if (fichero != null) {
                numero = new ordenacionFichero();
                numero.read(fichero);
                try {
                    while (numero != null) {
                        vector[i] = ordenacionFichero.Number;
                        i++;
                        numero.read(fichero);
                    }

                } catch (Exception e) {
                }
            }
             
            fichero.seek(0);
            for (int j = 0; j < vector.length; j++)
                fichero.writeInt(vector[j]);
                Ordenacion_P_Riutort.Burbuja_v0(vector, DIM);
        } catch (Exception e) {}
    }
}
