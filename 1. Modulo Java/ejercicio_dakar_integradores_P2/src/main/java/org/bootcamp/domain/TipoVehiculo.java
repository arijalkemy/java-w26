package org.bootcamp.domain;

public enum TipoVehiculo {

    MOTO(300D, 2),
    CARRO(1000D, 4);


    private Double peso;
    private Integer ruedas;

    TipoVehiculo(Double peso, Integer ruedas) {
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
