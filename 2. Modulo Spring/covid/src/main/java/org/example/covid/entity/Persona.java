package org.example.covid.entity;

public class Persona {
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {
    }

    public Persona(Integer idPersona, String nombre, String apellido, int edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
