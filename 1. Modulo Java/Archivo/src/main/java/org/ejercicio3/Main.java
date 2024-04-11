package org.ejercicio3;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
        System.out.println("--------COMIENDO---------");
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }


    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

}
