package org.example;

public class Main {
    public static void main(String[] args) {

        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        System.out.println("\nVaca:");
        vaca.emitirSonido();
        vaca.comerHierba();
        vaca.comerCarne();

        System.out.println("\nPerro:");
        perro.emitirSonido();
        perro.comerCarne();

        System.out.println("\nGato:");
        gato.emitirSonido();
        gato.comerCarne();
    }
}

