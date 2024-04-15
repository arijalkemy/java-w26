package org.example.clases;

public class Avion {
    private String marca;
    private String modelo;
    private int cantidadTotalDePrimeraClase;
    private int cantidadTotalDeClaseTurismo;

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

    public int getCantidadTotalDePrimeraClase() {
        return cantidadTotalDePrimeraClase;
    }

    public void setCantidadTotalDePrimeraClase(int cantidadTotalDePrimeraClase) {
        this.cantidadTotalDePrimeraClase = cantidadTotalDePrimeraClase;
    }

    public int getCantidadTotalDeClaseTurismo() {
        return cantidadTotalDeClaseTurismo;
    }

    public void setCantidadTotalDeClaseTurismo(int cantidadTotalDeClaseTurismo) {
        this.cantidadTotalDeClaseTurismo = cantidadTotalDeClaseTurismo;
    }

    public Avion(String marca, String modelo, int cantidadTotalDePrimeraClase, int cantidadTotalDeClaseTurismo) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadTotalDePrimeraClase = cantidadTotalDePrimeraClase;
        this.cantidadTotalDeClaseTurismo = cantidadTotalDeClaseTurismo;
    }
}
