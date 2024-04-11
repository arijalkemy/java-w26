package org.example;

public class Vaca extends Animal implements Comer{
    private String sound;

    public Vaca(String name, String sound) {
        super(name);
        this.sound = sound;
    }

    @Override
    public void hacerSonido() {
        System.out.println(sound);
    }

    @Override
    public void comerCarne() {
        System.out.println("No come carne");
    }

    @Override
    public void comerHierva() {
        System.out.println("Si come hierva");

    }
}
