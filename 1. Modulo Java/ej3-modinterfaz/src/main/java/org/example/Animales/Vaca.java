package org.example.Animales;

public class Vaca extends Animal implements Herbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }


    @Override
    public void comerHierba() {
        System.out.println("como hierba");
    }
}
