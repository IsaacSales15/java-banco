package com.sales.banco.modelo.pagamento;

import com.sales.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Boleto implements DocumentoPagavel, DocumentoEstornavel {

    private Pessoa beneficiario;
    private BigDecimal valor;
    private boolean pago;

    public Boleto(Pessoa beneficiario, BigDecimal valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
        this.pago = pago;
    }

    @Override
    public BigDecimal getvalorTotal() {
        return valor;
    }

    @Override
    public BigDecimal getValorTotal() {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void estornarPagamento() {
        pago = false;

    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
}
