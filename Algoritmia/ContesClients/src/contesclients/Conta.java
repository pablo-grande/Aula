/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contesclients;


/**
 *
 * @author pablo
 */
public class Conta {
    
    private Persona client;
    private double saldo;
    private int numero_conta;
  
    public Conta(){
        client = new Persona();
        saldo = 0.0;
        numero_conta = 0;
    }

    public Persona getClient() {
        return client;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double input) {
        this.saldo = this.saldo + input;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }
   
}
