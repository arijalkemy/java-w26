package org.bootcamp;

public class Cliente {
    private int dni;
    private String nombre;
    private int celular;


    public Cliente(int dni, String nombre, int celular) {
        this.dni = dni;
        this.nombre = nombre;
        this.celular = celular;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", celular=" + celular +
                '}';
    }
}
