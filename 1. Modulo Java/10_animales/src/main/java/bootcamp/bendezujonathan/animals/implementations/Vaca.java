package bootcamp.bendezujonathan.animals.implementations;

import bootcamp.bendezujonathan.animals.Animal;
import bootcamp.bendezujonathan.animals.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void comerHierba() {
        System.out.println("muuu que buuuuuen pastito");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }
    
}
