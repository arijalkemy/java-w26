package org.example;

public abstract class Producto {
    private String nombre;
    private double precio;

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

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toString(){
        return "El nombre es " + this.nombre + ". El precio es: " + this.precio;
    }

    public double calcular(int cantidadDeProductos){
        return cantidadDeProductos * this.precio;
    }
}
