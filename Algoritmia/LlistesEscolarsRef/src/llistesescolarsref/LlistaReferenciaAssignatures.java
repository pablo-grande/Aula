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
public class LlistaReferenciaAssignatures {
    
    private ReferenciaAssignatura primer;
    private int numRef;
    
    public LlistaReferenciaAssignatures(){
        this.primer = null;
    }
    
    public void add(ReferenciaAssignatura alass){
        ReferenciaAssignatura element;
        element = new ReferenciaAssignatura(alass.getAssignatura(), alass.getAlumne());
        if(this.primer == null){
            primer = element;
            numRef++;
        }else{
            ReferenciaAssignatura aux = this.primer;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.add(element);
            numRef++;
        }
    }
    
//    public void remove(ReferenciaAssignatura refAss){
//        ReferenciaAssignatura aux = this.primer;
//        ReferenciaAssignatura anterior = aux;
//        while (aux.getNext() != refAss){
//            anterior = aux;
//            aux = aux.getNext();
//        }
//        if (aux.equals(refAss)){
//            anterior.setNext(aux.getNext());
//            numRef--;
//        }
//    }
    
    public void remove(int i){
        ReferenciaAssignatura aux = this.primer;
        int contador = 0;
        while(contador != i) {
            aux = aux.getNext();
            contador++;
        }
        if (contador == i){
            aux.remove();
        }
    }
    
    public ReferenciaAlumne get(int index){
        ReferenciaAlumne ref = new ReferenciaAlumne(this.primer.getAlumne(),this.primer.getAssignatura());
        for (int i = 0; i < index; i++){
            ref =  ref.getNext();
        }
        return ref;
    }
    
    public String print(){
        ReferenciaAssignatura aux;
        String string = "";
        for (aux = this.primer; aux.getNext()!= null; aux=aux.getNext()) {
               string += "Alumne: "+ aux.getAlumne().getNomAlumne() +" Assignatura: "+ aux.getAssignatura().getNomAssignatura();
            }
        return string;
    }
    
    public boolean contains(ReferenciaAssignatura ref){
        ReferenciaAssignatura aux = this.primer;
        boolean existe = false;
        while (aux.getNext() != null){
            if (aux.equals(aux)){
                existe = true;
            }
            aux = aux.getNext();
        }
        return existe;
    }
    
    public int size(){
        return numRef;
    }

    
    
}
