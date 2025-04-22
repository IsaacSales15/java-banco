package com.sales.banco.modelo.pagamento;

import com.sales.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Holerite implements DocumentoPagavel {

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quantidadeHora;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidadeHora) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHora = quantidadeHora;
    }

    @Override
    public BigDecimal getvalorTotal() {
        return valorHora.multiply( new BigDecimal(quantidadeHora));
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
}
