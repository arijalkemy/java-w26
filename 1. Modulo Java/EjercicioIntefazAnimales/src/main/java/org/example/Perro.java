package org.example;

public class Perro extends Animal implements Comer {
    private String sound;

    public Perro(String name, String sound) {
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
        System.out.println("Si come hierva");

    }
}
