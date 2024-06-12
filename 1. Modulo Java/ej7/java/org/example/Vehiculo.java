package org.example;

public class Vehiculo {
    private String modelo;
    private String marca;
    private int costo;

    public Vehiculo(String marca,String modelo,int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public Vehiculo setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public Vehiculo setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public int getCosto() {
        return costo;
    }

    public Vehiculo setCosto(int costo) {
        this.costo = costo;
        return this;
    }
}
