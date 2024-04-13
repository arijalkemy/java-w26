package com.meli;

/**
 * Representa un auto, que es un tipo de vehículo.
 */
public class Auto extends Vehiculo {

    /**
     * Construye una nueva instancia de Auto.
     *
     * @param velocidad La velocidad del auto.
     * @param aceleracion La aceleración del auto.
     * @param anguloDeGiro El ángulo de giro del auto.
     * @param patente La patente del auto.
     */
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

}