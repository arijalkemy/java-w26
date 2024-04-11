package com.company;

import com.company.classes.*;
import com.company.interfaces.IHerbivoro;

public class Main {

    public static void main(String[] args) {

        // Se instancian los animales
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        // Llamada a los métodos polimórficos
        vaca.comerHierba();
        vaca.emitirSonido();

        perro.comerCarne();
        perro.emitirSonido();

        gato.comerCarne();
        gato.emitirSonido();

        //Llamada a la función comerAnimal hecha con Generics
        ComerAnimal comerAnimal = new ComerAnimal();

        comerAnimal.comerAnimal(vaca);
        comerAnimal.comerAnimal(perro);
        comerAnimal.comerAnimal(gato);
    }
}
