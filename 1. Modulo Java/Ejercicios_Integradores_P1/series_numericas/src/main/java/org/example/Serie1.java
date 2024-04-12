package org.example;

public class Serie1 extends Prototipo<Number>{
    private Number valorInicial;
    private Number valorActual;

    @Override
    public void iniciarSerie(Number num) {
        this.valorInicial = num;
        this.valorActual = 0;
    }

    @Override
    public double numeroSiguiente() {
        this.valorActual = this.valorInicial.doubleValue() + this.valorActual.doubleValue();
        return this.valorActual.doubleValue();
    }

    @Override
    public double reiniciarSerie() {
        this.valorActual = this.valorInicial;
        return this.valorActual.doubleValue();
    }
}
