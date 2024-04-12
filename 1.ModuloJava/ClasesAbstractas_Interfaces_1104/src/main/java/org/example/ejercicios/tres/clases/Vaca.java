package org.example.ejercicios.tres.clases;

import org.example.ejercicios.tres.interfaces.Omnivoro;

public class Vaca extends Animal implements Omnivoro {
    public Vaca(String nombre, String color) {
        super(nombre, color);
    }

    @Override
    public void hacerRuido() {
        System.out.println("MUUUUUUUUUUUU");
    }

    @Override
    public void comerPlantas() {
        System.out.println("La vaca comio un poco de pasto");
    }
}
