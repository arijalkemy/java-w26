package com.example;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.emitirSonido();
        Animal gato = new Gato();
        gato.emitirSonido();
        Animal vaca = new Vaca();
        vaca.emitirSonido();

        Granja granja = new Granja();
        granja.comerAnimal(perro);
        granja.comerAnimal(gato);
        granja.comerAnimal(vaca);

    }
}
/*
Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un objeto de cualquier tipo de
animal como parámetro, invoque al método para comer según corresponda a dicho animal.
 */