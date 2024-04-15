package org.example.Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    public Gato(String nombre, String genero, String tipoAnimal) {
        super(nombre, genero, tipoAnimal);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
