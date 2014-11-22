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
public class Optativa extends Assignatura{
    
    private String perfil;

    public Optativa(String nomAssignatura, int codiAssignatura, String p) {
        super(nomAssignatura, codiAssignatura);
        perfil = p;
    }

    public String getPerfil() {
        return perfil;
    }
    
    protected String escriure(){
        String res=super.escriure();
        res += "Optativa, " + "perfil: "+getPerfil();
        return res;
    }
    
    
}
