/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alumnescursoscodi;

/**
 *
 * @author pablo
 */
public class ReferenciaAssignatura {
    
    private Assignatura assignatura;
    private Alumne alumne;
    
    public ReferenciaAssignatura(Assignatura ass, Alumne al){
        this.assignatura = ass;
        this.alumne = al;
    }
    
    public Assignatura getAssignatura(){
        return this.assignatura;
    }
    
    public Alumne getAlumne(){
        return this.alumne;
    }
    
    public void remove(){
        this.assignatura = null;
    }
    
}
