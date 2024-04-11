package bootcamp.bendezujonathan.animals.implementations;

import bootcamp.bendezujonathan.animals.Animal;
import bootcamp.bendezujonathan.animals.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void comerCarne() {
        System.out.println("mm que buen pescado.");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau miau");
    }
    
}
