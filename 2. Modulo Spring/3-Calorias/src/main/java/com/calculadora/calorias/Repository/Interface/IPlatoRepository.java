package com.calculadora.calorias.Repository.Interface;

import com.calculadora.calorias.Entity.Plato;

import java.util.Optional;

public interface IPlatoRepository {

    Optional<Plato> getByName(String name);
}
