package com.meli;

public class Vehiculo {
    private String marca;
    private String modelo;
    private Integer monto;

    public Vehiculo(String marca, String modelo, Integer monto) {
        this.marca = marca;
        this.modelo = modelo;
        this.monto = monto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
}
