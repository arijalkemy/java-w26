package org.example;

public abstract class Prototipo<T extends Number> {
    protected T valorInicial;
    protected T valorStep;
    protected T valorActual;

    public Prototipo() {}

    public abstract T siguiente();

    public abstract void reiniciar();

    public abstract void setValorInicial(T valorInicial);
}

