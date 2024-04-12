package org.example;

public abstract class Animal {
    public void emitirSonido(String sonido){
        System.out.println("el sonido del anima es: " + sonido);
    }

    public abstract void emitirSonido();
}
