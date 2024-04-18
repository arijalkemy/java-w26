package com.meli.covid19.dto;

public class SintomaDTO {

    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public SintomaDTO(int codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public SintomaDTO() {
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

    public int getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(int nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo +" nombre= '" + nombre + '\'' + ", nivel_de_gravedad= " + nivel_de_gravedad;
    }
}
