package org.bootcamp;

public class Cliente {
    private int dni;
    private String nombre;
    private String celular;
    private boolean tieneDescuentoCincoPorCiento;

    public Cliente(int dni, String nombre, String celular) {
        this.dni = dni;
        this.nombre = nombre;
        this.celular = celular;
        this.tieneDescuentoCincoPorCiento = false;
    }

    @Override
    public String toString() {
        return "Cliente DNI: " + dni + ", Nombre: " + nombre + ", Celular: " + celular;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean getTieneDescuentoCincoPorCiento() {
        return tieneDescuentoCincoPorCiento;
    }

    public void setTieneDescuentoCincoPorCiento(boolean tieneDescuentoCincoPorCiento) {
        this.tieneDescuentoCincoPorCiento = tieneDescuentoCincoPorCiento;
    }
}
