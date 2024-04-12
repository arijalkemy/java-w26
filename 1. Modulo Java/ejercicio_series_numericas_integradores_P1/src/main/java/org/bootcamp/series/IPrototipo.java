package org.bootcamp.series;

public interface IPrototipo <T extends Number>{

    T siguiente();

    void reiniciar();

    void valorInicial(T valor);

    void valorInicial(Number valor);
}
