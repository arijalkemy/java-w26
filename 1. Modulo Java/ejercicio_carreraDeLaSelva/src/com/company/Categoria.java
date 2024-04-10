package com.company;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean admiteMenores;

    public Categoria(int id, String nombre, String descripcion, boolean admiteMenores) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.admiteMenores = admiteMenores;
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

    public boolean isAdmiteMenores() {
        return admiteMenores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAdmiteMenores(boolean admiteMenores) {
        this.admiteMenores = admiteMenores;
    }
}
