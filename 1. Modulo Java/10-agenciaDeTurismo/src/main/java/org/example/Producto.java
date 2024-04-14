package org.example;

public class Producto {


    private double precio;
    private String tipoProducto;

    public Producto(String tipo, double precio) {
        this.tipoProducto = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipoProducto;
    }

    public void setTipo(String tipo) {
        this.tipoProducto = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "tipo=" + tipoProducto +
                ", precio=" + precio +
                '}';
    }
}
