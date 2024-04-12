package org.bootcamp.domain;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    public Categoria(){}

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
        final StringBuffer sb = new StringBuffer("\n--- Categoria ---\n");
        sb.append("\nID: ").append(id);
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nDescripción: ").append(descripcion);
        return sb.toString();
    }
}
