/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llistesescolarsref;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Gestor gestor = new Gestor();
            LlistaCursos llistaCursos = gestor.llistaCursos;
            LlistaAlumnes llistaAlumnes = gestor.llistaAlumnes;
            //CURSOS
            //añadir los cursos: OK
//            gestor.AltaCurs("info", 1);
//            gestor.AltaCurs("mat", 2);
//            gestor.AltaCurs("fis", 3);

            //prueba del get: OK
//            for (int i = 0; i < llistaCursos.size(); i++) {
//                System.out.println(llistaCursos.get(i).getNomCurs());
//            }
            
            //prueba del remove: OK
//            llistaCursos.remove(2);
            
            //prueba del isIn: OK
//            if (!llistaCursos.inIn(2)) {
//                System.out.println("No está la asignatura");
//            }
//            
//            if (llistaCursos.inIn(1)) {
//                System.out.println("Está la asignatura");
//            }
            
            gestor.AltaCurs("info", 1);
            gestor.AltaCurs("mat", 2);
            gestor.AltaCurs("fis", 3);
          
            //prueba alta ass: OK
            gestor.AltaAss(1, "alg", 11);
            gestor.AltaAss(1, "so", 12);
            gestor.AltaAss(2, "calc", 21);
            gestor.AltaAss(2, "dis", 22);
            gestor.AltaAss(3, "elec", 31);
            gestor.AltaAss(3, "cosmo", 32);
            
            //prueba alta al: OK
            gestor.AltaAlumne("Pau", 431, 11);
//            gestor.AltaAlumne("Marta", 430, 32);
            System.out.println(gestor.LlistarAssignaturesIAlumnes(0));
            
//            System.out.println(gestor.CercaAssignatura(12));
//            System.out.println(gestor.CercaCursAssignatura(12));
            
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void printCursos(LlistaCursos llistaCursos){
        System.out.println("");
        System.out.println(llistaCursos.print());
    }
    
    public static void printAss(LlistaCursos llistaCursos){
        System.out.println("");
        for (int i = 0; i < llistaCursos.size(); i++) {
            System.out.println(llistaCursos.get(i).getNomCurs());
            for (int j = 0; j < llistaCursos.get(i).getList().size(); j++) {
                System.out.println(llistaCursos.get(i).getList().get(j).getNomAssignatura());
            }
        }
    }
}
