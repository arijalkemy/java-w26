package org.example.ejercicios.tres.clases;

import org.example.ejercicios.tres.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {


    public Perro(String nombre, String color) {
        super(nombre, color);
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro comio un bife");
    }

    @Override
    public void hacerRuido() {
        System.out.println("Guau Guau Guauuuuu");
    }
}
