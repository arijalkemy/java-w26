package org.example.AbstractClass_Interfaces.Ejercicio_3.Animales;

public class Perro extends  Animal{


    @Override
    public void emitirSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comer() {
        System.out.println("Come carne");
    }
}
