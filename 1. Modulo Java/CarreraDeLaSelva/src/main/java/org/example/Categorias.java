package org.example;

public class Categorias {
    private String nombre;
    private String descripcion;
    private int edad;

    public Categorias() {
    }

    public Categorias(String nombre, String descripcion, int edad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", edad=" + edad +
                '}';
    }
}
