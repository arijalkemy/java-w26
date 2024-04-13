package com.meli;

/**
 * Representa una moto, que es un tipo de vehículo.
 */
public class Moto extends Vehiculo{

    /**
     * Construye una nueva instancia de Moto.
     *
     * @param velocidad La velocidad de la moto.
     * @param aceleracion La aceleración de la moto.
     * @param anguloDeGiro El ángulo de giro de la moto.
     * @param patente La patente de la moto.
     */
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }
}