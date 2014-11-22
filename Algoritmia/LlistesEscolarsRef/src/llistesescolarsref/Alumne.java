/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package llistesescolarsref;

/**
 *
 * @author pablo
 */
public class Alumne {

    private String nomAlumne;
    private int dni;
    LlistaReferenciaAssignatures llistaAss;

    public Alumne(String nomAlumne, int dni) {
        this.nomAlumne = nomAlumne;
        this.dni = dni;
        this.llistaAss = new LlistaReferenciaAssignatures();
    }

    public String getNomAlumne() {
        return nomAlumne;
    }

    public int getDni() {
        return dni;
    }
    
    public LlistaReferenciaAssignatures getList(){
        return this.llistaAss;
    }
    
    public void removeListaAss(){
        for (int i = 0; i < this.llistaAss.size(); i++) {
            if (this.llistaAss.get(i).getAlumne().getDni() == this.dni){
                llistaAss.remove(i);
            }
        }
        this.llistaAss = new LlistaReferenciaAssignatures();
    }

}
