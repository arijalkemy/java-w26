package animals;

import animals.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro  {
    public void emitirSonido() {
        System.out.println("miau");
    }

    public void comerCarne() {
        System.out.println("Estoy comiendo carne");
    }
}
