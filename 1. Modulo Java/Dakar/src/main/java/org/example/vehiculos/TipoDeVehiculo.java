package org.example.vehiculos;

public class TipoDeVehiculo {

    private String nombre;
    private Double peso;
    private Integer ruedas;

    public TipoDeVehiculo(String nombre, Double peso, Integer ruedas) {
        this.nombre = nombre;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }
}
