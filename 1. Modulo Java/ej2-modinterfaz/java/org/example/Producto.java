package org.example;

public class Producto {
    private String nombre;
    private double precio;

    public String toString(){
        System.out.println("Nombre: "+this.nombre+" Precio: "+this.precio);
        return null;
    }

    public double calcular(int cantidadDeProductos){
        return precio*cantidadDeProductos;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public double getPrecio() {
        return precio;
    }

    public Producto setPrecio(double precio) {
        this.precio = precio;
        return this;
    }
}
