package io.github.dicousdev.rendafixa.simulador;

import io.github.dicousdev.rendafixa.imposto.ImpostoIOF;
import io.github.dicousdev.rendafixa.imposto.ImpostoIR;
import io.github.dicousdev.rendafixa.investimento.CaixinhaNubank;

import java.math.BigDecimal;

public class SimuladorCaixinhaNubank {

    public static void main(String[] args) {
        BigDecimal valorInicial = new BigDecimal("1000");
        BigDecimal taxaSelicMeta = new BigDecimal("15");

        int anoInvestindo = 5;
        int diasUteis = 252 * anoInvestindo;
        int diasTotal = 365 * anoInvestindo;
        BigDecimal rendimentoBrutoMensal = CaixinhaNubank.calcularRendimentoBruto(valorInicial, taxaSelicMeta, diasUteis);

        BigDecimal rendimentoLiquidoMensal = rendimentoBrutoMensal.subtract(ImpostoIOF.calcularValorIOF(rendimentoBrutoMensal, diasTotal));
        rendimentoLiquidoMensal = rendimentoLiquidoMensal.subtract(ImpostoIR.calcularIR(rendimentoBrutoMensal, diasTotal));


        System.out.println("⚠️ Calculando considerando juros compostos");
        System.out.println("Valor Investido: R$ " + valorInicial);
        System.out.println("Taxa Selic: " + taxaSelicMeta + "%");
        System.out.println("Taxa CDI: 100%");
        System.out.println("Total de dias decorridos: " + diasTotal);
        System.out.println("Rendimento bruto mensal aproximado (100% do CDI): R$ " + rendimentoBrutoMensal);
        System.out.println("Rendimento líquido aproximado dos dias decorridos (100% do CDI): R$ " + rendimentoLiquidoMensal);
    }
}
