package org.example.Ejercicio3;

public class Perro extends Animal implements Carnivoro{
    public Perro(String nombre, String genero, String tipoAnimal) {
        super(nombre, genero, tipoAnimal);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }

}
