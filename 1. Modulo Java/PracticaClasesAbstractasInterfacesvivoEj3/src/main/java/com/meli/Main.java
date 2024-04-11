package com.meli;

import com.meli.Clases.Gato;
import com.meli.Clases.Perro;
import com.meli.Abtractas.Animal;
import com.meli.Clases.Vaca;
import com.meli.Interfaces.ICarnivoro;
import com.meli.Interfaces.IHerbivoro;

public class Main {

    static void comerAnimal(Animal animal) {
        if (animal instanceof ICarnivoro) {
            ((ICarnivoro) animal).comer();
        } else if (animal instanceof IHerbivoro) {
            ((IHerbivoro) animal).comer();
        } else {
            System.out.println("No se puede determinar el tipo de alimentación del animal.");
        }
    }

    public static void main(String[] args) {

        System.out.println("----- Perro ----");
        Perro perro = new Perro();
        perro.comer();
        perro.emitirSonido();
        comerAnimal(perro);

        System.out.println("----- Gato ----");
        Gato gato = new Gato();
        gato.comer();
        gato.emitirSonido();
        comerAnimal(gato);

        System.out.println("----- Vaca ----");
        Vaca vaca = new Vaca();
        vaca.comer();
        vaca.emitirSonido();
        comerAnimal(vaca);




    }
}