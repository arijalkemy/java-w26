package org.bootcamp.ejercicio3;

import org.bootcamp.ejercicio3.entidades.Gato;
import org.bootcamp.ejercicio3.entidades.Perro;
import org.bootcamp.ejercicio3.entidades.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.hacerSonido();
        perro.comer();

        Gato gato = new Gato();
        gato.hacerSonido();
        gato.comer();

        Vaca vaca = new Vaca();
        vaca.hacerSonido();
        vaca.comer();

    }
}
