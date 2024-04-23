package org.example;

//Creamos la clase padre por la cual se van a guiar las clases hijas
public class Producto {
    //Con sus atributos
    private String nombre;
    private double precio;
    //Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    //Estructura de visualización
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPrecio: " + precio + "\n";
    }

    //Metodo para calcular el valor de canasta
    public double calcular(int cantidadDeProductos) {
        return precio * cantidadDeProductos;
    }

    //Setters y Getters
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
}
