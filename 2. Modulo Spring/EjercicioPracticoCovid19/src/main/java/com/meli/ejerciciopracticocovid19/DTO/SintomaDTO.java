package com.meli.ejerciciopracticocovid19.DTO;

public class SintomaDTO {
    private int codigo;
    private String nombre;
    private String nivelDeGravedad;

    public SintomaDTO(int codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }

    @Override
    public String toString() {
        return
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivelDeGravedad='" + nivelDeGravedad + '\'';
    }
}
