/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package llistesescolarsref;

/**
 *
 * @author pablo
 */
public class Assignatura {

    private String nomAssignatura;
    private int codiAssignatura;
    LlistaReferenciaAlumnes llistaAl;

    public Assignatura(String nomAssignatura, int codiAssignatura) {
        this.nomAssignatura = nomAssignatura;
        this.codiAssignatura = codiAssignatura;
        this.llistaAl= new LlistaReferenciaAlumnes();
    }

    public String getNomAssignatura() {
        return nomAssignatura;
    }

    public int getCodiAssignatura() {
        return codiAssignatura;
    }
  
    public LlistaReferenciaAlumnes getList(){
        return this.llistaAl;
    }
    
    public void removeListaAss(){
        for (int i = 0; i < this.llistaAl.size(); i++) {
            if (this.llistaAl.get(i).getAssignatura().getCodiAssignatura() == this.codiAssignatura){
                llistaAl.remove(i);
            }
        }
        this.llistaAl = new LlistaReferenciaAlumnes();
    }
    
}
