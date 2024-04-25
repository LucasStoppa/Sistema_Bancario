/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lucas Victor
 */
public class Banco {

    private Loja loja1;
    private Loja loja2;

    public Banco(Loja loja1, Loja loja2) {
        this.loja1 = loja1;
        this.loja2 = loja2;
    }


 
  public synchronized void realizarCompra(Conta contaCliente) {
       double valorCompra = Math.random() < 0.5 ? 100 : 200; // Seleciona aleatoriamente entre R$ 100,00 e R$ 200,00
        if (contaCliente.getSaldo() >= valorCompra) {
            contaCliente.debitar(valorCompra);
            if (Math.random() < 0.5) {
                double saldoAnteriorLoja1 = loja1.getConta().getSaldo();
                loja1.getConta().creditar(valorCompra);
                double saldoAtualLoja1 = loja1.getConta().getSaldo();
                System.out.println("--------------------------------------------------");
                System.out.println("Transferência para loja [1]: R$" + valorCompra);
                System.out.println("Saldo da conta da loja [1]: R$" + String.format("%.2f",saldoAnteriorLoja1) + " -> R$" + String.format("%.2f",saldoAtualLoja1));
               
            } else {
                double saldoAnteriorLoja2 = loja2.getConta().getSaldo();
                loja2.getConta().creditar(valorCompra);
                double saldoAtualLoja2 = loja2.getConta().getSaldo();
                System.out.println("--------------------------------------------------");
                System.out.println("Transferência para loja 2: R$" + valorCompra);
                System.out.println("Saldo da conta da loja 2: R$" + String.format("%.2f",saldoAnteriorLoja2) + " -> R$" + String.format("%.2f",saldoAtualLoja2));
                
            }
            System.out.println("Compra realizada: R$" + String.format("%.2f",valorCompra));
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("Cliente sem saldo para realizar a compra.");
        }
  }
}


