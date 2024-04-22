package org.example.enums;

public enum VehiclesEnum {

    AUTO(1000.00, 4),
    MOTO(300.00, 2);

    private final Double peso;
    private final Integer ruedas;

    VehiclesEnum(Double peso, Integer ruedas) {
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }
}
