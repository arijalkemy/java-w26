package modelo.animales;

import enums.GustosAlimenticios;

public abstract class Animal {

    public abstract void emitirSonido();

    private GustosAlimenticios gustosAlimenticio;

    public Animal(GustosAlimenticios gustosAlimenticio) {
        this.gustosAlimenticio = gustosAlimenticio;
    }

    public GustosAlimenticios getGustosAlimenticio() {
        return gustosAlimenticio;
    }

    public void setGustosAlimenticio(GustosAlimenticios gustosAlimenticio) {
        this.gustosAlimenticio = gustosAlimenticio;
    }
}
