/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author pablo
 */
public class Curs extends Element{

//    private String nomCurs;
//    private int codiCurs;
    private ListaAsignaturas llistaAss;

    public Curs(String nomCurs, int codiCurs) {
       super(nomCurs, codiCurs);
        this.llistaAss = new ListaAsignaturas();
    }

    
    public ListaAsignaturas getListaAss(){
        return llistaAss;
    }
    
    public void removeListaAss(){
        this.llistaAss = new ListaAsignaturas();
    }
    
     public String toString(){
        String res="";
        return res;
    }

}
