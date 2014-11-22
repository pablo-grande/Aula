/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llistesescolarsref;

import java.io.*;

/**
 *
 * @author pablo
 */
public class Gestor {

    LlistaCursos llistaCursos = new LlistaCursos();
    LlistaAlumnes llistaAlumnes = new LlistaAlumnes();

    public Gestor() {

    }

    /**
     * Mètode que comprova la llista de Cursos si la llista de cursos està
     * inicialitzada ok = true sino, ok = false
     *
     * @return ok
     */
    public boolean LlistaCursosOK() {
        return !(llistaCursos.isEmpty());
    }

    /**
     * Mètode que serveix per donar d'alta un curs. Donades les dades del curs
     * (nom i codi) fica aquestes dades a una variable tipus Curs i aquesta
     * variable dins la llista de cursos (llistaCursos)
     *
     * @throws IOException
     */
    public void AltaCurs(String nomCurs, int codiCurs) throws IOException {
        //instanciam un objecte tipus Curs amb les dades que ens han donat
        Curs curs = new Curs(nomCurs, codiCurs);
        //ficam aquesta objecte dins la llista
        llistaCursos.add(curs);
    }

    /**
     * Mètode que serveix per donar d'alta una assignatura. Donades las dades de
     * l'assignatura (nom i codi) fica aquestes dades a una variable tipus
     * Assignatura i aquesta variable dins la llista d'assignatures d'un curs
     * concret. El curs es determina per la variable indexCurs, que fa
     * referència a un índex de la llista de cursos, el qual conté el curs al
     * que pertany l'assignatura
     *
     * @param indexCurs
     * @throws IOException
     */
    public void AltaAss(int CodiCurs, String nomAss, int codiAss) {
        Assignatura assignatura = new Assignatura(nomAss, codiAss);
        for (int i = 0; i < llistaCursos.size(); i++) {
            if (llistaCursos.get(i).getCodiCurs() == CodiCurs) {
                llistaCursos.get(i).getList().add(assignatura);
            }
        }
    }

    /**
     * Mètode que serveix per donar d'alta un alumne. Funciona igual que els dos
     * mètodes anteriors. Demana el curs i l'assignatura on estigui matriculat
     * l'alumne.
     *
     * @param indexAssignatura
     * @throws IOException
     */
    public void AltaAlumne(String nomAl, int dni, int codiAss) {
        //donam d'alta l'alumne a la llista
        Alumne alumne = new Alumne(nomAl, dni);
        llistaAlumnes.add(alumne);

        //extreim l'assignatura i el curs de l'assignatura
        int indexCurs = CercaCursAssignatura(codiAss);
        int indexAss = CercaAssignatura(codiAss);
        //construim el que sirà la seva assignatura
        Assignatura assignatura = llistaCursos.get(indexCurs).getList().get(indexAss);

        //feim una referencia de l'alumne a aquesta assigntura
        ReferenciaAlumne refAl = new ReferenciaAlumne(alumne, assignatura);
        llistaCursos.get(indexCurs).getList().get(indexAss).getList().add(refAl);
        
        //feim una referencia de l'assignatura a aquest alumne
        ReferenciaAssignatura refAss = new ReferenciaAssignatura(assignatura, alumne);
        int indexAl = llistaAlumnes.indexOf(alumne);
        llistaAlumnes.get(indexAl).getList().add(refAss);
    }

    /**
     * Mètode que cerca un curs concret. Donat el codi d'un curs, recor la
     * llista de cursos. quan troba una coincidencia, retorna el número de
     * l'índex de la llista on ho ha trobat
     *
     * @param c
     * @return
     * @throws IOException
     */
    public int CercaCurs(int codiCurs) {
        int resCercaCurs = -1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            if (codiCurs == (llistaCursos.get(i).getCodiCurs())) {
                resCercaCurs = i;
            }
        }
        return resCercaCurs;
    }

    /**
     * Mètode que cerca una assignatura concreta. Funciona igual que el mètode
     * anterior, només que retornant l'índex de l'assignatura enlloc de el del
     * curs.
     *
     * @param codiAss
     * @return
     */
    public int CercaAssignatura(int codiAss) {
        int resCercaAss = -1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int k = 0; k < llistaCursos.get(i).getList().size(); k++) {
                if (codiAss == (llistaCursos.get(i).getList().get(k).getCodiAssignatura())) {
                    resCercaAss = k;
                }
            }
        }
        return resCercaAss;
    }

    /**
     * Mètode que cerca una assignatura concreta dins la llista de cursos. Donat
     * el nombre d'una assignatura recor la llista de cursos y dins cada curs
     * (element de la llista de cursos) recorr la llista d'assignatures, quan
     * troba una coincidencia, retorna l'index del curs
     *
     * @param nomAss
     * @return
     */
    public int CercaCursAssignatura(int codiAss) {
        int resCercaAss = -1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int k = 0; k < llistaCursos.get(i).getList().size(); k++) {
                if (codiAss == (llistaCursos.get(i).getList().get(k).getCodiAssignatura())) {
                    resCercaAss = i;
                }
            }
        }
        return resCercaAss;
    }

    /**
     * Mètode que dona de baixa un curs. Donat el codi d'un curs, es cerca per
     * la llista de cursos fins a trobar una coincidencia, en el cas de que
     * coincidesquin, s'esborra el curs.
     *
     * @param codi
     * @throws IOException
     */
    public void BaixaCurs(int codi) {
        for (int i = 0; i < llistaCursos.size(); i++) {
            if (llistaCursos.get(i).getCodiCurs() == codi) {
                llistaCursos.remove(i);
            }
        }
    }

    /**
     * Mètode que eliminar una assignatura donada per l'usuari. Primerament
     * mostra la llista de cursos amb cada assignatura Demana a l'usuari el nom
     * de l'assigatura del qual es vulgui donar de baixa
     *
     * Per eliminar una assignatura necessitam 2 coses: l'índex del curs al que
     * pertany l'índex de l'assignatura
     *
     * Es fa una cerca d'ambdós índex amb CercaCursAssAlignatura i
     * CercaAssignatura amb els dos índex ja podem donar de baixa una
     * assignatura.
     *
     * @throws IOException
     */
    public void BaixaAssignatura(int codAss) {
        for (int i = 0; i < llistaCursos.size(); i++) {
            int tamLAss = llistaCursos.get(i).getList().size();
            for (int j = 0; j < tamLAss; j++) {
                if (llistaCursos.get(i).getList().get(j).getCodiAssignatura() == codAss) {
                    llistaCursos.get(i).getList().remove(j);
                }
            }
        }
    }

    public void BaixaAlumne(int dni) {
        for (int i = 0; i < llistaAlumnes.size(); i++) {
            if (llistaAlumnes.get(i).getDni() == dni) {
                llistaAlumnes.remove(i);
            }

        }
    }

    /**
     * Mètode que serveix per a llistar les assignatures d'un curs donat. Recorr
     * la llista d'assignatures del curs donat per paràmetre, mostra les
     * assignatures i treu els alumnes de cada assignatura.
     *
     * @param resCerca
     */
    public String LlistarAssignaturesIAlumnes(int indexCurs) {
        String res = "a";
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int j = 0; j < llistaCursos.get(i).getList().size(); j++) {
                res += llistaCursos.get(i).getList().get(j).getNomAssignatura() + ": ";
                for (int k = 0; k < llistaCursos.get(i).getList().get(j).getList().size(); k++) {
                    res += llistaCursos.get(i).getList().get(j).getList().get(k).getAlumne().getNomAlumne()+"\n ";
                }
            }
        }
        return res;
    }

}
