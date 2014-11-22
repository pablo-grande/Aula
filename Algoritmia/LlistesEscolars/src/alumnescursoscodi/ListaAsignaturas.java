package alumnescursoscodi;

import java.util.ArrayList;

public class ListaAsignaturas {
    private ArrayList<Assignatura> ListaAsignaturas;
    
    public ListaAsignaturas(){
        ListaAsignaturas = new ArrayList();
    }
    
    public void add (Assignatura ass){
        ListaAsignaturas.add(ass);
    }
    
    public Assignatura get(int i){
        Assignatura ass = ListaAsignaturas.get(i);
        return ass;
    }
    
    public void remove(int i){
        ListaAsignaturas.get(i).removeListaAl();
        ListaAsignaturas.remove(i);
    }
    
    public int size(){
        return ListaAsignaturas.size();
    }
    
     public String printLlista() {
         String lista="";
        for (int i = 0; i < ListaAsignaturas.size(); i++) {
            lista=lista+("Nombre: " + ListaAsignaturas.get(i).getNomAssignatura() + ". Código: " + ListaAsignaturas.get(i).getCodiAssignatura() + ".\n");
        }
        return lista;
    }

    public String printAssignatura(int ass) {
        Assignatura aux;
        aux = new Assignatura(ListaAsignaturas.get(ass).getNomAssignatura(), ListaAsignaturas.get(ass).getCodiAssignatura());
        String a="      Nombre de la asignatura: "+aux.getNomAssignatura() + ". Código de la asignatura: "+aux.getCodiAssignatura()+".\n";
        return a;
    }

    public Assignatura cerca(Assignatura ass) {
        Assignatura aux;
        int index = ListaAsignaturas.indexOf(ass);
        aux = new Assignatura(ListaAsignaturas.get(index).getNomAssignatura(), ListaAsignaturas.get(index).getCodiAssignatura());
        return aux;
    }
    
}