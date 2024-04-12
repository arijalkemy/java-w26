package org.meli.clases;

public class Cliente {
    private Integer dni;
    private String nombre;

    public Cliente(Integer dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente "+nombre+" con DNI "+dni;
    }
}
