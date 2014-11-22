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
public class Element {
    
    private String nom;
    private int codi;
    
    protected Element(String n, int c){
        nom = n;
        codi = c;
    }

    public String getNom() {
        return nom;
    }

    public int getCodi() {
        return codi;
    }
    
    /**
     * Retorna la informació corresponent al nom identificatiu de l'element.
     * @return String Nom de l'element.
     */
    protected String escriure() {
        String res = "";
        res += "\n================================================\n";
        res += "Informació de l'element: "+nom+", codi: "+codi+"\n";
        res += "-----------------------------------------------\n";
        return res;
    }
    
}
