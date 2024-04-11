package meli.bootcamp.Animales.entidades;

import meli.bootcamp.Animales.interfaces.ComerCarne;

public class Perro extends Animal implements ComerCarne {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        System.out.println("El Perro comió carne");
    }

    @Override
    public void comerAniaml() {
        this.comer();
    }

}
