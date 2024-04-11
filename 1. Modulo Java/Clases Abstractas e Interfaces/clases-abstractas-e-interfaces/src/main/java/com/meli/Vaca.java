package com.meli;

public class Vaca extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba(){
        System.out.println("Es mejor comer hierba");
    }
}
