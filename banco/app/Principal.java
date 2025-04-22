package com.sales.banco.app;

import com.sales.banco.modelo.*;
import com.sales.banco.modelo.atm.CaixaEletronico;
import com.sales.banco.modelo.excecao.SaldoInsuficienteException;
import com.sales.banco.modelo.pagamento.Boleto;
import com.sales.banco.modelo.pagamento.DocumentoPagavel;
import com.sales.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Paulo Santana");
        titular1.setDomcumento("1234567");
        titular1.setRendimentoAnual(new BigDecimal("15000d"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria da Gloria");
        titular2.setDomcumento("7654321");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 402, 123);

        try {

            minhaConta.depositar(new BigDecimal("50000"));
            minhaConta.sacar(new BigDecimal("1000"));
            minhaConta.creditarRendimetos(new BigDecimal("0.8"));
            minhaConta.debitarTarifaMensal();

            ContaEspecial suaConta = new ContaEspecial(titular2, 204, 456, new BigDecimal(1000));
            suaConta.depositar(new BigDecimal("300000"));
            suaConta.sacar(new BigDecimal("30500"));
            suaConta.debitarTarifaMensal();

            DocumentoPagavel boletoEscola = new Boleto(titular2,new BigDecimal(200));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal(100), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            boletoEscola.imprimirRecibo();
            System.out.println();
            salarioFuncionario.imprimirRecibo();
            System.out.println();

            caixaEletronico.imprimirSaldo(minhaConta);
            System.out.println();
            caixaEletronico.imprimirSaldo(suaConta);

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar ação na conta" + e.getMessage());
        }
    }
}
