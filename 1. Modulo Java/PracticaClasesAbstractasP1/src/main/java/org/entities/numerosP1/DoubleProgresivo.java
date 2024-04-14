package org.entities.numerosP1;

public class DoubleProgresivo extends ClasePrototipo<Double>{
    public DoubleProgresivo(Double inicioSerie) {
        super(inicioSerie);
    }

    @Override
    public Double siguienteNumero() {
        setActual(getActual()+getInicioSerie());
        return getActual();
    }
}
