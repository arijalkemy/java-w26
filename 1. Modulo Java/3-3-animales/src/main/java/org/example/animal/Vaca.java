package org.example.animal;

import org.example.alimentacion.Hervivoro;

public class Vaca extends Animal implements Hervivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public String comerHierba() {
        return "Muu delicioso";
    }
}
