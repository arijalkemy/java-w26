package org.entities;

import java.util.UUID;

public class Prenda {
    private UUID id;
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.id = UUID.randomUUID();
        this.marca = marca;
        this.modelo = modelo;
    }

    public UUID getId() {
        return id;
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

    @Override
    public String toString() {
        return "Prenda{" +
                "id=" + id + '\n'+
                ", marca='" + marca + '\'' + '\n'+
                ", modelo='" + modelo + '\'' +
                '}' + "\n\n";
    }
}
