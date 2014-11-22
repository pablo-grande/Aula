package setembre;

/**
 * Esta clase utiliza las especificaciones de la clase letra para construir un
 * alfabeto que pueda manejarse tanto en braille como de manera convencional.
 *
 * @see Letra
 * @author Pablo
 */
public class Alfabeto {

    //26 letras + punto + mayuscula + numerico + blanco = 31 posiciones de array
    Letra alfabeto[] = new Letra[31];

    /**
     * En esta práctica, cada componenete del alfabeto tiene un significado
     * polimórfico: -Puede respresentar las letra minúsculas, -Puede representar
     * las letras mayúsculas, -Puede representar una matriz de puntos y ('o')
     * --> codificación braille -Puede representar un carácter especial ('.','
     * ');
     *
     * A continuación se construye el alfabeto teniendo en cuenta todos los
     * factores anteriores.
     */
    public Alfabeto() {

        //letra a 
        alfabeto[0] = new Letra('1', 'a', 'A');
        alfabeto[0].setRelieve(0, 0);

        //letra b
        alfabeto[1] = new Letra('2', 'b', 'B');
        alfabeto[1].setRelieve(0, 0);
        alfabeto[1].setRelieve(1, 0);


        //letra c
        alfabeto[2] = new Letra('3', 'c', 'C');
        alfabeto[2].setRelieve(0, 0);
        alfabeto[2].setRelieve(0, 1);

        //letra d
        alfabeto[3] = new Letra('4', 'd', 'D');
        alfabeto[3].setRelieve(0, 0);
        alfabeto[3].setRelieve(0, 1);
        alfabeto[3].setRelieve(1, 1);


        //letra e
        alfabeto[4] = new Letra('5', 'e', 'E');
        alfabeto[4].setRelieve(0, 0);
        alfabeto[4].setRelieve(1, 1);

        //letra f
        alfabeto[5] = new Letra('6', 'f', 'F');
        alfabeto[5].setRelieve(0, 0);
        alfabeto[5].setRelieve(0, 1);
        alfabeto[5].setRelieve(1, 0);


        //letra g
        alfabeto[6] = new Letra('7', 'g', 'G');
        alfabeto[6].setRelieve(0, 0);
        alfabeto[6].setRelieve(0, 1);
        alfabeto[6].setRelieve(1, 0);
        alfabeto[6].setRelieve(1, 1);

        //letra h
        alfabeto[7] = new Letra('8', 'h', 'H');
        alfabeto[7].setRelieve(0, 0);
        alfabeto[7].setRelieve(1, 0);
        alfabeto[7].setRelieve(1, 1);

        //letra i
        alfabeto[8] = new Letra('9', 'i', 'I');
        alfabeto[8].setRelieve(0, 1);

        //letra j
        alfabeto[9] = new Letra('0', 'j', 'J'); //Último número
        alfabeto[9].setRelieve(0, 1);
        alfabeto[9].setRelieve(1, 0);
        alfabeto[9].setRelieve(1, 1);

        //letra k
        alfabeto[10] = new Letra('k', 'K');
        alfabeto[10].setRelieve(0, 0);
        alfabeto[10].setRelieve(2, 0);

        //letra l
        alfabeto[11] = new Letra('l', 'L');
        alfabeto[11].setRelieve(0, 0);
        alfabeto[11].setRelieve(1, 0);
        alfabeto[11].setRelieve(2, 0);

        //letra m
        alfabeto[12] = new Letra('m', 'M');
        alfabeto[12].setRelieve(0, 0);
        alfabeto[12].setRelieve(0, 1);
        alfabeto[12].setRelieve(2, 0);

        //letra n
        alfabeto[13] = new Letra('n', 'N');
        alfabeto[13].setRelieve(0, 0);
        alfabeto[13].setRelieve(0, 1);
        alfabeto[13].setRelieve(1, 1);
        alfabeto[13].setRelieve(2, 0);

        //letra ñ
        alfabeto[14] = new Letra('ñ', 'Ñ');
        alfabeto[14].setRelieve(0, 0);
        alfabeto[14].setRelieve(0, 1);
        alfabeto[14].setRelieve(1, 0);
        alfabeto[14].setRelieve(1, 1);
        alfabeto[14].setRelieve(2, 1);

        //letra o
        alfabeto[15] = new Letra('o', 'O');
        alfabeto[15].setRelieve(0, 0);
        alfabeto[15].setRelieve(1, 1);
        alfabeto[15].setRelieve(2, 0);

        //letra p
        alfabeto[16] = new Letra('p', 'P');
        alfabeto[16].setRelieve(0, 0);
        alfabeto[16].setRelieve(0, 1);
        alfabeto[16].setRelieve(1, 0);
        alfabeto[16].setRelieve(2, 0);

        //letra q
        alfabeto[17] = new Letra('q', 'Q');
        alfabeto[17].setRelieve(0, 0);
        alfabeto[17].setRelieve(0, 1);
        alfabeto[17].setRelieve(1, 0);
        alfabeto[17].setRelieve(1, 1);
        alfabeto[17].setRelieve(2, 0);

        //letra r
        alfabeto[18] = new Letra('r', 'R');
        alfabeto[18].setRelieve(0, 0);
        alfabeto[18].setRelieve(1, 0);
        alfabeto[18].setRelieve(1, 1);
        alfabeto[18].setRelieve(2, 0);

        //letra s
        alfabeto[19] = new Letra('s', 'S');
        alfabeto[19].setRelieve(0, 1);
        alfabeto[19].setRelieve(1, 0);
        alfabeto[19].setRelieve(2, 0);

        //letra t
        alfabeto[20] = new Letra('t', 'T');
        alfabeto[20].setRelieve(0, 1);
        alfabeto[20].setRelieve(1, 0);
        alfabeto[20].setRelieve(1, 1);
        alfabeto[20].setRelieve(2, 0);

        //letra u
        alfabeto[21] = new Letra('u', 'U');
        alfabeto[21].setRelieve(0, 0);
        alfabeto[21].setRelieve(2, 0);
        alfabeto[21].setRelieve(2, 1);

        //letra v
        alfabeto[22] = new Letra('v', 'V');
        alfabeto[22].setRelieve(0, 0);
        alfabeto[22].setRelieve(1, 0);
        alfabeto[22].setRelieve(2, 0);
        alfabeto[22].setRelieve(2, 1);

        //letra w
        alfabeto[23] = new Letra('w', 'w', 'W');
        alfabeto[23].setRelieve(0, 1);
        alfabeto[23].setRelieve(1, 0);
        alfabeto[23].setRelieve(1, 1);
        alfabeto[23].setRelieve(2, 1);

        //letra x
        alfabeto[24] = new Letra('x', 'X');
        alfabeto[24].setRelieve(0, 0);
        alfabeto[24].setRelieve(0, 1);
        alfabeto[24].setRelieve(2, 0);
        alfabeto[24].setRelieve(2, 1);

        //letra y
        alfabeto[25] = new Letra('y', 'Y');
        alfabeto[25].setRelieve(0, 0);
        alfabeto[25].setRelieve(0, 1);
        alfabeto[25].setRelieve(1, 1);
        alfabeto[25].setRelieve(2, 0);
        alfabeto[25].setRelieve(2, 1);

        //letra z
        alfabeto[26] = new Letra('z', 'Z');
        alfabeto[26].setRelieve(0, 0);
        alfabeto[26].setRelieve(1, 1);
        alfabeto[26].setRelieve(2, 0);
        alfabeto[26].setRelieve(2, 1);

        //punto
        alfabeto[27] = new Letra('.', '.', '.');
        alfabeto[27].setRelieve(1, 0);

        //mayuscula
        alfabeto[28] = new Letra();
        alfabeto[28].setRelieve(0, 1);
        alfabeto[28].setRelieve(2, 1);

        //numerico
        alfabeto[29] = new Letra();
        alfabeto[29].setRelieve(0, 1);
        alfabeto[29].setRelieve(1, 1);
        alfabeto[29].setRelieve(2, 0);
        alfabeto[29].setRelieve(2, 1);

        //blanco
        alfabeto[30] = new Letra();
        alfabeto[30].setBlanco(0, 0);
        alfabeto[30].setBlanco(0, 1);
        alfabeto[30].setBlanco(1, 0);
        alfabeto[30].setBlanco(1, 1);
        alfabeto[30].setBlanco(2, 0);
        alfabeto[30].setBlanco(2, 1);

    }
}
