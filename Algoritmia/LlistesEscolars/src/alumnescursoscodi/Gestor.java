/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnescursoscodi;

import java.io.*;

/**
 *
 * @author pablo
 */
public class Gestor {

    static ListaCursos llistaCursos = new ListaCursos();
    static ListaAlumnes llistaAlumnes = new ListaAlumnes();
    
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
    public static void AltaCurs(String nomCurs, int codiCurs) throws IOException {
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
    public static void AltaAss(int CodiCurs, String nomAss, int codiAss) {
        Assignatura assignatura = new Assignatura(nomAss, codiAss);
        for (int i = 0; i < llistaCursos.size(); i++) {
            if(llistaCursos.get(i).getCodiCurs() == CodiCurs){
                llistaCursos.get(i).getListaAss().add(assignatura);
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
    public static void AltaAlumne(String nomAl, int dni, int codiAss) {
        //donam d'alta l'alumne a la llista
        Alumne alumne = new Alumne(nomAl, dni);
        llistaAlumnes.add(alumne);
        
        //extreim l'assignatura i el curs de l'assignatura
        int indexCurs = CercaCursAssignatura(codiAss);
        int indexAss = CercaAssignatura(codiAss);
        
        //construim el que sirà la seva assignatura
        Assignatura assignatura = llistaCursos.get(indexCurs).getListaAss().get(indexAss);
        
        //feim una referencia de l'alumne a aquesta assigntura
        ReferenciaAlumne refAl = new ReferenciaAlumne(alumne, assignatura);
        llistaCursos.get(indexCurs).getListaAss().get(indexAss).getLlistaAl().add(refAl);
        
        //feim una referencia de l'assignatura a aquest alumne
        ReferenciaAssignatura refAss = new ReferenciaAssignatura (assignatura, alumne);
        int indexAl = llistaAlumnes.getIndexOf(alumne);
        llistaAlumnes.get(indexAl).getListaAss().add(refAss);
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
    public static int CercaCurs(int codiCurs) {
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
    public static int CercaAssignatura(int codiAss) {
        int resCercaAss = -1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int k = 0; k < llistaCursos.get(i).getListaAss().size(); k++) {
                if (codiAss == (llistaCursos.get(i).getListaAss().get(k).getCodiAssignatura())) {
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
    public static int CercaCursAssignatura(int codiAss) {
        int resCercaAss = -1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int k = 0; k < llistaCursos.get(i).getListaAss().size(); k++) {
                if (codiAss == (llistaCursos.get(i).getListaAss().get(k).getCodiAssignatura())) {
                    resCercaAss = i;
                }
            }
        }
        return resCercaAss;
    }

    /**
     * Mètode que dona de baixa un curs.
     *Donat el codi d'un curs, es cerca per la llista de cursos fins a trobar
     * una coincidencia, en el cas de que coincidesquin, s'esborra el curs.
     * 
     * @param codi
     * @throws IOException
     */
    public static void BaixaCurs(int codi) {
        for (int i = 0; i < llistaCursos.size(); i++) {
            if (llistaCursos.get(i).getCodiCurs() == codi){
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
    public static void BaixaAssignatura(int codAss) {
        for (int i = 0; i < llistaCursos.size(); i++) {
            int tamLAss = llistaCursos.get(i).getListaAss().size();
            for (int j = 0; j < tamLAss; j++) {
                if (llistaCursos.get(i).getListaAss().get(j).getCodiAssignatura() == codAss){
                    llistaCursos.get(i).getListaAss().remove(j);
                }
            }           
        }
    }
    
    public static void BaixaAlumne (int dni){
        for (int i = 0; i < llistaAlumnes.size(); i++) {
            if(llistaAlumnes.get(i).getDni() == dni){
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
    public static String LlistarAssignaturesIAlumnes(int indexCurs) {
        //treim les assignatures de resCerca
//        String a = "";
//        int indexCurs_4 = resCerca;
//        if (indexCurs_4 == -1) {
//            a = null;
//        } else {
//            for (int i = 0; i < llistaCursos.get(indexCurs_4).getListaAss().size(); i++) {
//                a = a + ("Assignatura: " + llistaCursos.get(indexCurs_4).getListaAss().get(i).getNomAssignatura() + " Codi: " + llistaCursos.get(indexCurs_4).getListaAss().get(i).getCodiAssignatura());
//                a = a + (". Alumnes: ");
//                a = a + llistaCursos.get(indexCurs_4).getListaAss().get(i).getLlistaAl().printLlista();
//                a = a + "\n";
//            }
//        }
//        return a;
        String res = "";
        for (int i = 0; i < llistaCursos.size(); i++) {
            int tamLAss = llistaCursos.get(i).getListaAss().size();
            for (int j = 0; j < tamLAss; j++) {
                res += llistaCursos.get(i).getListaAss().printAssignatura(j);
                int tamLAl = llistaCursos.get(i).getListaAss().get(j).getLlistaAl().size();
                for (int k = 0; k < tamLAl; k++) {
                    res += llistaCursos.get(i).getListaAss().get(j).getLlistaAl().get(k).getAlumne().toString();
                }
                res=res + "\n";
            }
        }
        return res;
    }
    
    public static String LlistarCursiAlumnes(int indexAss){
        String res="";
        int j=-1;
        int k=-1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int p = 0; p < llistaCursos.get(i).getListaAss().size(); p++) {
                if (llistaCursos.get(i).getListaAss().get(p).getCodiAssignatura() == indexAss) {
                    res=res+llistaCursos.get(i).toString();
                    j=p;
                    k=i;
                    p=llistaCursos.get(i).getListaAss().size()+1;
                }
            }
            if(j!=-1){
                i=llistaCursos.size();
            }
        }
        if(j!=-1&&k!=-1){
            res=res+llistaCursos.get(k).getListaAss().get(j).getLlistaAl().printLlista();
            System.out.println(res);
        }
        return res;
    }
    
    public static String LlistarCursiAssignatures(int z) {
        String lista="";
        int l = -1; 
//        int k = -1; //Curso
//        int j = -1; //Asignatura
        for (int p = 0; p < llistaCursos.size(); p++) {
            for (int i = 0; i < llistaCursos.get(p).getListaAss().size(); i++) {
                for (int h = 0; h < llistaCursos.get(p).getListaAss().get(i).getLlistaAl().size(); h++) {
                    if (z == llistaCursos.get(p).getListaAss().get(i).getLlistaAl().get(h).getAlumne().getDni()) {
                        if(l==-1){
                            lista = lista + llistaCursos.printCursCod(p);
                            l=0;
                        }
                        lista = lista + llistaCursos.get(p).getListaAss().printAssignatura(i);
//                        j = i;
//                        k = p;
//                        l = h;
                    }
                }
                lista = lista + "\n";
//                        if(cod==Gestor.llistaCursos.get(p).getListaAss().get(i).getCodiAssignatura()){
//                            j=i;
//                            k=p;
//                            p=Gestor.llistaCursos.size();
//                            i=Gestor.llistaCursos.get(p).getListaAss().get(i).getCodiAssignatura();
//                        }
            }
            l=-1;
            lista = lista + "\n\n";
        }
//        if (j != -1 && k != -1 && l != -1) {
////            lista = lista + llistaCursos.printCursCod(k);
//            for (int w = 0; w < llistaCursos.get(k).getListaAss().get(j).getLlistaAl().size();w++) {
//                lista = lista + llistaCursos.get(k).getListaAss().get(j).getLlistaAl().get(w).toString();
//            }
//        }
        return lista;
    }

}
