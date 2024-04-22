package org.example;

class Auto extends Vehiculo {
    public Auto(String patente, double velocidad, double acelaracion, double anguloDeGiro) {
        super(velocidad, acelaracion, anguloDeGiro, patente, 1000, 4);
    }
}