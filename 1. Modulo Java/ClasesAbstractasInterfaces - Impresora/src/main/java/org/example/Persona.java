package org.example;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private List<String> habilidades = new ArrayList();

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Persona(String nombre, String apellido, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return
                "\nNombre='" + nombre + '\'' +
                "\n Apellido='" + apellido + '\'' +
                "\n Dni='" + dni + '\'' +
                "\n Habilidades=" + habilidades;
    }
}
