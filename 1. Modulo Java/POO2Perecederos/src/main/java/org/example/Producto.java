package org.example;

public abstract class Producto {
    private double precio;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos * precio;
    }
}
