package alumnescursoscodi;

import java.util.ArrayList;

public class ListaAlumnes {
    private ArrayList<Alumne> ListaAlumnes;
    
    public ListaAlumnes(){
        ListaAlumnes = new ArrayList();
    }
    
    public void add (Alumne a){
        ListaAlumnes.add(a);
    }
    
    public Alumne get(int i){
        Alumne a= ListaAlumnes.get(i);
        return a;
    }
    
    public int getIndexOf(Alumne a){
        return ListaAlumnes.indexOf(a);
    }
    
    public void remove(int i){
        ListaAlumnes.get(i).removeListaAss();
        ListaAlumnes.remove(i);
    }
    
    public int size(){
        return ListaAlumnes.size();
    }
    
     public String  printLlista() {
         String a="\n";
        for (int i = 0; i < ListaAlumnes.size(); i++) {
            a=a+("  Alumne: " + ListaAlumnes.get(i).getNomAlumne() + " Codi: " + ListaAlumnes.get(i).getDni());
            a=a+"\n";
        }
        return a;
    }

    public String printAlumne(Alumne c) {
        Alumne aux;
        int index = ListaAlumnes.indexOf(c);
        aux = new Alumne(ListaAlumnes.get(index).getNomAlumne(), ListaAlumnes.get(index).getDni());
        return aux.getNomAlumne() + aux.getDni();
    }

    public Alumne cerca(Alumne c) {
        Alumne aux;
        int index = ListaAlumnes.indexOf(c);
        aux = new Alumne(ListaAlumnes.get(index).getNomAlumne(), ListaAlumnes.get(index).getDni());
        return aux;
    }


    
    public int indexOf(Alumne al){
        return ListaAlumnes.indexOf(al);
    }


    
}