package meli.bootcamp.Animales.entidades;

import meli.bootcamp.Animales.interfaces.ComerHierba;

public class Vaca extends Animal implements ComerHierba {

    @Override
    public void hacerSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        System.out.println("La vaca comió hierba");
    }

    @Override
    public void comerAniaml() {
        this.comer();
    }
}
