/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnescursoscodi;

/**
 *
 * @author pablo
 */
public class Assignatura {

    private String nomAssignatura;
    private int codiAssignatura;
    private LlistaReferenciaAlumnes llistaAl;

    public Assignatura(String nomAssignatura, int codiAssignatura) {
        this.nomAssignatura = nomAssignatura;
        this.codiAssignatura = codiAssignatura;
        this.llistaAl = new LlistaReferenciaAlumnes();
    }

    public String getNomAssignatura() {
        return nomAssignatura;
    }

    public int getCodiAssignatura() {
        return codiAssignatura;
    }
    
    public LlistaReferenciaAlumnes getLlistaAl(){
        return llistaAl;
    }
    
    public void removeListaAl(){
        for (int i = 0; i < llistaAl.size(); i++) {
            if(llistaAl.get(i).getAssignatura().codiAssignatura==this.codiAssignatura){
                llistaAl.remove(i);
            }
        }
        this.llistaAl = new LlistaReferenciaAlumnes();
    }
    
    @Override
    public String toString(){
        String lista="Nombre de la agnatura: "+ nomAssignatura + ". Codigo: "+codiAssignatura + ".\n";
        return lista;
    }
    
}
