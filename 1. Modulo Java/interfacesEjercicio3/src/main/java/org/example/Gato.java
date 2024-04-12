package org.example;

public class Gato extends Animal implements ICarnivoro {
    private String nombre;

    public Gato(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public void emitirSonido() {
        super.emitirSonido("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("come carne");
    }
}
