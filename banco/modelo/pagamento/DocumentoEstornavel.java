package com.sales.banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoEstornavel {
    BigDecimal getValorTotal();
    boolean estaPago();
    void estornarPagamento();
}
