package com.example;

public class Producto {
    int codigo;
    String nombre;
    int cantidadComprada;
    double costoUnitario;

    public Producto(int codigo, String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public double obtenerCostoPorProducto(){
        return cantidadComprada * costoUnitario;
    }
    

}
