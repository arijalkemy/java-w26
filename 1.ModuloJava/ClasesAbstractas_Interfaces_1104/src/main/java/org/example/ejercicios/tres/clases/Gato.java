package org.example.ejercicios.tres.clases;

import org.example.ejercicios.tres.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato(String nombre, String color) {
        super(nombre, color);
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato comio un poco de atún");
    }

    @Override
    public void hacerRuido() {
        System.out.println("Miauu");
    }

}
