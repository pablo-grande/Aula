package Interface;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */

class ListaAsignaturas implements AccesLlista {
    
    private ArrayList<Assignatura> list;
    private ArrayList<Optativa> optList;
    private ArrayList<Obligatoria> oblList;
    
    public ListaAsignaturas(){
        list = new ArrayList <Assignatura> ();
        optList = new ArrayList <Optativa> ();
        oblList = new ArrayList <Obligatoria> (); 
    }
    
    public void addAssignatura(Assignatura a){
        list.add(a);
    }

    @Override
    public Assignatura get(int i) {
        return list.get(i);
    }

    @Override
    public void addFP(String nom, int codi, String especialitat) {
        addElement(new FP(nom, codi, especialitat));
    }

    @Override
    public void addBatx(String nom, int codi, String ordre) {
        addElement(new Batxiller(nom, codi, ordre));
    }

    @Override
    public void addOpt(String nom, int codi, String perfil) {
        Optativa optativa = new Optativa (nom, codi, perfil);
        addAssignatura(optativa);
        optList.add(optativa);
    }

    @Override
    public void addObl(String nom, int codi, int credits) {
        Obligatoria obligatoria = new Obligatoria (nom, codi, credits);
        addAssignatura(obligatoria);
        oblList.add(obligatoria);
    }

    @Override
    public void remove(int i) {
        Assignatura ass = get(i);
        for (int j = 0; j < optList.size(); j++) {
            if (ass.getCodi()==get(j).getCodi()){
                optList.remove(j);
            }
        }
        for (int j = 0; j < oblList.size(); j++) {
            if (ass.getCodi()==get(j).getCodi()){
                oblList.remove(j);
            }
        }
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
    
    public ArrayList getOblList(){
        return this.oblList;
    }
    
    public ArrayList getOptList(){
        return this.optList;
    }
    
    @Override
    public void addElement(Element e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
