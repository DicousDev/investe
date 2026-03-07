package io.github.dicousdev.rendafixa.imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoIR {

    public static BigDecimal calcularIR(BigDecimal rendimentoBase, Integer dias) {
        BigDecimal aliquota;

        if (dias <= 180) {
            aliquota = new BigDecimal("0.225");
        } else if (dias <= 360) {
            aliquota = new BigDecimal("0.20");
        } else if (dias <= 720) {
            aliquota = new BigDecimal("0.175");
        } else {
            aliquota = new BigDecimal("0.15");
        }

        return rendimentoBase.multiply(aliquota).setScale(2, RoundingMode.HALF_UP);
    }
}
