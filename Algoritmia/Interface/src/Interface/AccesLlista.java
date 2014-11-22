/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

/**
 *
 * @author pablo
 */

public interface AccesLlista {
    
    /**
     * Retorna l'informació d'un element del conjunt
     * @param i 
     * @return Element
     */
    public Element get(int i);
    
    /**
     * Fica un element a la llista
     * @param e 
     */
    public void addElement(Element e);
    
    /**
     * Fica un curs d'FP a la llista
     * @param nom
     * @param codi
     * @param especialitat 
     */
    public void addFP(String nom, int codi, String especialitat);

    /**
     * Fica un curs de batxiller a la llista
     * @param nom
     * @param codi
     * @param ordre 
     */
    public void addBatx(String nom, int codi, String ordre);
    
    /**
     * Fica una assignatura optativa a la llista
     * @param nom
     * @param codi
     * @param perfil 
     */
    public void addOpt(String nom, int codi, String perfil);
    
    /**
     * Fica una assignatura obligatoria a la llista
     * @param nom
     * @param codi
     * @param credits 
     */
    public void addObl(String nom, int codi, int credits);
    
    /**
     * Elimina l'element especificat per paràmetre de la llista
     * @param i 
     */
    public void remove(int i);
    
    /**
     * Donat un element, el treu de la llista
     */
    public void empty();
    
    /**
     * Treu info de l'element de la llista
     * @return 
     */
    public String print();
    
    /**
     * Per sebre si hi és l'element a la llista
     * @param e
     * @return 
     */
    public boolean isIn(Element e);
    
    /**
     * Tamany de la llista = nº elements
     * @return 
     */
    public int size();
    
    /**
     * Ens diu si la llista és buida
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * Retorna els elements de la llista per pantalla
     * @return 
     */
    @Override
    public String toString();
    
}
