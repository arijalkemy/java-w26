package org.example;

public class SerieDe7 extends Prototipo{
    public SerieDe7() {

        super(0);
    }

    @Override
    public int numeroSiguiente() {
        numeroActual+=7;
        return numeroActual;

    }
}
