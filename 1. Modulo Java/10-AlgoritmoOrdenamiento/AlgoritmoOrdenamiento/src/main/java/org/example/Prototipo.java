package org.example;

public abstract class Prototipo {
    private Number valorInicial;

    public Number getValorInicial() {
        return valorInicial;
    }

    public abstract Number siguienteNumero(Integer anterior);

    public abstract void reiniciar();
    public void numeroInicial(Number inicial){
        this.valorInicial = inicial;
    }
}
