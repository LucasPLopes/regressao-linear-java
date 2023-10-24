package org.example.service;

import org.example.model.FuncaoRegressaoLinear;
import org.example.model.InputRegressaoLinear;
import org.example.model.TabelaCalculosRegressaoLinear;

import static java.util.Objects.isNull;

public class CalculadoraRegressaoLinearService {

    public static Double calcularSomatorioA(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        Double somatorioA = in.getInputA().stream().reduce(0.0, Double::sum);
        tb.setSomatorioA(somatorioA);
        return tb.getSomatorioA();
    }

    public static Double calcularSomatorioB(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        Double somatorioB = in.getInputB().stream().reduce(0.0, Double::sum);
        tb.setSomatorioB(somatorioB);
        return tb.getSomatorioB();
    }

    public static Double calcularSomatorioAA(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        Double somatorioAA = in.getInputA().stream().mapToDouble(m -> Math.pow(m, 2.0)).sum();
        tb.setSomatorioProdutoAA(somatorioAA);
        return tb.getSomatorioProdutoAA();
    }

    public static Double calcularSomatorioBB(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        Double somatorioBB = in.getInputB().stream().mapToDouble(m -> Math.pow(m, 2.0)).sum();
        tb.setSomatorioProdutoBB(somatorioBB);
        return tb.getSomatorioProdutoBB();
    }

    public static Double calcularSomatorioAB(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        if (in.getInputA().size() != in.getInputB().size()) {
            throw new RuntimeException("Listas com tamanhos divergentes");
        }
        Double somatorioAB = 0.0;
        for (int i = 0; i < in.getInputA().size(); i++) {
            somatorioAB += in.getInputA().get(i) * in.getInputB().get(i);
        }
        tb.setSomatorioProdutoAB(somatorioAB);
        return tb.getSomatorioProdutoAB();
    }

    public static Double calcularCorrelation(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        calcularSomatorioA(in, tb);
        calcularSomatorioB(in, tb);
        calcularSomatorioAA(in, tb);
        calcularSomatorioBB(in, tb);
        calcularSomatorioAB(in, tb);
        formularCorrelation(in, tb);
        return tb.getCorrelacao();
    }

    private static void formularCorrelation(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb) {
        int n = in.getInputA().size();
        Double p1 = n * tb.getSomatorioProdutoAB();
        Double p2 = n * tb.getSomatorioProdutoAA() - tb.getSomatorioA() * tb.getSomatorioA();
        Double p3 = -tb.getSomatorioA() * tb.getSomatorioB();
        Double p4 = n * tb.getSomatorioProdutoBB() - tb.getSomatorioB() * tb.getSomatorioB();
        Double p5 = p1 + p3;
        Double p6 = Math.pow(p2 * p4, 0.5);
        Double correlation = p5 / p6 * 100;
        tb.setCorrelacao(correlation);
    }

    public static FuncaoRegressaoLinear calcularFuncaoRegressao(InputRegressaoLinear in) {
        var tb = new TabelaCalculosRegressaoLinear();
        var fn = new FuncaoRegressaoLinear();
        calcularCorrelation(in, tb);
        calcularAxRetaCorrelacao(in, tb, fn);
        calcularBRetaCorrelacao(in, tb, fn);
        return fn;

    }

    private static Double calcularAxRetaCorrelacao(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb, FuncaoRegressaoLinear fn) {
        calcularCorrelation(in, tb);
        int n = in.getInputA().size();
        double parteSuperior = (n * tb.getSomatorioProdutoAB() - (tb.getSomatorioA() * tb.getSomatorioB()));
        double parteInferior = (n * tb.getSomatorioProdutoAA() - Math.pow(tb.getSomatorioA(), 2));
        double ax = parteSuperior / parteInferior;
        fn.setaX(ax);
        return fn.getaX();
    }

    private static Double calcularBRetaCorrelacao(InputRegressaoLinear in, TabelaCalculosRegressaoLinear tb, FuncaoRegressaoLinear fn) {
        if(isNull(fn.getaX())){
            throw  new RuntimeException("Ax em FuncaoRegressaoLinear é nula");
        }
        int n = in.getInputA().size();
        double p1 = tb.getSomatorioB() / n;
        double p2 = -(fn.getaX() * tb.getSomatorioA()) / n;
        double b = p1 + p2;
        fn.setB(b);
        return fn.getB();
    }
}
