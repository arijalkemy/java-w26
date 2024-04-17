package com.mercadolibre.calorias.dto;

import com.mercadolibre.calorias.model.Ingrediente;

import java.util.Comparator;
import java.util.List;

public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteMaxCalorias;
    private int CantidadCalorias;

    public PlatoDTO(String nombre, List<IngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.ingredienteMaxCalorias = ingredientes.stream().max(Comparator.comparingInt(IngredienteDTO::getCalorias)).orElse(null);
        this.CantidadCalorias = ingredientes.stream().mapToInt(c-> c.getCalorias()).sum();
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
