package org.example.classes;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Integer edadMinima;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(int id, String nombre, String descripcion, int edadMinima) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edadMinima = edadMinima;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }
}

