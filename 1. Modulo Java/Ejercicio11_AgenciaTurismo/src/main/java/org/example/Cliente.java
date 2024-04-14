package org.example;

public class Cliente {
    private String dni;
    private String nombre;
    private int cantLocalizadores = 0;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setCantLocalizadores(int cantLocalizadores) {
        this.cantLocalizadores = cantLocalizadores;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantLocalizadores() {
        return cantLocalizadores;
    }

    public void aumentarCantidadLocalizadores() {
        this.cantLocalizadores++;
    }
}
