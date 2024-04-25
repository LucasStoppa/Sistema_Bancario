/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lucas Victor
 */
public class Funcionario extends Thread {
    private double salario;
    private Conta salarioConta;
    private Conta investimentosConta;

    public Funcionario(double salario, Conta salarioConta, Conta investimentosConta) {
        this.salario = salario;
        this.salarioConta = salarioConta;
        this.investimentosConta = investimentosConta;
    }

    public double getSalario() {
        return salario;
    }

    public void receberSalario() {
        salarioConta.creditar(salario);
        double investimento = salario * 0.2;
        investimentosConta.creditar(investimento);
    }

    @Override
    public void run() {
        // Código para as atividades dos funcionários, se necessário
    }
}