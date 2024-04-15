package org.example.animal;

import org.example.alimentacion.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comerCarne() {
       return "Que rico, miau";
    }
}
