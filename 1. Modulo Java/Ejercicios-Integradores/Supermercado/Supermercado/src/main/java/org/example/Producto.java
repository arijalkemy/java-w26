package org.example;

import java.util.UUID;

public class Producto {
    private UUID codigo;
    private String nombre;
    private int cantidaComprada;
    private double costoUnitario;

    public Producto(UUID codigo, String nombre, int cantidaComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidaComprada = cantidaComprada;
        this.costoUnitario = costoUnitario;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidaComprada() {
        return cantidaComprada;
    }

    public void setCantidaComprada(int cantidaComprada) {
        this.cantidaComprada = cantidaComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
