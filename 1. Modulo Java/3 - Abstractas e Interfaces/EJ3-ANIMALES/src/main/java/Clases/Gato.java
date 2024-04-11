package Clases;

import Interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {

    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
