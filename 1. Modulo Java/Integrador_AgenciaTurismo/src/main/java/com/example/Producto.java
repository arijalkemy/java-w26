package com.example;

public class Producto {
    private double costoUnitario;
    private String nombre;

    public Producto(double costoUnitario, String nombre) {
        this.costoUnitario = costoUnitario;
        this.nombre = nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
