/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alumnescursoscodi;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class LlistaReferenciaAlumnes {
    
    private ArrayList<ReferenciaAlumne> Llista;

    public LlistaReferenciaAlumnes() {
        Llista =  new ArrayList();
    }
    
    public void add(ReferenciaAlumne Ref){
        Llista.add(Ref);
    }
    
    public void remove(int i){
        Llista.get(i).remove();
        Llista.remove(i);
    }
    
    public ReferenciaAlumne get(int i){
        return Llista.get(i);
    }
    
    public int size(){
        return Llista.size();
    }
    
    public boolean contains (ReferenciaAlumne ref){
        return Llista.contains(ref);
    }
    
    public boolean isEmpty(){
        return Llista.isEmpty();
    }
    
    public String  printLlista() {
         String a="\n";
        for (int i = 0; i < Llista.size(); i++) {
            a=a+("  Alumne: " + Llista.get(i).getAlumne().getNomAlumne() + " Codi: " + Llista.get(i).getAlumne().getDni());
            a=a+"\n";
        }
        return a;
    }
    
}
