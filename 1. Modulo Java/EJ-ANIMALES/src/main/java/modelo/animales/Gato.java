package modelo.animales;

import enums.GustosAlimenticios;
import interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {

    public Gato() {
        super(GustosAlimenticios.CARNIVORO);
    }

    public void emitirSonido() {
        System.out.println("MIAU");
    }


    public void comerCarne() {
        System.out.println("GATO COMIENDO CARNE");
    }

}
