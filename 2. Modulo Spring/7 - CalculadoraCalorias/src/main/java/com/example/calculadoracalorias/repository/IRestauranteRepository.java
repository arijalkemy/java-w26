package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Ingrediente;
import com.example.calculadoracalorias.model.Plato;

import java.util.List;

public interface IRestauranteRepository{
    public List<Ingrediente> verIngredientes();
    public List<Plato> verPlatos();
    public Plato verPlato(String nombre);
}
