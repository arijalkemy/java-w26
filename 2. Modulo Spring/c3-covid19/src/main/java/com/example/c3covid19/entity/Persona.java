package com.example.c3covid19.entity;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;

    public int getId() {
        return id;
    }

    public Persona setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Persona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Persona setEdad(int edad) {
        this.edad = edad;
        return this;
    }
}
