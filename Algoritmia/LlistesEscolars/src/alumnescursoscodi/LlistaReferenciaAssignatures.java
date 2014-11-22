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
public class LlistaReferenciaAssignatures {
    
    private ArrayList<ReferenciaAssignatura> Llista;

    public LlistaReferenciaAssignatures() {
        Llista =  new ArrayList();
    }
    
    public void add(ReferenciaAssignatura Ref){
        Llista.add(Ref);
    }
    
    public void remove(int i){
        Llista.get(i).remove();
        Llista.remove(i);
    }
    
    public ReferenciaAssignatura get(int i){
        return Llista.get(i);
    }
    
    public int size(){
        return Llista.size();
    }
    
    public boolean contains (ReferenciaAssignatura ref){
        return Llista.contains(ref);
    }
    
    public boolean isEmpty(){
        return Llista.isEmpty();
    }
      
}
