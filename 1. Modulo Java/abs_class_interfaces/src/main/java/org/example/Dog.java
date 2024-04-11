package org.example;

public class Dog extends Animal implements ICarnivoro{
    @Override
    public void emitSound() {
        System.out.println("Perro: Guaw");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
