/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lucas Victor
 */
public class Cliente extends Thread {
    private Conta conta;
    private Banco banco;

    public Cliente(Conta conta, Banco banco) {
        this.conta = conta;
        this.banco = banco;
    }

    @Override
    public void run() {
        while (getConta().getSaldo() > 0) {
            getBanco().realizarCompra(getConta());
        }
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    /**
     * @return the banco
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}