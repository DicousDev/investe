package io.github.dicousdev.rendafixa.investimento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CaixinhaNubank {

    public static BigDecimal calcularRendimentoBrutoAnual(BigDecimal valor, BigDecimal selic) {
        BigDecimal taxaCDI = selic.subtract(new BigDecimal("0.10"));
        return valor.multiply(taxaCDI)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
    }
}
