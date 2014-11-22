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
public class NodeCurs {

    private Curs curs;
    private NodeCurs seg; //apuntador al següent node de la llista

    public NodeCurs(Curs c) {
        this.curs = c;
        this.seg = null;
    }
    
    public void add(NodeCurs seg_node){
        this.seg = seg_node;
    }
    
    public void remove(){
        this.curs = null;
        this.seg = null;
    }
    
    public NodeCurs getNext(){
        return this.seg;
    }
    
    public void setNext(NodeCurs next_node){
        this.seg = next_node;
    }
        
    public Curs getCurs(){
        return this.curs;
    }

}
