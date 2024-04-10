package org.example.Clases;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    
    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  "  Categoria:" + "\n" +
                "    Nombre: " + nombre + "\n" +
                "    Descripción: " + descripcion + "\n";
    }
}
