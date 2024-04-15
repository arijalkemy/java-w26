package org.example;

public class Categoria {
    private String nombre;
    private String descripcion;
    private double montoInscripcionMenorA18;
    private double montoInscripcionMayorA18;

    public Categoria(String nombre, String descripcion, double montoInscripcionMenorA18, double montoInscripcionMayorA18) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoInscripcionMayorA18 = montoInscripcionMayorA18;
        this.montoInscripcionMenorA18 = montoInscripcionMenorA18;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getMontoInscripcionMenorA18() {
        return this.montoInscripcionMenorA18;
    }

    public double getMontoInscripcionMayorA18() {
        return this.montoInscripcionMayorA18;
    }


}
