package com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto;

public class PlatoIngredientesDTO {
    private String nombre;
    private Integer calorias;

    public PlatoIngredientesDTO(String nombre, Integer calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }
}
