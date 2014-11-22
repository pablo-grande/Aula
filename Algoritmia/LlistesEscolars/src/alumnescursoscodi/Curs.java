/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnescursoscodi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pablo
 */
public class Curs {

    private String nomCurs;
    private int codiCurs;
    private ListaAsignaturas llistaAss;

    public Curs(String nomCurs, int codiCurs) {
        this.nomCurs = nomCurs;
        this.codiCurs = codiCurs;
        this.llistaAss = new ListaAsignaturas();
    }

    public String getNomCurs() {
        return nomCurs;
    }

    public void setNomCurs(String nomCurs) {
        this.nomCurs = nomCurs;
    }

    public int getCodiCurs() {
        return codiCurs;
    }

    public void setCodiCurs(int codiCurs) {
        this.codiCurs = codiCurs;
    }
    
    public ListaAsignaturas getListaAss(){
        return llistaAss;
    }
    
    public void removeListaAss(){
        this.llistaAss = new ListaAsignaturas();
    }
    
    public String toString(){
        String res="Nombre del curso: "+nomCurs+". Código del curso: " + codiCurs+".\n";
        return res;
    }

}
