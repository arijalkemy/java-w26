package ex3;

import interfaces.IAlimentacionHerbivora;

public class Vaca extends Animal implements IAlimentacionHerbivora {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
