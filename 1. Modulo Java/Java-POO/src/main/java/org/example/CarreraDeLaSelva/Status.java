package org.example.CarreraDeLaSelva;

public enum Status {

    ACCEPTED("ACCEPTED"),
    DENIED("DENIED");

    private final String value;

    Status(String valor) {
        this.value = valor;
    }

    public String getValue() {
        return value;
    }
}
