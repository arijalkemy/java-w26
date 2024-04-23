package org.example;

public class Zapatos extends Prenda{
    private int talla;
    private int precio;
    public Zapatos(String marca, String modelo,int talla,int precio) {
        super(marca, modelo);
        this.talla=talla;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Zapatos{" +
                "talla=" + talla +
                ", precio=" + precio +
                '}';
    }
}
