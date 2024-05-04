package com.calculadora.calorias.repository;

import com.calculadora.calorias.dto.PlatilloDTO;
import com.calculadora.calorias.entity.Ingrediente;
import com.calculadora.calorias.entity.Platillo;

import java.util.List;

public interface IIngredienteRepository {
    void getIngredientes();
    void getPlatillos();
    List<Ingrediente> getTodos();
    List<Platillo> getTodosPlatillo();
}
