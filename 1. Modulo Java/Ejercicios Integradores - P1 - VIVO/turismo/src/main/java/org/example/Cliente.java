package org.example;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private int descuento;

    public Cliente() {
    }

    public Cliente(String nome, String apellido, String dni) {
        this.nombre = nome;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNome() {
        return nombre;
    }

    public void setNome(String nome) {
        this.nombre = nome;
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
}
