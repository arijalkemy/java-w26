package org.example;

public class SerieInteger extends Prototipo<Integer> {


    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
        if (this.valorInicial <= 1) {
            this.valorStep = 2;
            this.valorInicial = 3;
        } else {
            this.valorStep = this.valorInicial;
        }
        reinciarActual();
    }

    @Override
    public Integer siguiente() {
        if (valorActual == null) {
            valorActual = valorInicial;
            return valorActual;
        }
        this.valorActual += this.valorStep;
        return valorActual;
    }

    @Override
    public void reiniciar() {
        reinciarActual();
    }

    private void reinciarActual() {
        this.valorActual = null;
    }
}
