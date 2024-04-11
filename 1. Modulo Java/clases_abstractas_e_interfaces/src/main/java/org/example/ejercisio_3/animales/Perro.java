package org.example.ejercisio_3.animales;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    public Perro() {

    }

    @Override
    public void comerCarne() {
        System.out.println("El perro comio su carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
