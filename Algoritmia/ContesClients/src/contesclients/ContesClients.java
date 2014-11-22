/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contesclients;

/**
 *
 * @author pablo
 */
public class ContesClients extends javax.swing.JFrame {

    public static void main(String[] args) {
        try{
            
            Conta conta = new Conta();
            Finestra finestra = new Finestra();
            finestra.llista(conta);       
        
      }catch(Exception e){
            System.out.println(e.getMessage());
      }
    }
}