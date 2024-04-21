package org.example.calculadora_calorias.repository;

import org.example.calculadora_calorias.model.Plate;

import java.util.*;

public interface IPlateRepository {
    public List<Plate> findAll();
    public Plate findByName(String name);
}
