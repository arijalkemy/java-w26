package org.example.clases;

public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private RolDePersona rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public RolDePersona getRol() {
        return rol;
    }

    public void setRol(RolDePersona rol) {
        this.rol = rol;
    }

    public Persona(String nombre, String apellido, int dni, RolDePersona rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.rol = rol;
    }
}
