package com.ejercicio.covid19.services.interfaces;

import com.ejercicio.covid19.DTOs.RiskPersonResponseDTO;

import java.util.List;

public interface IPersonsService {
    public List<RiskPersonResponseDTO> getRiskPersons();
}
