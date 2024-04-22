package com.bootcamp.animals;

public class App {
    public static void main (String[] args){
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        gato.emitirSonido();
        System.out.println(gato.comeCarne());
        perro.emitirSonido();
        System.out.println(perro.comeCarne());
        vaca.emitirSonido();
        System.out.println(vaca.comeHierba());
    }
}
