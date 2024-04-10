package org.example;

public class Categoria {
    String nombre;
    String descripcion;

    double costoMayores;

    double costoMenores;

    public Categoria(String nombre, String descripcion, double costoMayores, double costoMenores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMayores = costoMayores;
        this.costoMenores =  costoMenores;
    }
}
