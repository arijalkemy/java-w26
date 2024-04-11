package com.company;

public class Main {

    public static void main(String[] args) {

        Animal perro = new Perro("Perro", "Boby");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("Gato", "Morita");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
