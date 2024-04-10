package com.example;

public class Producto {
    String nombre;
    double precio;


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }

    /* este método tiene que multiplicar el precio por la cantidad de productos pasados.

     */
    public double calcular(int cantidadDeProductos){
        double resultado = precio * cantidadDeProductos;
        return resultado;
    }
}