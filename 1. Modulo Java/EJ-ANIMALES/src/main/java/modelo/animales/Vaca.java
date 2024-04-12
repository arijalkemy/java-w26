package modelo.animales;

import enums.GustosAlimenticios;
import interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {

    public Vaca() {
        super(GustosAlimenticios.HERBIVORO);
    }

    public void emitirSonido() {
        System.out.println("MUUU");
    }


    public void comerHierba() {
        System.out.println("VACA COMIENDO HIERBAS");
    }

}
