package org.example;

public class Perro extends Animal implements ICarnivoro{
    private String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void emitirSonido() {
        super.emitirSonido("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("come carne");
    }
}
