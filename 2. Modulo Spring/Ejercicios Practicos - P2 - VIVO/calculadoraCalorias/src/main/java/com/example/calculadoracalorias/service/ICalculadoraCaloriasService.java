package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.DTO.PlatoRensposeDTO;

public interface ICalculadoraCaloriasService {
    PlatoRensposeDTO calcularCalorias (String nombrePlato);

}
