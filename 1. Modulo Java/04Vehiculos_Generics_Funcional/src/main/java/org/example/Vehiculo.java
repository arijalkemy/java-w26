package org.example;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Integer costo;

    public Vehiculo(String marca, String modelo, Integer costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}

