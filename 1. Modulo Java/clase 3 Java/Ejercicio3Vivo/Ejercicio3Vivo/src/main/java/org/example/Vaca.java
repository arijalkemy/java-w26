package org.example;

public class Vaca extends Animal implements IHervioro{
    @Override
    protected void emitirSonido() {
        System.out.println("Muuu ");
    }

    @Override
    protected void comer() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca que come hierba");
    }
}

