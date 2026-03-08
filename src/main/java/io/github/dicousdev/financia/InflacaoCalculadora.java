package io.github.dicousdev.financia;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InflacaoCalculadora {

    private static final BigDecimal CEM = new BigDecimal(100);

    public static BigDecimal inflacao(BigDecimal valor, BigDecimal porcentagemIPCA) {
        BigDecimal divisor = porcentagemIPCA.divide(CEM).add(BigDecimal.ONE);
        return valor.divide(divisor, 2, RoundingMode.UP);
    }
}
