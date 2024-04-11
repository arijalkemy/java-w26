package org.example.AbstractClass_Interfaces.Ejercicio_3.Animales;

public class Vaca extends  Animal{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        System.out.println("Come hierba");
    }
}
