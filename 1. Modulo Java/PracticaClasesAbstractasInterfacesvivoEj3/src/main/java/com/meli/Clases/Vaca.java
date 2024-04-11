package com.meli.Clases;

import com.meli.Abtractas.Animal;
import com.meli.Interfaces.IHerbivoro;



public class Vaca extends Animal implements IHerbivoro {

    @Override
    public void comer() {
        System.out.println("La vaca come hierba");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }
}
