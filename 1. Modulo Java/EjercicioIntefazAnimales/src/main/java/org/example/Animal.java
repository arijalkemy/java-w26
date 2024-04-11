package org.example;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void hacerSonido(){
        System.out.println(name+"hace sonido.");
    }
}
