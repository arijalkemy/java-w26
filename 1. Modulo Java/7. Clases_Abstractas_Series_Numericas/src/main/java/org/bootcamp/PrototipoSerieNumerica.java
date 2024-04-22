package org.bootcamp;

public abstract class PrototipoSerieNumerica <T extends Number> {
    protected T valorInicial;

    public abstract T siguienteNumero();
    public abstract void reiniciarSerie();
    public abstract void establecerInicio(T valorInicial);
}
