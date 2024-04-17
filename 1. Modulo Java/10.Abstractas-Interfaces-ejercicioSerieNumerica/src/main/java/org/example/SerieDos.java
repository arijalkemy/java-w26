package org.example;

public class SerieDos extends Prototipo {
    @Override
    public Number valorSiguiente() {
        Number siguiente = this.valorActual.intValue() +3;
        this.valorActual = siguiente;
        System.out.println("valor calculado: "+ siguiente);
        return siguiente;
    }
}


