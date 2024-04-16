package org.products;

public class Producto {
    protected String nombre;
    protected double precio;


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

    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + ". Precio: " + this.precio + ".";
    }

    public void calcular(int cantidadDeProductos) {
        this.precio = this.precio * cantidadDeProductos;
    }
}
