package com.company;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Item(String codigo, String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
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

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
