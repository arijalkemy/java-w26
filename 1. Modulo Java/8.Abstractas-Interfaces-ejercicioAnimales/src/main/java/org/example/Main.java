package org.example;

import org.example.Clases.*;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();


        // se ejecuta el metodo emitirSonido
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        //se ejecuta el metodo comerCarne y comerHierbaa
        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        // se prueba el metodo comerAnimal
        comerAnimal(perro);
        comerAnimal(vaca);
        comerAnimal(gato);


    }
    public static  void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        } else{
            System.out.println("Este animal no existe");
        }
    }
}