package Interface;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */

public class ListaCursos implements AccesLlista{
    
    private ArrayList<Curs> list;
    
    public ListaCursos(){
        list = new ArrayList <Curs> ();
    }
    
    public void addCurs(Curs c) {
        list.add(c);
    }

    @Override
    public Curs get(int i) {
        return list.get(i);
    }


    @Override
    public void addFP(String nom, int codi, String especialitat) {
        addCurs(new FP(nom, codi, especialitat));
    }

    @Override
    public void addBatx(String nom, int codi, String ordre) {
        addCurs(new Batxiller(nom, codi, ordre));
    }

    @Override
    public void addOpt(String nom, int codi, String perfil) {
        addElement(new Optativa(nom, codi, perfil));
    }

    @Override
    public void addObl(String nom, int codi, int credits) {
        addElement(new Obligatoria(nom, codi, credits));
    }

    @Override
    public void remove(int i) {
        list.remove(i);
    }

    @Override
    public void empty() {
        list.clear();
    }

    @Override
    public String print() {
        String res="";
            for (int i=0; i<list.size(); i++){
                 res+=list.get(i).escriure();
            }
        return res;
    }

    @Override
    public boolean isIn(Element e) {
        return list.contains(e);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public void addElement(Element e) {
        throw new UnsupportedOperationException("This is a list for courses, not for subjects."); //To change body of generated methods, choose Tools | Templates.
    }

}