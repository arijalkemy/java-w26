package org.example.clases;

public class Prenda {
    private String tipo;
    private String Marca;
    private String modelo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Prenda(String tipo, String marca, String modelo) {
        this.tipo = tipo;
        Marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "tipo='" + tipo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
