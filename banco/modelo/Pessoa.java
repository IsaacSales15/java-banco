package com.sales.banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String domcumento;
    private BigDecimal rendimentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

    public Pessoa() {

    }

    public Pessoa(String nome, String domcumento) {
        this.nome = nome;
        this.domcumento = domcumento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDomcumento() {
        return domcumento;
    }

    public void setDomcumento(String domcumento) {
        this.domcumento = domcumento;
    }

    public BigDecimal getRendimentoAnual() {
        return rendimentoAnual;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", domcumento='" + domcumento + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(domcumento, pessoa.domcumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domcumento);
    }
}

