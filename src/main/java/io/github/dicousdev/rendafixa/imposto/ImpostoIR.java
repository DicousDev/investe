package io.github.dicousdev.rendafixa.imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoIR {

    public static BigDecimal calcularIR(BigDecimal rendimentoBase, Integer diasDecorridos) {
        BigDecimal aliquota;

        if (diasDecorridos <= 180) {
            aliquota = new BigDecimal("0.225");
        } else if (diasDecorridos <= 360) {
            aliquota = new BigDecimal("0.20");
        } else if (diasDecorridos <= 720) {
            aliquota = new BigDecimal("0.175");
        } else {
            aliquota = new BigDecimal("0.15");
        }

        return rendimentoBase.multiply(aliquota).setScale(2, RoundingMode.HALF_UP);
    }
}
