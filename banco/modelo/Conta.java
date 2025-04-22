package com.sales.banco.modelo;

import com.sales.banco.modelo.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    Conta(){

    }
    public Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    // Métodos
    public void depositar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new SaldoInsuficienteException("O valor deve ser maior que 0");
        }
        saldo = saldo.add (valor);
    }

    public void sacar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que 0");
        }
        if (getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO)< 0){
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

    // Sobrecarga
    public void sacar( BigDecimal valor,  BigDecimal taxaDeSaque){
        sacar (valor.add(taxaDeSaque));
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() { return titular;}
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoDisponivel() {
        return getSaldo();

    }
}
