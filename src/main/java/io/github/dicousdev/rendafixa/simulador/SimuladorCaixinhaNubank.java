package io.github.dicousdev.rendafixa.simulador;

import io.github.dicousdev.rendafixa.imposto.ImpostoIOF;
import io.github.dicousdev.rendafixa.imposto.ImpostoIR;
import io.github.dicousdev.rendafixa.investimento.CaixinhaNubank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimuladorCaixinhaNubank {

    public static void main(String[] args) {
        BigDecimal valorInicial = new BigDecimal("1000");
        BigDecimal taxaSelicMeta = new BigDecimal("15");

        BigDecimal rendimentoBrutoMensal = CaixinhaNubank.calcularRendimentoBrutoAnual(valorInicial, taxaSelicMeta)
                .divide(BigDecimal.valueOf(12), RoundingMode.CEILING);

        final int diasDecorridos = 31;

        BigDecimal rendimentoLiquidoMensal = rendimentoBrutoMensal.subtract(ImpostoIOF.calcularValorIOF(rendimentoBrutoMensal, diasDecorridos));
        rendimentoLiquidoMensal = rendimentoLiquidoMensal.subtract(ImpostoIR.calcularIR(rendimentoBrutoMensal, diasDecorridos));


        System.out.println("Valor Investido: R$ " + valorInicial);
        System.out.println("Taxa Selic: " + taxaSelicMeta + "%");
        System.out.println("Taxa CDI: 100%");
        System.out.println("Total de dias decorridos: " + diasDecorridos);
        System.out.println("Rendimento bruto mensal aproximado (100% do CDI): R$ " + rendimentoBrutoMensal);
        System.out.println("Rendimento líquido aproximado dos dias decorridos (100% do CDI): R$ " + rendimentoLiquidoMensal);
    }
}
