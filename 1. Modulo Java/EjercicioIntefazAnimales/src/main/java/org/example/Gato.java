package org.example;

import java.sql.SQLOutput;

public class Gato extends Animal implements Comer{
    private String sound;

    public Gato(String name, String sound) {
        super(name);
        this.sound = sound;
    }

    @Override
    public void hacerSonido() {
        System.out.println(sound);
    }

    @Override
    public void comerCarne() {
        System.out.println("Si come carne");
    }

    @Override
    public void comerHierva() {
        System.out.println("No come hierva");
    }
}
