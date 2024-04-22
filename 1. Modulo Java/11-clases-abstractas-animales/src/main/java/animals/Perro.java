package animals;

import animals.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public void emitirSonido() {
        System.out.println("guau");
    }
}
