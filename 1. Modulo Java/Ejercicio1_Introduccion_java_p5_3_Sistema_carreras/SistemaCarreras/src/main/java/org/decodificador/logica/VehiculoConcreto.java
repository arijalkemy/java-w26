package org.decodificador.logica;

public class VehiculoConcreto extends Vehiculo {
    private String categoria;
    private Double max;

    public VehiculoConcreto(double velocidad, double anguloDeGiro, String patente, double peso,
                            int ruedas, double aceleracion, String categoria) {
        super(velocidad, anguloDeGiro, patente, peso, ruedas, aceleracion);
        this.categoria = categoria;
        this.max = ((velocidad)*0.5*(aceleracion))/(anguloDeGiro*(peso-ruedas*100));
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getMax() {
        return max;
    }

    @Override
    public String toString() {
        return super.toString() +
                "VehiculoConcreto{" +
                ", max=" + max +
                '}';
    }
}
