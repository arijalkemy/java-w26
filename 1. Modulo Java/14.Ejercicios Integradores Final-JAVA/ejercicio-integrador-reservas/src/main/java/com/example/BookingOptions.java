package com.example;

public enum BookingOptions {
    HOTEL("hotel"),
    TICKET("boleto"),
    TRANSPORT("transporte"),
    FOOD("comida");

    private final String text;

    BookingOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
