package io.github.dicousdev.rendafixa.investimento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IpcaMais {

    public static BigDecimal calcularRendimentoBruto(BigDecimal valor, BigDecimal porcentagemIpca, BigDecimal taxaFixaAnual, int diasDecorridos) {
        BigDecimal fatorIpca = porcentagemIpca.divide(new BigDecimal("100"), 8, RoundingMode.HALF_UP);
        BigDecimal fatorTaxaFixa = taxaFixaAnual.divide(new BigDecimal("100"), 8, RoundingMode.HALF_UP);

        BigDecimal taxaTotalAnual = (BigDecimal.ONE.add(fatorIpca))
                .multiply(BigDecimal.ONE.add(fatorTaxaFixa))
                .subtract(BigDecimal.ONE);

        double expoente = (double) diasDecorridos / 365;
        double resultadoComposto = Math.pow(taxaTotalAnual.add(BigDecimal.ONE).doubleValue(), expoente);

        BigDecimal montanteFinal = valor.multiply(BigDecimal.valueOf(resultadoComposto));
        return montanteFinal.subtract(valor).setScale(2, RoundingMode.HALF_UP);
    }
}
