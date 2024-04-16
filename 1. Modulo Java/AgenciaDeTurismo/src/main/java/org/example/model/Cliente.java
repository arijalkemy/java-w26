package org.example.model;

public class Cliente {

    public Cliente(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    private Long id;
    private String nombre;

    @Override
    public String toString() {
        return "id= " + id + " nombre= " + nombre;
    }
}
