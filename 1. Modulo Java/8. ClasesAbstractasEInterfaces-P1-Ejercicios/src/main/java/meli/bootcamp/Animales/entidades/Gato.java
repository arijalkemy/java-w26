package meli.bootcamp.Animales.entidades;

import meli.bootcamp.Animales.interfaces.ComerCarne;

public class Gato extends Animal  implements ComerCarne {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        System.out.println("El gato comió carne");
    }

    @Override
    public void comerAniaml() {
        this.comer();
    }
}
