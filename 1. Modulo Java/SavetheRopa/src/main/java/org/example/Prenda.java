package org.example;

public class Prenda {
    String marca;
    String modelo;
    int id;

public Prenda(String marca, String modelo, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
