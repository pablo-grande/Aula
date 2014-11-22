/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package llistesescolarsref;

/**
 *
 * @author pablo
 */
public class LlistaAssignatures {
    
    private NodeAssignatura primer;
    private int numAssignatures = 0;
    
    public LlistaAssignatures(){
        this.primer = null;
    }
    
    public void add(Assignatura ass){
        NodeAssignatura element = new NodeAssignatura(ass);
        if (this.primer == null){
            this.primer = element;
            numAssignatures++;
        }else{
            NodeAssignatura aux = this.primer;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.add(element);
            numAssignatures++;
        }
        
    }
    
    public Assignatura get(int index){
        NodeAssignatura aux = this.primer;
        for (int i = 0; i < index; i++){
            aux = aux.getNext();
        }
        return aux.getAssignatura();
    }
    
    public void remove(int codiAss) {
       NodeAssignatura aux = this.primer;
        NodeAssignatura anterior = aux;
        while (aux.getAssignatura().getCodiAssignatura() != codiAss) {
            anterior = aux;
            aux = aux.getNext();
        }
        if (aux.getAssignatura().getCodiAssignatura() == codiAss) {
            anterior.setNext(aux.getNext());
        }
    }

    public String print() {
        NodeAssignatura aux = this.primer;
        String string = "";
        while (aux.getNext() != null) {
            string += aux.getAssignatura().getNomAssignatura();
            aux = aux.getNext();
        }
        if (aux.getNext() == null) {
            string += aux.getAssignatura().getNomAssignatura();
        }
        return string;
    }
    
     public boolean isIn(int cod) {
        NodeAssignatura aux = this.primer;
        boolean existe = false;
        while (aux.getNext() != null) {
            if (cod == aux.getAssignatura().getCodiAssignatura()) {
                existe = true;
            }
            aux = aux.getNext();
        }
        return existe;
    }
     
     public boolean isEmpty(){
        return this.primer == null;
    }
     
     public int size(){
         return numAssignatures;
     }
    
}
