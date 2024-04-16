package Clases;

public abstract class Descuento {

    private double descuento;

    public Descuento(double descuento) {
        this.descuento = descuento;
    }

    public abstract double aplicarDescuento(Localizador localizador);

    public double getDescuento() {
        return descuento;
    }
}
