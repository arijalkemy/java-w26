package org.example.clases;

import java.util.function.Function;

public class Categoria {

    private final int id;
    private final String nombre;
    private final String descripcion;
    // Con lo siguiente se termina implementado un poliformismo "trucho", pero
    // no quería complicar la solución con una jerarquía de clases.
    // TODO Ver si se puede reemplazar esto por dos atributos, precioMenorDeEdad y precioMayordeEdad
    private final Function<Participante, Double> calculadorMontoInscripcion;


    public Categoria(int id, String nombre, String descripcion, Function<Participante, Double> calculadorMontoInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calculadorMontoInscripcion = calculadorMontoInscripcion;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double calcularMontoInscripcion(Participante participante) {
        return calculadorMontoInscripcion.apply(participante);
    }
}
