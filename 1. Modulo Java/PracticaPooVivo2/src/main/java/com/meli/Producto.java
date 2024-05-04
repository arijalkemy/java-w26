package com.meli;

public class Producto
{
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio)
    {
        this.nombre = nombre;
        this.precio = precio;
    }


    public double getPrecio()
    {
        return precio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String toString()
    {
        return "Nombre: " + nombre + " Precio: " + precio;
    }

    public double calcular(int cantidadDeProductos)
    {
        return precio * cantidadDeProductos;
    }
}
