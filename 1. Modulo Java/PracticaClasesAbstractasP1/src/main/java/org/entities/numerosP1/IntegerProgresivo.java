package org.entities.numerosP1;

public class IntegerProgresivo extends ClasePrototipo<Integer> {

    public IntegerProgresivo(Integer inicioSerie) {
        super(inicioSerie);
    }

    @Override
    public Integer siguienteNumero() {
        setActual(getActual()+getInicioSerie());
        return getActual();
    }
}
