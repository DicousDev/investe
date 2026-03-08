package io.github.dicousdev.rendafixa.investimento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CaixinhaNubank {

    public static BigDecimal calcularRendimentoBruto(BigDecimal valor, BigDecimal selicAnual, int diasUteis) {

        double taxaDiaria = CaixinhaNubank.calcularTaxaDiaria(selicAnual);

        // 1. Montante = Capital * (1 + taxaDiaria)^diasUteis
        BigDecimal fatorCrescimento = new BigDecimal(Math.pow(1 + taxaDiaria, diasUteis));
        BigDecimal montanteFinal = valor.multiply(fatorCrescimento);

        // 2. Rendimento = Montante - Capital
        return montanteFinal.subtract(valor).setScale(2, RoundingMode.HALF_EVEN);
    }

    private static double calcularTaxaDiaria(BigDecimal selicAnual) {
        BigDecimal cdiAnual = selicAnual.subtract(new BigDecimal("0.10"))
                .divide(new BigDecimal("100"), RoundingMode.HALF_EVEN);

        int diasUteisAno = 252;

        // Taxa Diária: (1 + i_ano)^(1/252) - 1
        return Math.pow(BigDecimal.ONE.add(cdiAnual).doubleValue(), 1.0 / diasUteisAno) - 1;
    }
}
