package com.meli.ejercicioenvivodto.Repository.DTO;

public class DeporteDTO {

    private String nombre;
    private String nivel;

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return " \n" + "{" + "Nombre: "+ nombre + " Intensidad: "+nivel + "}" + " \n";
    }
}
