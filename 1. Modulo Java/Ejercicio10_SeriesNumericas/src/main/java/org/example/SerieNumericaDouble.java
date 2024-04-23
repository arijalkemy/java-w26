package org.example;

public class SerieNumericaDouble extends SerieNumerica <Double> {

    public SerieNumericaDouble(Double valorIncremento) {
        super(valorIncremento);
        this.valorActual = 0.0;
        this.valorInicial = 0.0;
    }

    @Override
    public Double getSiguienteValor() {
        this.valorActual += this.valorIncremento;
        return valorActual;
    }

    @Override
    public void establecerValorInicial(String valorInicial) {
        this.valorInicial = Double.parseDouble(valorInicial);
        valorActual = this.valorInicial;
    }
}