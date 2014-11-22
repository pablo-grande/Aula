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
public class ReferenciaAssignatura {
    
    private Alumne alumne;
    private Assignatura assignatura;
    private ReferenciaAssignatura seg;
    
    public ReferenciaAssignatura(Assignatura ass, Alumne al){
        this.alumne = al;
        this.assignatura = ass;
        this.seg = null;
    }
    
    public void add(ReferenciaAssignatura seg_node){
        this.seg = seg_node;
    }
    
    public void remove(){
        this.alumne = null;
        this.assignatura = null;
        this.seg = null;
    }
    
    public ReferenciaAssignatura getNext(){
        return this.seg;
    }
    
    public void setNext(ReferenciaAssignatura seg_node){
        this.seg = seg_node;
    }
    
    public Alumne getAlumne(){
        return this.alumne;
    }
    
    public Assignatura getAssignatura(){
        return this.assignatura;
    }
    
}
