package modelo;

import interfaces.TipoDeVuelo;

public class VueloDirecto implements TipoDeVuelo {

    private double duracion;


    public VueloDirecto(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public double getDuracion() {
        return duracion;
    }
}
