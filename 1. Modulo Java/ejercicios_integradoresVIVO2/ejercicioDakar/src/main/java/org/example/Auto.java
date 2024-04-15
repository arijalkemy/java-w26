package org.example;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public double getVelocidad() {
        return super.getVelocidad();
    }

    @Override
    public void setVelocidad(double velocidad) {
        super.setVelocidad(velocidad);
    }

    @Override
    public double getAceleracion() {
        return super.getAceleracion();
    }

    @Override
    public void setAceleracion(double aceleracion) {
        super.setAceleracion(aceleracion);
    }

    @Override
    public double getAnguloDeGiro() {
        return super.getAnguloDeGiro();
    }

    @Override
    public void setAnguloDeGiro(double anguloDeGiro) {
        super.setAnguloDeGiro(anguloDeGiro);
    }

    @Override
    public String getPatente() {
        return super.getPatente();
    }

    @Override
    public void setPatente(String patente) {
        super.setPatente(patente);
    }

    @Override
    public double getPeso() {
        return super.getPeso();
    }

    @Override
    public void setPeso(double peso) {
        super.setPeso(peso);
    }

    @Override
    public int getRuedas() {
        return super.getRuedas();
    }

    @Override
    public void setRuedas(int ruedas) {
        super.setRuedas(ruedas);
    }
}
