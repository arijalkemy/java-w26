package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto;

import java.util.List;

public class InformacionPlatoResponseDto {
    private double cantidadTotalCalorias;
    private List<IngredienteDto> ingredientes;
    private IngredienteDto ingredienteConMasCalorias;

    public InformacionPlatoResponseDto() {}

    public InformacionPlatoResponseDto(double cantidadTotalCalorias, List<IngredienteDto> ingredientes, IngredienteDto ingredienteConMasCalorias) {
        this.cantidadTotalCalorias = cantidadTotalCalorias;
        this.ingredientes = ingredientes;
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
    }

    public double getCantidadTotalCalorias() {
        return cantidadTotalCalorias;
    }

    public void setCantidadTotalCalorias(double cantidadTotalCalorias) {
        this.cantidadTotalCalorias = cantidadTotalCalorias;
    }

    public List<IngredienteDto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public IngredienteDto getIngredienteConMasCalorias() {
        return ingredienteConMasCalorias;
    }

    public void setIngredienteConMasCalorias(IngredienteDto ingredienteConMasCalorias) {
        this.ingredienteConMasCalorias = ingredienteConMasCalorias;
    }
}
