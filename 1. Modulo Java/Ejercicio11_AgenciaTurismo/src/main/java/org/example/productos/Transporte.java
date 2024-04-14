package org.example.productos;

public class Transporte implements Producto {
    @Override
    public double getPrecio() {
        return 10000;
    }

    @Override
    public String getDescripcion() {
        return "Taxis";
    }
}
