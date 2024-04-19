package com.example.calculadoracalorias.dto;

public class IngredienteDTO {
    private String nombre;
    private int calorias;

    public IngredienteDTO(String nombre, int calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public IngredienteDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
