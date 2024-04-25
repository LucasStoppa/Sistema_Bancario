/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lucas Victor
 */
public class Loja {
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(Conta conta, Funcionario[] funcionarios) {
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public synchronized void pagarFuncionarios() {
        double totalSalarios = 0;
        
        for (Funcionario funcionario : getFuncionarios()) {
            totalSalarios += funcionario.getSalario();
        }
        if (getConta().getSaldo() >= totalSalarios) {
            for (Funcionario funcionario : getFuncionarios()) {
                getConta().debitar(funcionario.getSalario());
                funcionario.receberSalario();
            }
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
     * @return the funcionarios
     */
    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }
}