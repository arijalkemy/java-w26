package animals;

import animals.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    public void emitirSonido() {
        System.out.println("muuu");
    }
}
