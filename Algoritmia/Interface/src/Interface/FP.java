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
public class FP extends Curs{
    
    private String especialitat;

    public FP(String nomCurs, int codiCurs, String e) {
        super(nomCurs, codiCurs);
        especialitat = e;
    }

    public String getEspecialitat() {
        return especialitat;
    }
    
    protected String escriure(){
        String res=super.toString();
        res += "FP, "+"especialitat: "+getEspecialitat();
        return res;
    }
    
}
