package org.example;

public class Producto {
    private TipoProducto tipo;
    private int cantidad;
    private double precio;

    public Producto(TipoProducto tipo, int cantidad, double precio) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}