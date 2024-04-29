package org.bootcamp.domain;

public enum TipoVehiculo {

    MOTO(300D, 2),
    CARRO(1000D, 4);

    public static final Integer RUEDAS_MOTO = 2;
    public static final Integer RUEDAS_CARRO = 4;



    private Double peso;
    private Integer ruedas;

    TipoVehiculo(Double peso, Integer ruedas) {
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    @Override
    public String toString() {
        return  "TipoVehiculo{" + "peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
