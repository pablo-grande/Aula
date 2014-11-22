/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

/**
 *
 * @author pablo
 */
public class Obligatoria extends Assignatura{
    
    private int credits;

    public Obligatoria(String nomAssignatura, int codiAssignatura, int credits) {
        super(nomAssignatura, codiAssignatura);
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }
    
    public String escriure(){
        String res=super.escriure();
        res += "Obligatoria, "+"credits: "+getCredits();
        return res;
    }
    
}
