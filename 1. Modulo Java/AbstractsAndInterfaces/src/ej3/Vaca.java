package ej3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Mu");
    }

    @Override
    public void comerPlanta() {
        System.out.println("Vaca come planta");
    }
}
