package org.example.models;

public class Cliente {
    private Long dni;
    private String nombre;
    private String apellido;

    public Cliente(Long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public Long getDni() {
        return dni;
    }
}
