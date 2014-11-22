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
public class ReferenciaAlumne {
    
    private Alumne alumne;
    private Assignatura assignatura;

    public ReferenciaAlumne(Alumne alumne, Assignatura assignatura) {
        this.alumne = alumne;
        this.assignatura = assignatura;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public Assignatura getAssignatura() {
        return assignatura;
    }
    
    public void remove(){
        this.alumne = null;
    }
    
    
}
