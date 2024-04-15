package org.example.ejer3;

public class Vaca extends Animal implements IHerbivoro{
    public Vaca() {
    }

    @Override
    public void emitirSonido(){
        System.out.println("Muu");
    }

    @Override
    public String comerHierba(){
        return "Como pasto";
    }
}
