package org.example;

public class Cow extends Animal implements IHerviboro{
    @Override
    public void emitSound() {
        System.out.println("Vaca: Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comer hierba");
    }
}
