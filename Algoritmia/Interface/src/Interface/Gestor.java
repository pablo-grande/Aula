/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Gestor {
    
    enum tipus_curs{primer, segon, mecànica, electrònica, informàtica};
    enum tipus_assignatura{teòrica, pràctica};

     ListaCursos llistaCursos = new ListaCursos();
     ArrayList <Optativa> llistaOpt = new ArrayList<Optativa>();
     ArrayList <Obligatoria> llistaObl = new ArrayList<Obligatoria>();
    
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
     * @param nomCurs
     * @param codiCurs
     * @param tipus
     * @throws IOException
     */
    public void AltaCurs(String nomCurs, int codiCurs, String tipus) throws IOException {
        //treim el valor del nostre tipus, enumerat
        String tipusCurs = tipus_curs.valueOf(tipus).toString();
        //treim els numero de valors que poden adquirir al nostre enumerat
        int num_tipus = tipus_curs.valueOf(tipus).ordinal();
        if (num_tipus < 2){
            llistaCursos.addBatx(nomCurs, codiCurs, tipusCurs);
        }else{
            llistaCursos.addFP(nomCurs, codiCurs, tipusCurs);
        }
        System.out.println(printer(nomCurs, codiCurs, tipusCurs, "+"));
    }
    
    /**
     * Mètode que serveix per donar d'alta una assignatura optativa. Donades las dades de
     * l'assignatura (nom i codi) fica aquestes dades a una variable tipus
     * Assignatura i aquesta variable dins la llista d'assignatures d'un curs
     * concret. El curs es determina per la variable indexCurs, que fa
     * referència a un índex de la llista de cursos, el qual conté el curs al
     * que pertany l'assignatura
     * 
     * @param codiCurs
     * @param nomAss
     * @param codiAss 
     * @param tipus 
     */
    public  void AltaAss(int codiCurs, String nomAss, int codiAss, String tipus) {
        String tipusAss = tipus_assignatura.valueOf(tipus).toString();
        for (int i = 0; i < llistaCursos.size(); i++) {
            if(llistaCursos.get(i).getCodi() == codiCurs){
                    llistaCursos.get(i).getListaAss().addOpt(nomAss, codiAss, tipusAss);
            }
        }
        System.out.println(printer(nomAss, codiAss, tipus, "+"));
    }
    
    /**
     * Mètode que serveix per donar d'alta una assignatura obligatoria. Donades las dades de
     * l'assignatura (nom i codi) fica aquestes dades a una variable tipus
     * Assignatura i aquesta variable dins la llista d'assignatures d'un curs
     * concret. El curs es determina per la variable indexCurs, que fa
     * referència a un índex de la llista de cursos, el qual conté el curs al
     * que pertany l'assignatura
     * 
     * @param codiCurs
     * @param nomAss
     * @param codiAss
     * @param credits 
     */
    public void AltaAss(int codiCurs, String nomAss, int codiAss, int credits){
        for (int i = 0; i < llistaCursos.size(); i++) {
            if(llistaCursos.get(i).getCodi() == codiCurs){
                    llistaCursos.get(i).getListaAss().addObl(nomAss, codiAss, credits);
            }
        }
        System.out.println(printer(nomAss, codiAss, "obligatoria", "+"));
    }
   
    /**
     * Mètode que dona de baixa un curs.
     * Donat el codi d'un curs, es cerca per la llista de cursos fins a trobar
     * una coincidencia, en el cas de que coincidesquin, s'esborra el curs.
     * @param codi 
     */
    public  void BaixaCurs(int codi) {
        for (int i = 0; i < llistaCursos.size(); i++) {
            if (llistaCursos.get(i).getCodi() == codi){
                System.out.println(printer(llistaCursos.get(i).getNom(), codi, "", "-"));
                llistaCursos.remove(i);
            }
        }
    }

    /**
     * Mètode que eliminar una assignatura donada per l'usuari. Primerament
     * mostra la llista de cursos amb cada assignatura Demana a l'usuari el nom
     * de l'assigatura del qual es vulgui donar de baixa.
     * 
     * @param codAss 
     */
    public  void BaixaAssignatura(int codAss) {
        for (int i = 0; i < llistaCursos.size(); i++) {
            int tamLAss = llistaCursos.get(i).getListaAss().size();
            for (int j = 0; j < tamLAss; j++) {
                if (llistaCursos.get(i).getListaAss().get(j).getCodi() == codAss){
                    printer(llistaCursos.get(i).getListaAss().get(j).getNom(), codAss, "", "-");
                    llistaCursos.get(i).getListaAss().remove(j);
                }
            }
            for (int j = 0; j < 10; j++) {
                
            }
        }
    }
    
    /**
     * Donat un curs, llistar totes les seves assignatures, amb les
     * característiques de cada assignatura –<obligatòria/optativa,
     * crèdits/perfil>.
     * @param codiCurs
     * @return 
     */
    public String llistarAssignatures(int codiCurs){
        String resultat= "";
        for (int i=0; i<llistaCursos.size(); i++){
            if(codiCurs == llistaCursos.get(i).getCodi()){
                resultat += llistaCursos.get(i).getListaAss().print();
            }
        }
        return resultat;
    }
    
     /**
     * Mètode que cerca una assignatura concreta dins la llista de cursos. Donat
     * el nombre d'una assignatura recor la llista de cursos y dins cada curs
     * (element de la llista de cursos) recorr la llista d'assignatures, quan
     * troba una coincidencia, retorna l'index del curs
     * 
     * @param codiAss
     * @return 
     */
    public int CercaCursAssignatura(int codiAss) {
        int resCercaAss = -1;
        for (int i = 0; i < llistaCursos.size(); i++) {
            for (int k = 0; k < llistaCursos.get(i).getListaAss().size(); k++) {
                if ((llistaCursos.get(i).getListaAss().get(k).getCodi()) == codiAss) {
                    resCercaAss = i;
                }
            }
        }
        return resCercaAss;
    }

    /**
     * Donada una assignatura, indicar a quín curs pertany, amb les 
     * característiques del curs -<FP/Batxiller, especialitat/ordre>.
     * @param codiAssignatura
     * @return 
     */
    public String llistarCursAssignatura(int codiAssignatura){
        String resultat="No s'ha trobat el curs";
        int curs = CercaCursAssignatura(codiAssignatura);
        if (curs!=-1){
            resultat="L'assignatura pertany al curs: " 
                            + llistaCursos.get(curs).getNom() + "\n"
                            + llistaCursos.get(curs).escriure();
        }
        return resultat;
    }
    
    public String llistarAssignaturesTipus (String tipus){
        String resultat = "";
        if(tipus.equalsIgnoreCase("optativa")){
            for (int i = 0; i < llistaCursos.size(); i++) {
                llistaOpt = llistaCursos.get(i).getListaAss().getOptList();
                for (int j = 0; j < llistaOpt.size(); j++) {
                    resultat += llistaOpt.get(j).escriure();
                  //resultat = llistaOpt.get(j).escriure();
                }
            }
        }else if (tipus.equalsIgnoreCase("obligatòria")){
            for (int i = 0; i < llistaCursos.size(); i++) {
                ArrayList<Obligatoria> llistaObl = llistaCursos.get(i).getListaAss().getOblList();
                for (int j = 0; j < llistaObl.size(); j++) {
                    resultat += llistaObl.get(j).escriure();
                }
            }
        }
        return resultat;
    }
    
    public boolean cursOk(int codiCurs){
        for (int i = 0; i < llistaCursos.size(); i++) {
            if (llistaCursos.get(i).getCodi()==codiCurs){
                return true;
            }
        }
        return false;
    }

        
    public String printer(String nom, int codi, String tipo, String estat){
        String res="";
        System.out.println("Curs: "+nom +", codi: "+codi+", tipus: "+tipo+", -> "+estat);
        return res;
    }
    
}
