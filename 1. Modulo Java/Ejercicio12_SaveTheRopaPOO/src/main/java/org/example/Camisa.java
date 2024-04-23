package org.example;

public class Camisa extends Prenda{
    private String talla;
    private int precio;
    public Camisa(String marca, String modelo,String talla, int precio) {
        super(marca, modelo);
        this.talla=talla;
        this.precio=precio;
    }

    @Override
    public String toString() {
        return "Camisa{" +
                "talla='" + talla + '\'' +
                ", precio=" + precio +
                '}';
    }
}
