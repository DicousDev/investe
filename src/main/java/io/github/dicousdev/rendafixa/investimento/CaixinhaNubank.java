package io.github.dicousdev.rendafixa.investimento;

import io.github.dicousdev.financia.RendimentoCompostoCalculadora;

import java.math.BigDecimal;

public class CaixinhaNubank {

    public static BigDecimal calcularRendimentoBruto(BigDecimal valor, BigDecimal selic, int diasUteis) {
        return RendimentoCompostoCalculadora.calcularRendimentoBrutoComposto(valor, selic, diasUteis);
    }
}
