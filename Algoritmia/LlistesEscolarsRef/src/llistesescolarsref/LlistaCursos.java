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
public class LlistaCursos {

    private static int numCursos = 0;
    private NodeCurs primer;

    public LlistaCursos() {
        this.primer = null;
    }

    public void add(Curs curs) {
        NodeCurs element = new NodeCurs(curs);
        if (this.primer == null) {
            this.primer = element;
            numCursos++;
        } else {
            NodeCurs aux = this.primer;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.add(element);
            numCursos++;
        }
    }
    
    public Curs get(int index){
        NodeCurs aux = this.primer;
        for (int i = 0; i < index; i++){
            aux = aux.getNext();
        }
        return aux.getCurs();
    }
    
    public void remove(int codiCurs) {
        NodeCurs aux = this.primer;
        NodeCurs anterior = aux;
        while (aux.getCurs().getCodiCurs() != codiCurs) {
            anterior = aux;
            aux = aux.getNext();
        }
        if (aux.getCurs().getCodiCurs() == codiCurs) {
            anterior.setNext(aux.getNext());
        }
    }

    public String print() {
        NodeCurs aux = this.primer;
        String string = "";
        while (aux.getNext() != null) {
            string += aux.getCurs().getNomCurs()+"\n";
            aux = aux.getNext();
        }
        if (aux.getNext() == null) {
            string += aux.getCurs().getNomCurs();
        }
        return string;
    }
    
    /**
     * Eloy, te arreglo este.
     * Para que un while funcione tiene que haber actualización de variable.
     * 
     * @param cod
     * @return 
     */
    public boolean inIn(int cod) {
        NodeCurs aux = this.primer;
        boolean existe = false;
        while (aux.getNext() != null) {
            if (cod == aux.getCurs().getCodiCurs()) {
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
        return numCursos;
    }
}
