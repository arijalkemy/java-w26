package org.example.animal;

import org.example.alimentacion.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String comerCarne() {
        return "Exquisito! guau";
    }
}
