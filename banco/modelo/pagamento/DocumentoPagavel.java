package com.sales.banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {

    BigDecimal getvalorTotal();
    boolean estaPago();
    void quitarPagamento();

    default void imprimirRecibo() {
        System.out.println("Recibo: ");
        System.out.println("Valor total: " + getvalorTotal());
        System.out.println("Pago: " + estaPago());

    }
}
