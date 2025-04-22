package com.sales.banco.modelo.atm;

import com.sales.banco.modelo.Conta;
import com.sales.banco.modelo.pagamento.DocumentoEstornavel;
import com.sales.banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta) {
        System.out.println("Conta:" + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponivel:" + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documento, Conta conta){
        if (documento.estaPago()){
            throw new IllegalStateException("Documento já foi pago");
        }
        conta.sacar(documento.getvalorTotal());
        documento.quitarPagamento();
    }

    public void estornarPagamento(DocumentoEstornavel documento, Conta conta) {
        if (!documento.estaPago()) {
            throw new IllegalStateException("Documento não está pago");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();
    }
}
