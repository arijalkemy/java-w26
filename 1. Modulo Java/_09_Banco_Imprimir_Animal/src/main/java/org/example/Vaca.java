package org.example;

public class Vaca extends Animal implements IHervivoro{
    public void emitirSonido(){
        System.out.println("muu");
    }

    public void comerHierba(){
        System.out.println("Soy una vaca y como hierba");
    }
}
