package org.bootcamp.series;

public interface IPrototipo <T extends Number>{

    T siguienteValor();

    void reiniciarSerie();

    void establecerValorInicial(T valorInicial);

}
