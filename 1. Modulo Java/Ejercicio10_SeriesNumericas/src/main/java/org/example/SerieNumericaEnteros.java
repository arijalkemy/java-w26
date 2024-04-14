package org.example;

public class SerieNumericaEnteros extends SerieNumerica<Integer>{

    public SerieNumericaEnteros(Integer valorIncremento) {
        super(valorIncremento);
        this.valorActual = 0;
        this.valorInicial = 0;
    }

    @Override
    public Integer getSiguienteValor() {
        this.valorActual += this.valorIncremento;
        return valorActual;
    }

    @Override
    public void establecerValorInicial(String valorInicial) {
        this.valorInicial = Integer.parseInt(valorInicial);
        valorActual = this.valorInicial;
    }
}
