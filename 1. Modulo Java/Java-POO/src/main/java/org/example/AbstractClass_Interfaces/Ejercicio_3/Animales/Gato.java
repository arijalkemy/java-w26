package org.example.AbstractClass_Interfaces.Ejercicio_3.Animales;

public class Gato extends Animal{

    @Override
    public void emitirSonido() {
        System.out.println("Miau miau");
    }

    @Override
    public void comer() {
        System.out.println("Come carne");
    }
}
