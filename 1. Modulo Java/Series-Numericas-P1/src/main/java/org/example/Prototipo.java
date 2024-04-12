package org.example;

public abstract class Prototipo<T extends Number> {
    private T valorInicial;
    private T valorActual;
    private int incremento;

    public Prototipo() {}

    public Prototipo(T valorInicial, int incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.valorActual = valorInicial;
    }

    public void siguienteValorSerie(){
        this.valorActual = incrementar();
    }

    public abstract T incrementar();

    public void reiniciarSerie(){
        this.valorActual = this.valorInicial;
    }

    public void establecerValorInicial(T valor){
        this.valorInicial = valor;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }
}



