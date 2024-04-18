package org.example;

import org.example.model.Gato;
import org.example.model.Perro;
import org.example.model.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println("------- Perro -------");
        perro.emitirSonido();
        perro.comerCarne();

        System.out.println("------- Gato -------");
        gato.emitirSonido();
        gato.comerCarne();

        System.out.println("------- Vaca -------");
        vaca.emitirSonido();
        vaca.comerHierba();
    }
}