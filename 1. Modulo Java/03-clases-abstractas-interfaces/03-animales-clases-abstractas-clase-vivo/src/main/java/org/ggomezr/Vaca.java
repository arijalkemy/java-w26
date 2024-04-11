package org.ggomezr;

public class Vaca extends Animal implements Herbivoro{
    @Override
    void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca esta comiendo hierba");
    }
}
