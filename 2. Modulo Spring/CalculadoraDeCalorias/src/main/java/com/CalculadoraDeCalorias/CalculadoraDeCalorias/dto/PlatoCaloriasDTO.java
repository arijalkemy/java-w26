package com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto;

public class PlatoCaloriasDTO {
    private Integer calorias;

    public PlatoCaloriasDTO(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }
}
