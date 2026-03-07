package io.github.dicousdev.rendafixa.imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ImpostoIOF {

    private static final Map<Integer, Integer> TABELA_IOF = new HashMap<>();

    static {
        int[] tabelaPorcentualIof = {96, 93, 90, 86, 83, 80, 76, 73, 70, 66, 63, 60, 56, 53, 50, 46, 43, 40, 36, 33, 30, 26, 23, 20, 16, 13, 10, 6, 3, 0};
        for(int i = 0; i < tabelaPorcentualIof.length; i++) {
            TABELA_IOF.put(i + 1, tabelaPorcentualIof[i]);
        }
    }

    public static BigDecimal calcularValorIOF(BigDecimal rendimentoBruto, Integer diasDecorridos) {
        if (diasDecorridos >= 30) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        int aliquotaPercentual = TABELA_IOF.getOrDefault(diasDecorridos, 96);
        BigDecimal percentual = new BigDecimal(aliquotaPercentual)
                .divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);

        return rendimentoBruto.multiply(percentual).setScale(2, RoundingMode.HALF_UP);
    }

}
