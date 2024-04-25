/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lucas Victor
 */
public class TesteSistemaBancario {

    public static void main(String[] args) {
        // Criando o banco

        // Criando contas para as lojas
        Conta contaLoja1 = new Conta(0);
        Conta contaLoja2 = new Conta(0);

        // Criando contas para os funcionários
        Conta contaSalarioFuncionarioLoja1 = new Conta(0);
        Conta contaInvestimentosFuncionarioLoja1 = new Conta(0);
        Conta contaSalarioFuncionarioLoja2 = new Conta(0);
        Conta contaInvestimentosFuncionarioLoja2 = new Conta(0);

        // Criando funcionários para as lojas
        Funcionario[] funcionariosLoja1 = {
            new Funcionario(700, contaSalarioFuncionarioLoja1, contaInvestimentosFuncionarioLoja1),
            new Funcionario(700, contaSalarioFuncionarioLoja1, contaInvestimentosFuncionarioLoja1)
        };

        Funcionario[] funcionariosLoja2 = {
            new Funcionario(700, contaSalarioFuncionarioLoja2, contaInvestimentosFuncionarioLoja2),
            new Funcionario(700, contaSalarioFuncionarioLoja2, contaInvestimentosFuncionarioLoja2)
        };

        // Criando lojas
        Loja loja1 = new Loja(contaLoja1, funcionariosLoja1);
        Loja loja2 = new Loja(contaLoja2, funcionariosLoja2);
        Banco banco = new Banco(loja1, loja2);

        // Criando clientes e iniciando suas threads
        Cliente[] clientes = new Cliente[3];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(new Conta(1000), banco);

            clientes[i].start();
        }

        // Iniciando threads dos funcionários
        for (Funcionario funcionario : funcionariosLoja1) {
            funcionario.start();
        }

        for (Funcionario funcionario : funcionariosLoja2) {
            funcionario.start();
        }

        
        try {
            Thread.sleep(2000); // Espera 2 segundos para a simulação
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("----------------------------------Saldo obtido com as vendas----------------------------------");
        System.out.println("Saldo da loja Loja1: " + String.format("%.2f", contaLoja1.getSaldo()));
        System.out.println("Saldo da loja Loja2: " + String.format("%.2f", contaLoja2.getSaldo()));
        System.out.println("-----------------------------------------------------------------------------------------------");
        // Após o tempo de execução, a loja deve pagar os funcionários
        System.out.println("Efetuando pagamento......");
        loja1.pagarFuncionarios();
        System.out.println("Salario funcionario Loja1: R$"+String.format("%.2f", contaSalarioFuncionarioLoja1.getSaldo()));
        loja2.pagarFuncionarios();
        System.out.println("Salario funcionario Loja2: R$"+String.format("%.2f", contaSalarioFuncionarioLoja2.getSaldo()));
        System.out.println("-------------------------");

        // Exibindo saldos finais
        System.out.println("Saldo da conta da loja 1 Atual: R$" + contaLoja1.getSaldo());
        System.out.println("Saldo da conta da loja 2 Atual: R$" + contaLoja2.getSaldo());
        System.out.println("Saldo da conta de investimentos do funcionário da loja 1: R$" + contaInvestimentosFuncionarioLoja1.getSaldo());
        System.out.println("Saldo da conta de investimentos do funcionário da loja 2: R$" + contaInvestimentosFuncionarioLoja2.getSaldo());
    }
}
