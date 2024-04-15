package Clases;

import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    public Perro() {
    }

    @Override
    public String emitirSonido() {
        return "Guau!";
    }

    @Override
    public String comerCarne() {
        return "El perro come carne";
    }
}
