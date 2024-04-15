package org.example;

import org.example.animal.Animal;
import org.example.animal.Gato;
import org.example.animal.Perro;
import org.example.animal.Vaca;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        System.out.println(perro.comerCarne());
        System.out.println(gato.comerCarne());
        System.out.println(vaca.comerHierba());

        System.out.println(comerAnimal(perro));
        System.out.println(comerAnimal(gato));
        System.out.println(comerAnimal(vaca));
    }

    public static String comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            return ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            return ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            return ((Vaca) animal).comerHierba();
        }
        return "";
    }
}