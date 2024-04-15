package org.example.Ejercicio3;

public class Vaca extends Animal implements Herviboro{
    public Vaca(String nombre, String genero, String tipoAnimal) {
        super(nombre, genero, tipoAnimal);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }


}
