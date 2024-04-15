package Clases;

import Interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    public Vaca() {
    }

    @Override
    public String comerHierba() {
        return "La vaca come hierba";
    }

    @Override
    public String emitirSonido() {
        return "Muuu!";
    }

}
