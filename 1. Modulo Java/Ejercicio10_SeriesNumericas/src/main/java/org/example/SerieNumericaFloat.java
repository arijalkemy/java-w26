package org.example;

public class SerieNumericaFloat extends SerieNumerica<Float> {

    public SerieNumericaFloat(Float valorIncremento) {
        super(valorIncremento);
        this.valorActual = 0.0F;
        this.valorInicial = 0.0F;
    }

    @Override
    public Float getSiguienteValor() {
        this.valorActual += this.valorIncremento;
        return valorActual;
    }

    @Override
    public void establecerValorInicial(String valorInicial) {
        this.valorInicial = Float.parseFloat(valorInicial);
        valorActual = this.valorInicial;
    }
}