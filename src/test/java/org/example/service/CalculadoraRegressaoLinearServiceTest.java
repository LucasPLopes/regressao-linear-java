package org.example.service;

import org.example.model.FuncaoRegressaoLinear;
import org.example.model.InputRegressaoLinear;
import org.example.model.TabelaCalculosRegressaoLinear;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CalculadoraRegressaoLinearServiceTest {
    private InputRegressaoLinear inputRegressaoLinear;
    private static final double LIMITE_PRECISAO = 0.0000001;

    @Before
    public void init() {
        inputRegressaoLinear = new InputRegressaoLinear();
        inputRegressaoLinear.setInputA( Arrays.asList(4.70, 6.70, 8.10, 4.15, 5.10, 5.00, 5.00, 4.70, 6.20));
        inputRegressaoLinear.setDescricaoA("per alcool");
        inputRegressaoLinear.setInputB( Arrays.asList(163.0, 215.0, 222.0, 104.0, 162.0, 158.0, 155.0, 158.0, 195.0));
        inputRegressaoLinear.setDescricaoB("cal em 350ml");
    }

    @Test
    public void calcularSomatorioA() {
        Double expect = 49.65;
        var tabela = new TabelaCalculosRegressaoLinear();
        Double result = CalculadoraRegressaoLinearService.calcularSomatorioA(inputRegressaoLinear, tabela);
        Assert.assertNotNull(result);
        Assert.assertNotNull(tabela.getSomatorioA());
        Assert.assertEquals(expect,result,LIMITE_PRECISAO);
    }

    @Test
    public void calcularSomatorioB() {
        Double expect = 1532.0;
        var tabela = new TabelaCalculosRegressaoLinear();
        Double result = CalculadoraRegressaoLinearService.calcularSomatorioB(inputRegressaoLinear, tabela);
        Assert.assertNotNull(result);
        Assert.assertNotNull(tabela.getSomatorioB());
        Assert.assertEquals(expect,result,LIMITE_PRECISAO);
    }

    @Test
    public void calcularSomatorioProdutoAA() {
        Double expect = 286.3525;
        var tabela = new TabelaCalculosRegressaoLinear();
        Double result = CalculadoraRegressaoLinearService.calcularSomatorioAA(inputRegressaoLinear, tabela);
        Assert.assertNotNull(result);
        Assert.assertNotNull(tabela.getSomatorioProdutoAA());
        Assert.assertEquals(expect,result,LIMITE_PRECISAO);
    }

    @Test
    public void calcularSomatorioProdutoBB() {
        Double expect = 271116.0;
        var tabela = new TabelaCalculosRegressaoLinear();
        Double result = CalculadoraRegressaoLinearService.calcularSomatorioBB(inputRegressaoLinear, tabela);
        Assert.assertNotNull(result);
        Assert.assertNotNull(tabela.getSomatorioProdutoBB());
        Assert.assertEquals(expect,result,LIMITE_PRECISAO);
    }

    @Test
    public void calcularSomatorioProdutoAB() {
        Double expect = 8779.2;
        var tabela = new TabelaCalculosRegressaoLinear();
        Double result = CalculadoraRegressaoLinearService.calcularSomatorioAB(inputRegressaoLinear, tabela);
        Assert.assertNotNull(result);
        Assert.assertNotNull(tabela.getSomatorioProdutoAB());
        Assert.assertEquals(expect,result,LIMITE_PRECISAO);
    }

    @Test
    public void calcularCorrelation() {
        Double expect = 91.34413647;
        var tabela = new TabelaCalculosRegressaoLinear();
        Double result = CalculadoraRegressaoLinearService.calcularCorrelation(inputRegressaoLinear, tabela);
        Assert.assertNotNull(result);
        Assert.assertNotNull(tabela.getCorrelacao());
        Assert.assertEquals(expect,result,LIMITE_PRECISAO);
    }

    @Test
    public void calcularFuncaoRegressao() {
        Double expectAx = 26.31860776;
        Double expectB = 25.03123606;
        FuncaoRegressaoLinear fn = CalculadoraRegressaoLinearService.calcularFuncaoRegressao(inputRegressaoLinear);
        Assert.assertNotNull(fn);
        Assert.assertEquals(expectAx,fn.getaX(),LIMITE_PRECISAO);
        Assert.assertEquals(expectB,fn.getB(),LIMITE_PRECISAO);
    }
}
