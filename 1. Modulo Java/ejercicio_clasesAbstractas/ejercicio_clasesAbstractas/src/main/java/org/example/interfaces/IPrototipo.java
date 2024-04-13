package org.example.interfaces;

import java.util.List;

public interface IPrototipo <T extends Number>{
    public T obtenerSiguiente();
    public void reiniciarSerie();
    public void valorInicial(T inicial);
}
