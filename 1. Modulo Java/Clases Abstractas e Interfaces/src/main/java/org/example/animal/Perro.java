package org.example.animal;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("*El perro comió carne*");
    }
}
