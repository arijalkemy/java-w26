package org.example.animal;

public class Vaca extends Animal implements Hervivoro{
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("*La vaca comió hierba*");
    }
}
