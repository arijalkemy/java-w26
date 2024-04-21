package com.example.demo.repository;

import com.example.demo.entity.Ingrediente;
import com.example.demo.entity.Plato;

import java.util.List;

public interface IPlatoRepository {


    List<Ingrediente> obtenerIngredientes();
    List<Plato> obtenerPlatos();
}
