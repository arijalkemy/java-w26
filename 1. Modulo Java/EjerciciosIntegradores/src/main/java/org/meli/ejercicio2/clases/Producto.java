package org.meli.ejercicio2.clases;

public class Producto {
    public Integer código;
    public String nombre;
    public double costoUnitario;

    public Integer cantidad;

    public Producto(Integer código, String nombre, double costoUnitario, Integer cantidad) {
        this.código = código;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public Integer getCódigo() {
        return código;
    }

    public void setCódigo(Integer código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "" + código +"   " + nombre + "   " + costoUnitario +"   " + cantidad;
    }
}
