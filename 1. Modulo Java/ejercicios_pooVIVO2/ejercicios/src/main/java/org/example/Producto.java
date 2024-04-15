package org.example;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


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
        return "Nombre: "+this.nombre+", Precio: "+this.precio;
    }
    public double calcular(int cantidadDeProductos){
        try{
            if (cantidadDeProductos<=0){
                throw new IllegalArgumentException ("La cantidad de productos debe ser mayor a cero.");
            }
            return this.precio*cantidadDeProductos;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
