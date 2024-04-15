package org.example;

public class SerieDe2 extends Prototipo{

    public SerieDe2() {
        super(0);
    }
    @Override
    public int numeroSiguiente() {
        numeroActual+=2;
        return numeroActual;
    }
}
