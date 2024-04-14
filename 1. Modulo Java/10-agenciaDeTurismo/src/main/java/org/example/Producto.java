package org.example;

public class Producto {


    private String id;
    private double precio;
    private String tipoProducto;

    public Producto(String id, String tipo, double precio) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "tipo=" + tipoProducto +
                ", precio=" + precio +
                '}';
    }
}
