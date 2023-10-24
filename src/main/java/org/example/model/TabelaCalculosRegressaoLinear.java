package org.example.model;

public class TabelaCalculosRegressaoLinear {
    private Double somatorioA;
    private Double somatorioB;
    private Double somatorioProdutoAB;
    private Double somatorioProdutoAA;
    private Double somatorioProdutoBB;
    private Double correlacao;

    public Double getSomatorioA() {
        return somatorioA;
    }

    public void setSomatorioA(Double somatorioA) {
        this.somatorioA = somatorioA;
    }

    public Double getSomatorioB() {
        return somatorioB;
    }

    public void setSomatorioB(Double somatorioB) {
        this.somatorioB = somatorioB;
    }

    public Double getSomatorioProdutoAB() {
        return somatorioProdutoAB;
    }

    public void setSomatorioProdutoAB(Double somatorioProdutoAB) {
        this.somatorioProdutoAB = somatorioProdutoAB;
    }

    public Double getSomatorioProdutoAA() {
        return somatorioProdutoAA;
    }

    public void setSomatorioProdutoAA(Double somatorioProdutoAA) {
        this.somatorioProdutoAA = somatorioProdutoAA;
    }

    public Double getSomatorioProdutoBB() {
        return somatorioProdutoBB;
    }

    public void setSomatorioProdutoBB(Double somatorioProdutoBB) {
        this.somatorioProdutoBB = somatorioProdutoBB;
    }

    public Double getCorrelacao() {
        return correlacao;
    }

    public void setCorrelacao(Double correlacao) {
        this.correlacao = correlacao;
    }
}
