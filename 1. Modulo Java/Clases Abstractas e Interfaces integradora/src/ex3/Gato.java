package ex3;

import interfaces.IAlimentacionCarnivora;
import interfaces.IAlimentacionHerbivora;

public class Gato extends Animal implements IAlimentacionCarnivora {
    @Override
    public void emitirSonido() {
        System.out.println("Miaaaauuuu");
    }


    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
