package org.bootcamp;

public class Serie2 extends Prototipo {
    @Override
    public Integer valorSiguiente() {
        super.setValorActual(super.getValorActual() + 2);
        return super.getValorActual();
    }
}


