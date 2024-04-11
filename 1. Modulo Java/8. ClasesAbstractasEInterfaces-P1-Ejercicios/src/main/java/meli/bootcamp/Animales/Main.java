package meli.bootcamp.Animales;

import meli.bootcamp.Animales.entidades.Animal;
import meli.bootcamp.Animales.entidades.Perro;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.hacerSonido();
        perro.comer();

        Animal.comerAnimal(perro);
    }
}
