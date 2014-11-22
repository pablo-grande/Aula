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
public class NodeAlumne {

    private Alumne alumne;
    private NodeAlumne seg; //apuntador al següent node de la llista

    public NodeAlumne(Alumne al) {
        this.alumne = al;
        this.seg = null;
    }

    public void add(NodeAlumne seg_node) {
        this.seg = seg_node;
    }

    public void remove() {
        this.alumne = null;
        this.seg = null;
    }

    public NodeAlumne getNext() {
        return this.seg;
    }

    public void setNext(NodeAlumne next_node) {
        this.seg = next_node;
    }

    public Alumne getAlumne() {
        return this.alumne;
    }

}
