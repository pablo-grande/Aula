package alumnescursoscodi;

import java.util.ArrayList;

public class ListaCursos {

    private ArrayList<Curs> ListaCursos;

    public ListaCursos() {
        ListaCursos = new ArrayList();
    }

    public void add(Curs c) {
        ListaCursos.add(c);
    }

    public Curs get(int i) {
        Curs c = ListaCursos.get(i);
        return c;
    }

    public void remove(int i) {
        ListaCursos.get(i).removeListaAss();
        ListaCursos.remove(i);
    }

    public int size() {
        return ListaCursos.size();
    }

    public boolean isEmpty() {
        return ListaCursos.isEmpty();
    }

    public String printLlista() {
        String a="\n";
        for (int i = 0; i < ListaCursos.size(); i++) {
            a=a+("Curs: " + ListaCursos.get(i).getNomCurs() + " Codi: " + ListaCursos.get(i).getCodiCurs());
            a=a+"\n";
        }
        return a;
    }

    public String printCurs(Curs c) {
        Curs aux;
        int index = ListaCursos.indexOf(c);
        aux = new Curs(ListaCursos.get(index).getNomCurs(), ListaCursos.get(index).getCodiCurs());
        return aux.getNomCurs() + aux.getCodiCurs();
    }
    
    public String printCursCod (int c){
        Curs aux;
        aux = new Curs(ListaCursos.get(c).getNomCurs(), ListaCursos.get(c).getCodiCurs());
        String t = "Nombre del curso: "+ListaCursos.get(c).getNomCurs() + ".   Código: " + ListaCursos.get(c).getCodiCurs()+".\n";
        return t ;
    }

    public Curs cerca(Curs c) {
        Curs aux;
        int index = ListaCursos.indexOf(c);
        aux = new Curs(ListaCursos.get(index).getNomCurs(), ListaCursos.get(index).getCodiCurs());
        return aux;
    }
    
    public int indexOf(Curs c){
        return ListaCursos.indexOf(c);
    }
    
}
