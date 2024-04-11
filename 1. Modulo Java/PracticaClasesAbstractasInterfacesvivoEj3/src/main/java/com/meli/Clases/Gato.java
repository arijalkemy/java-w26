package com.meli.Clases;

import com.meli.Abtractas.Animal;
import com.meli.Interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {

    @Override
    public void comer() {
        System.out.println("El gato come carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }


}
