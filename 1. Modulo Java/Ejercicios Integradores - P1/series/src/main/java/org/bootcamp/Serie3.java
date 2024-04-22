package org.bootcamp;

public class Serie3 extends Prototipo{

    @Override
    public Integer valorSiguiente() {
        super.setValorActual(super.getValorActual()+3);
        return super.getValorActual();
    }
}
