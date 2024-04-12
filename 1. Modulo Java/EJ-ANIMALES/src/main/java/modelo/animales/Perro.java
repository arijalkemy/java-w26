package modelo.animales;

import enums.GustosAlimenticios;
import interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {


    public Perro() {
        super(GustosAlimenticios.CARNIVORO);
    }

    public void emitirSonido() {
        System.out.println("GUAU");
    }

    public void comerCarne() {
        System.out.println("PERRO COMIENDO CARNE");
    }

}

