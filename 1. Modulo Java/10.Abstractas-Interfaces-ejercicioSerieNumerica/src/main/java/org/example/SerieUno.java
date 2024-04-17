package org.example;

public class SerieUno extends Prototipo {
    @Override
    public Number valorSiguiente() {
        Number siguiente = this.valorActual.intValue() + 2;
        this.valorActual = siguiente;
        System.out.println("valor calculado: " + siguiente);
        return siguiente;
    }
}
