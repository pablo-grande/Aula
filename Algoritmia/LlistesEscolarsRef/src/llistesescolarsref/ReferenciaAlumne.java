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
public class ReferenciaAlumne {
    
    private Alumne alumne;
    private Assignatura assignatura;
    private ReferenciaAlumne seg;
    
    public ReferenciaAlumne(Alumne al, Assignatura ass){
        this.alumne = al;
        this.assignatura = ass;
        this.seg = null;
        
    }
    
    public void add(ReferenciaAlumne seg_node){
        this.seg = seg_node;
    }
    
    public void remove (){
        this.alumne = null;
        this.assignatura = null;
        this.seg = null;
    }
    
    public ReferenciaAlumne getNext(){
        return this.seg;
    }
    
    public void setNext(ReferenciaAlumne assal){
        this.seg = assal;
    }
    
    public Alumne getAlumne(){
        return this.alumne;
    }
    
    public Assignatura getAssignatura(){
        return this.assignatura;
    }
    
}
