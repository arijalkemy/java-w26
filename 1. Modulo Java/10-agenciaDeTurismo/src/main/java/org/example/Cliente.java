package org.example;

public class Cliente {

    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String apellido, String nombre) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public boolean tieneDosLocalizadores() {
        return true;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
