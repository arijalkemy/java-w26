package ex3;

import interfaces.IAlimentacionCarnivora;

public class Perro extends Animal implements IAlimentacionCarnivora {

    @Override
    public void emitirSonido() {
        System.out.println("Waffff");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }
}
