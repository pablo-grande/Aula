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
public class NodeAssignatura {

    private Assignatura ass;
    private NodeAssignatura seg; //apuntador al següent node de la llista

    public NodeAssignatura(Assignatura a) {
        this.ass = a;
        this.seg = null;
    }

    public void add(NodeAssignatura seg_node) {
        this.seg = seg_node;
    }

    public void remove() {
        this.ass = null;
        this.seg = null;
    }

    public NodeAssignatura getNext() {
        return this.seg;
    }

    public void setNext(NodeAssignatura next_node) {
        this.seg = next_node;
    }

    public Assignatura getAssignatura() {
        return this.ass;
    }

}
