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
public class LlistaAlumnes {
    
    private NodeAlumne primer;
    private int numAlumnes;
    
    public LlistaAlumnes(){
        this.primer = null;
    }
    
    public void add(Alumne al){
        NodeAlumne element;
        element = new NodeAlumne(al);
        if (this.primer == null){
            primer = element;
//            primer.add(element);
            numAlumnes++;
        }else{
            NodeAlumne aux = this.primer;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.add(element);
            numAlumnes++;
        }
    }
    
    public Alumne get(int index){
        NodeAlumne aux = this.primer;
        for (int i = 0; i < index; i++){
            aux = aux.getNext();
        }
        return aux.getAlumne();
    }
    
    public void remove(int dni) {
        NodeAlumne aux = this.primer;
        NodeAlumne anterior = aux;
        while (aux.getAlumne().getDni() != dni) {
            anterior = aux;
            aux = aux.getNext();
        }
        if (aux.getAlumne().getDni() == dni) {
            anterior.setNext(aux.getNext());
        }
    }

    public String print() {
        NodeAlumne aux = this.primer;
        String string = "";
        while (aux.getNext() != null) {
            string += aux.getAlumne().getNomAlumne();
            aux = aux.getNext();
        }
        if (aux.getNext() == null) {
            string += aux.getAlumne().getNomAlumne();
        }
        return string;
    }
    
     public boolean isIn(int dni) {
        NodeAlumne aux = this.primer;
        boolean existe = false;
        while (aux.getNext() != null) {
            if (dni == aux.getAlumne().getDni()) {
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
         return numAlumnes;
     }

   public int indexOf(Alumne alumne) {
       NodeAlumne aux = this.primer;
       int index=0;
       while (aux.getAlumne() != alumne){
           aux.getNext();
           index++;
       }
        return index;
    }
    
}
