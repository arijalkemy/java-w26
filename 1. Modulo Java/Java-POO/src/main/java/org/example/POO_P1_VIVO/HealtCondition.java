package org.example.POO_P1_VIVO;

public enum HealtCondition {

    UNDER_WEIGHT("Bajo Peso"),
    HEALTHY("Peso Saludable"),
    OVERWEIGHT("Sobrepeso"),
    UNDEFINED("UNDEFINED");

    private final String value;

    HealtCondition(String valor) {
        this.value = valor;
    }

    public String getValue() {
        return value;
    }

}
