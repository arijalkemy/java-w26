package org.example;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println("GATO");
        gato.emitirSonido();
        gato.comerCarne();
        System.out.println("\nPERRO");
        perro.emitirSonido();
        perro.comerCarne();
        System.out.println("\nVACA");
        vaca.emitirSonido();
        vaca.comerHierba();
    }
}