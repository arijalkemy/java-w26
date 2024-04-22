package org.bootcamp;

public class SerieFraccion extends PrototipoSerieNumerica<Double> {
    public SerieFraccion() {
        valorInicial = 0.0;
    }
    @Override
    public Double siguienteNumero() {
        return valorInicial += 0.5;
    }

    @Override
    public void reiniciarSerie() {
        valorInicial = 0.0;
    }

    @Override
    public void establecerInicio(Double valorInicial) {
        this.valorInicial = valorInicial;
    }
}
