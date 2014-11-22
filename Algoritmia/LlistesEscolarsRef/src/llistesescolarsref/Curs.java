/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package llistesescolarsref;

/**
 *
 * @author pablo
 */
public class Curs {

    private String nomCurs;
    private int codiCurs;
    private LlistaAssignatures llistaAss;

    public Curs(String nomCurs, int codiCurs) {
        this.nomCurs = nomCurs;
        this.codiCurs = codiCurs;
        this.llistaAss = new LlistaAssignatures();
    }

    public String getNomCurs() {
        return nomCurs;
    }

    public int getCodiCurs() {
        return codiCurs;
    }
    
    public LlistaAssignatures getList(){
        return this.llistaAss;
    }

}
