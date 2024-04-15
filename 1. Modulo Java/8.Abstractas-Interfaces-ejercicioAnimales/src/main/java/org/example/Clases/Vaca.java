package org.example.Clases;
import org.example.interfases.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierva!");
    }

}

