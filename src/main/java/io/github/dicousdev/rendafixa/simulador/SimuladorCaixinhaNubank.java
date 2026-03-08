package io.github.dicousdev.rendafixa.simulador;

import io.github.dicousdev.financia.InflacaoCalculadora;
import io.github.dicousdev.rendafixa.imposto.ImpostoIOF;
import io.github.dicousdev.rendafixa.imposto.ImpostoIR;
import io.github.dicousdev.rendafixa.investimento.CaixinhaNubank;

import java.math.BigDecimal;

public class SimuladorCaixinhaNubank {


    public static void main(String[] args) {
        // TODO: Este método simula um investimento considerando impostos (IOF e IR) e inflação.
        simularDescontandoImpostosInflacaoIpca();
    }

    private static void simularDescontandoImpostosInflacaoIpca() {
        BigDecimal valorInicial = new BigDecimal("10000");
        BigDecimal taxaSelicMeta = new BigDecimal("15");
        BigDecimal inflacaoIpcaPorcentagem = new BigDecimal("4.44");
        int anoInvestindo = 1;
        int diasUteis = 252 * anoInvestindo;
        int diasTotal = 365 * anoInvestindo;

        BigDecimal rendimentoBruto = CaixinhaNubank.calcularRendimentoBruto(valorInicial, taxaSelicMeta, diasUteis);
        BigDecimal rendimentoLiquido = rendimentoBruto.subtract(ImpostoIOF.calcularIOF(rendimentoBruto, diasTotal))
                .subtract(ImpostoIR.calcularIR(rendimentoBruto, diasTotal));

        BigDecimal montanteReal = valorInicial.add(rendimentoLiquido);
        montanteReal = InflacaoCalculadora.inflacao(montanteReal, inflacaoIpcaPorcentagem);
        BigDecimal rendimentoAbsoluto = montanteReal.subtract(valorInicial);

        System.out.println("Calculando considerando juros compostos");
        System.out.println("Valor Investido: R$ " + valorInicial);
        System.out.println("Taxa Selic: " + taxaSelicMeta + "%");
        System.out.println("Taxa CDI: 100%");
        System.out.println("Taxa de inflação IPCA: %s".formatted(inflacaoIpcaPorcentagem) + "%");
        System.out.println("Total de dias úteis decorridos: " + diasUteis);
        System.out.println("Total de dias decorridos: " + diasTotal);
        System.out.println("Rendimento bruto anual aproximado (100% do CDI): R$ " + rendimentoBruto);
        System.out.println("Rendimento líquido anual aproximado dos dias decorridos (100% do CDI): R$ " + rendimentoLiquido);
        System.out.println("Rendimento absoluto anual: R$ " + rendimentoAbsoluto);
    }
}
