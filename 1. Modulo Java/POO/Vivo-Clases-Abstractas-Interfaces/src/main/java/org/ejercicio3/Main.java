package org.ejercicio3;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        comerAnimal(perro);
        comerAnimal(vaca);
    }


    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

}
