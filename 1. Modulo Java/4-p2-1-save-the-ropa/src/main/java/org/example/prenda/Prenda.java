package org.example.prenda;

public abstract class Prenda {

    private String codigo;

    private String marca;

    private String modelo;

    public Prenda(String codigo, String marca, String modelo) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
