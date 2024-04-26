package com.calculadora.calorias.Entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Plato {

    private String nombre;

    private List<Ingrediente> ingredientes = new ArrayList<>();

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    public String getName() {
        return this.nombre;
    }

    public int getCantidadDeIngredientes(){ return this.ingredientes.size();}

    public long getCantidadDeCalorias() { return this.ingredientes.stream().mapToLong(p -> p.getCalories()).sum();}

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Optional<Ingrediente> getIngredienteMasCalorias(){ return this.ingredientes.stream().max(Comparator.comparingLong(Ingrediente::getCalories));}

    public void addIngrediente(Ingrediente ingrediente) {ingredientes.add(ingrediente);}
}
