package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository;

import java.util.List;

public interface IPlatoRepository {
    public List<String> findIngredientes(String nombre);
}
