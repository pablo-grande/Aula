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
public class LlistaReferenciaAlumnes {

    private ReferenciaAlumne primer;
    private int numRef;

    public LlistaReferenciaAlumnes() {
        this.primer = null;
    }
    
    /*
    get
    */

    public void add(ReferenciaAlumne refAl) {
        ReferenciaAlumne element;
        element = new ReferenciaAlumne(refAl.getAlumne(), refAl.getAssignatura());
        if (this.primer == null) {
            this.primer = element;
            numRef++;
        } else {
            ReferenciaAlumne aux = this.primer;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.add(element);
            numRef++;
        }
    }

//    public void remove(ReferenciaAlumne refAl) {
//        ReferenciaAlumne aux = this.primer;
//        ReferenciaAlumne anterior = aux;
//        while (aux.getNext() != refAl) {
//            anterior = aux;
//            aux = aux.getNext();
//        }
//        if (aux.equals(refAl)) {
//            anterior.setNext(aux.getNext());
//            numRef--;
//        }
//    }
    
    public void remove(int i){
        ReferenciaAlumne aux = this.primer;
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
    

    public String print() {
        String info="";
        ReferenciaAlumne aux;
        for (aux = this.primer; aux.getNext() != null; aux = aux.getNext()) {
            info += "Assignatura: " + aux.getAssignatura().getNomAssignatura() + " Alumne: " + aux.getAlumne().getNomAlumne();
        }
        return info;
    }
    
    public boolean isIn(int dni, int codi){
        ReferenciaAlumne aux = this.primer;
        boolean existe = false;
        while (aux.getNext() != null){
            if ((codi == aux.getAssignatura().getCodiAssignatura()) && (dni == aux.getAlumne().getDni())){
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
        return numRef;
    }

}
