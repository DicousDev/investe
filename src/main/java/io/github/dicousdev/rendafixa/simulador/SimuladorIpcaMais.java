package io.github.dicousdev.rendafixa.simulador;

import io.github.dicousdev.rendafixa.imposto.ImpostoIOF;
import io.github.dicousdev.rendafixa.imposto.ImpostoIR;
import io.github.dicousdev.rendafixa.investimento.IpcaMais;

import java.math.BigDecimal;

public class SimuladorIpcaMais {

    public static void main(String[] args) {
        // TODO: Este método simula um investimento considerando impostos (IOF e IR).

        BigDecimal valorInicial = new BigDecimal(20000);
        BigDecimal porcentagemIpcaAnual = new BigDecimal("4.44");
        BigDecimal taxaFixaAnual = new BigDecimal("7.68");
        int diasDecorridos = 365;

        BigDecimal rendimentoBruto = IpcaMais.calcularRendimentoBruto(valorInicial, porcentagemIpcaAnual, taxaFixaAnual, diasDecorridos);
        BigDecimal valorIOF = ImpostoIOF.calcularIOF(rendimentoBruto, diasDecorridos);
        BigDecimal valorIR = ImpostoIR.calcularIR(rendimentoBruto, diasDecorridos);

        // TODO: Aplicando IOF e IR
        BigDecimal rendimentoLiquido = rendimentoBruto.subtract(valorIOF).subtract(valorIR);
        System.out.println("Investimento em IPCA + " + taxaFixaAnual + "%");
        System.out.println("Valor Investido: R$ " + valorInicial);
        System.out.println("Taxa de inflação IPCA dos últimos 12 meses: %s".formatted(porcentagemIpcaAnual) + "%");
        System.out.println("Taxa fixa anual: %s".formatted(taxaFixaAnual) + "%");
        System.out.println("Prazo em dias: " + diasDecorridos);
        System.out.println("Imposto IR: R$ " + valorIR);
        System.out.println("Rendimento bruto anual: R$ " + rendimentoBruto);
        System.out.println("Rendimento líquido anual: R$ " + rendimentoLiquido);
    }
}
