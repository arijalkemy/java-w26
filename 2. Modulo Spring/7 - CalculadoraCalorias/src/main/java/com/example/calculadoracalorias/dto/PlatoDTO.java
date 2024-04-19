package com.example.calculadoracalorias.dto;

import java.util.List;

public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteMaxCalorias;
    private int CantidadCalorias;

    public PlatoDTO(String nombre, List<IngredienteDTO> ingredientes, IngredienteDTO ingredienteMaxCalorias, int cantidadCalorias) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.ingredienteMaxCalorias = ingredienteMaxCalorias;
        CantidadCalorias = cantidadCalorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public IngredienteDTO getIngredienteMaxCalorias() {
        return ingredienteMaxCalorias;
    }

    public void setIngredienteMaxCalorias(IngredienteDTO ingredienteMaxCalorias) {
        this.ingredienteMaxCalorias = ingredienteMaxCalorias;
    }

    public int getCantidadCalorias() {
        return CantidadCalorias;
    }

    public void setCantidadCalorias(int cantidadCalorias) {
        CantidadCalorias = cantidadCalorias;
    }
}
