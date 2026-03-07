package io.github.dicousdev;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {



    public static void main(String[] args) {
        BigDecimal valorInicial = new BigDecimal("1000");
        BigDecimal taxaSelicMeta = new BigDecimal("15");

        BigDecimal rendimentoBruto = CaixinhaNubank.calcularRendimentoBrutoAnual(valorInicial, taxaSelicMeta)
                .divide(BigDecimal.valueOf(12), RoundingMode.CEILING);

        final int diasDecorridos = 31;

        BigDecimal rendimentoLiquido = rendimentoBruto.subtract(ImpostoIOF.calcularValorIOF(rendimentoBruto, diasDecorridos));
        rendimentoLiquido = rendimentoLiquido.subtract(ImpostoIR.calcularIR(rendimentoBruto, diasDecorridos));


        System.out.println("Valor Investido: R$ " + valorInicial);
        System.out.println("Taxa Selic: " + taxaSelicMeta + "%");
        System.out.println("Taxa CDI: 100%");
        System.out.println("Total de dias decorridos: " + diasDecorridos);
        System.out.println("Rendimento bruto mensal aproximado (100% do CDI): R$ " + rendimentoBruto);
        System.out.println("Rendimento líquido aproximado dos dias decorridos (100% do CDI): R$ " + rendimentoLiquido);
    }


}