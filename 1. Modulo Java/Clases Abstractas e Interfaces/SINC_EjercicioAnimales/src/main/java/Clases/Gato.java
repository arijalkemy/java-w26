package Clases;

import Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato() {
    }

    @Override
    public String comerCarne() {
        return "El gato come carne";
    }

    @Override
    public String emitirSonido() {
        return "Miau!";
    }

}
