package org.example;

public class Vaca extends Animal implements IHerviboro{

    private String animal;

    public Vaca(String animal) {
        this.animal = animal;
    }

    public Vaca() {}

    @Override
    public void emitirSonido() {
        super.emitirSonido("muuu");
    }


    @Override
    public void comerHierba() {
        System.out.println("come hierva");
    }
}
