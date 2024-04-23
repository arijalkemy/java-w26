package org.example;

public class Pantalon extends Prenda{
    private int talla;
    private int precio;
    public Pantalon(String marca, String modelo,int talla,int precio) {
        super(marca, modelo);
        this.talla=talla;
        this.precio=precio;
    }

    @Override
    public String toString() {
        return "Pantalon{" +
                "talla=" + talla +
                ", precio=" + precio +
                '}';
    }
}
