package org.example.ejercicio_3;

public class Vaca extends Animal implements Hervivoro {
    public Vaca() {
    }
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    public void comerHierba() {
        System.out.println("Qué rica hierba, muuu!");
    }
}
