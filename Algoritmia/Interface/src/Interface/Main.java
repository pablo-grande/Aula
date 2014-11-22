/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

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
            final String INT = "introducció a ";
            final String PRIMER = "primer";
            final String SEGON = "segon";
            // TODO code application logic here
            Gestor g = new Gestor();
            
            //Cursos
            g.AltaCurs(INT+"l'electrònica", 000, "electrònica");
            g.AltaCurs(INT+"l'informàtica", 001, "informàtica");
            g.AltaCurs(INT+"la mecànica", 002, "mecànica");
            g.AltaCurs(INT+"biologia", 003, PRIMER);
            g.AltaCurs(INT+"química", 004, SEGON);
            
            //Assignatures de cada curs
            g.AltaAss(000, "Sistemes digitals", 100, 6); //Aquesta es obligatòria
            g.AltaAss(001, "Aplicacions web", 101, "pràctica");//Aquesta es optativa
            
            //Anem a veure l'estat de les llistes
            System.out.println("\n \n Llistar assignatures del curs 000");
            System.out.println(g.llistarAssignatures(000));
            
            //Anem a veure el curs d'una assignatura
            System.out.println("\n \n Curs de  l'assignatura 101");
            System.out.println(g.llistarCursAssignatura(101));
            
            //Anem a veure les assignatures tipo optativa
            System.out.println("\n \n Llistar assignatures optatives");
            System.out.println(g.llistarAssignaturesTipus("optativa"));
            
            //Anem a veure les assignatures tipus obligatòria
            System.out.println("\n \n Llistar assignatures obligatòries");
            System.out.println(g.llistarAssignaturesTipus("obligatòria"));

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
