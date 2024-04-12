package org.example.ejercicio3;

import java.util.Random;

public class Item {

    private final int codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    private static final Random generadorCodigos = new Random();

    public Item(String nombre, int cantidadComprada, double costoUnitario) {
        this.codigo = generadorCodigos.nextInt();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double calcularCostoItem() {
        return this.costoUnitario * this.cantidadComprada;
    }

    @Override
    public String toString() {
        return "Item{" +
            "codigo='" + codigo + '\'' +
            ", nombre='" + nombre + '\'' +
            ", cantidadComprada='" + cantidadComprada + '\'' +
            ", costoUnitario='" + costoUnitario + '\'' +
            '}';
    }
}
