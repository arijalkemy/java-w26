package org.example.model;

public class Autos extends Vehiculo{
    public Autos(String patente, Double aceleracion, Double anguloDeGiro, Double velocidad) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 4);


    }


    public String getPatente(){
        return this.patente;
    }

}
