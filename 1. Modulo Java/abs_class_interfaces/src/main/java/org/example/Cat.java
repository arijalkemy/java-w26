package org.example;

public class Cat extends Animal implements ICarnivoro{
    @Override
    public void emitSound() {
        System.out.println("Gato: Miaw");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }
}
