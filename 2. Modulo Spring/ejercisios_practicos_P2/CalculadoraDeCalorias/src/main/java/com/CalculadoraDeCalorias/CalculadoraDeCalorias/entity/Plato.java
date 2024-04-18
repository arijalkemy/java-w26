package com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity;

import java.util.List;

public class Plato {
    private String nombre;
    private List<Ingredientes> listaIngredientes;

    private Integer peso;

    public Plato(String nombre, List<Ingredientes> listaIngredientes,Integer peso) {
        this.nombre = nombre;
        this.listaIngredientes = listaIngredientes;
        this.peso = peso;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ingredientes> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<Ingredientes> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }
}
