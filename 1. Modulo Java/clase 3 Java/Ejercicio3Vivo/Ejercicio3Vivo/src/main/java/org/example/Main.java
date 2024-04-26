package org.example;

public class Main {
    public static void main(String[] args) {
        Animal gato= new Gato();
        Animal perro= new Perro();
        Animal vaca= new Vaca();

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        Alimentador alimentador = new Alimentador();
        alimentador.comerAnimal(gato);
        alimentador.comerAnimal(perro);
        alimentador.comerAnimal(vaca);

    }
}