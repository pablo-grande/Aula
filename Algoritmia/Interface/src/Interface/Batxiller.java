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
public class Batxiller extends Curs {
    
    private String ordre;

    public Batxiller(String nomCurs, int codiCurs, String o) {
        super(nomCurs, codiCurs);
        ordre = o;
    }

    public String getOrdre() {
        return ordre;
    }
    
    protected String escriure(){
        String res=super.toString();
        res += "Batxiller, "+ "ordre: "+getOrdre();
        return res;
    }
    
}
