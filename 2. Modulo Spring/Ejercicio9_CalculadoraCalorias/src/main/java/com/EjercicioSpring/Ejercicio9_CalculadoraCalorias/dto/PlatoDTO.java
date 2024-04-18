package com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.dto;

import java.io.Serializable;
import java.util.List;

public class PlatoDTO implements Serializable {
    private String nombre;
    private Integer totalCalorias;
    private IngredienteDTO ingredienteMayorCalorias;
    private Integer gramos;
    private List<IngredienteDTO> ingredientes;

    public PlatoDTO(String nombre, Integer totalCalorias, IngredienteDTO ingredienteMayorCalorias, Integer gramos, List<IngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.totalCalorias = totalCalorias;
        this.ingredienteMayorCalorias = ingredienteMayorCalorias;
        this.gramos = gramos;
        this.ingredientes = ingredientes;
    }

    public PlatoDTO(String nombre, Integer gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Integer totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public IngredienteDTO getIngredienteMayorCalorias() {
        return ingredienteMayorCalorias;
    }

    public void setIngredienteMayorCalorias(IngredienteDTO ingredienteMayorCalorias) {
        this.ingredienteMayorCalorias = ingredienteMayorCalorias;
    }

    public Integer getGramos() {
        return gramos;
    }

    public void setGramos(Integer gramos) {
        this.gramos = gramos;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void actualizarTotal() {
        this.totalCalorias = 0;
        for (IngredienteDTO ingredienteDTO : ingredientes) {
            totalCalorias += ingredienteDTO.getCalorias();
        }
        totalCalorias *= (gramos / 100);
    }

    public void actualizarIngreMayorCalorias() {
        this.ingredienteMayorCalorias = ingredientes.get(0);
        for (IngredienteDTO ingredienteDTO : ingredientes) {
            if (ingredienteDTO.getCalorias() > this.ingredienteMayorCalorias.getCalorias()){
                this.ingredienteMayorCalorias = ingredienteDTO;
            }
        }
    }
}