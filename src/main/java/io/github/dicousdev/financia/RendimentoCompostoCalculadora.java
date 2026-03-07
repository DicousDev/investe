package io.github.dicousdev.financia;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RendimentoCompostoCalculadora {

    public static BigDecimal calcularRendimentoBrutoComposto(BigDecimal capital, BigDecimal selicAno, int diasUteis) {
        // 1. CDI Anual (Selic - 0.10) / 100 para decimal
        BigDecimal cdiAnual = selicAno.subtract(new BigDecimal("0.10"))
                .divide(new BigDecimal("100"), RoundingMode.HALF_EVEN);

        // 2. Taxa Diária: (1 + i_ano)^(1/252) - 1
        int diasUteisAno = 252;
        double taxaDiaria = Math.pow(BigDecimal.ONE.add(cdiAnual).doubleValue(), 1.0 / diasUteisAno) - 1;

        // 3. Montante = Capital * (1 + taxaDiaria)^diasUteis
        BigDecimal fatorCrescimento = new BigDecimal(Math.pow(1 + taxaDiaria, diasUteis));
        BigDecimal montanteFinal = capital.multiply(fatorCrescimento);

        // 4. Rendimento = Montante - Capital
        return montanteFinal.subtract(capital).setScale(2, RoundingMode.HALF_EVEN);
    }
}
