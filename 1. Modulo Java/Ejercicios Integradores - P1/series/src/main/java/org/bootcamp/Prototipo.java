package org.bootcamp;

public abstract class Prototipo {

    private Integer valorInicial;
    private Integer valorActual;

    public abstract Integer valorSiguiente();
    public void reiniciarSerie(){
        valorActual = null;
        valorInicial = null;
    };
    public void valorInicial(Integer valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;
    }
}
