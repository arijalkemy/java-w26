package com.example._6_persona_practicatestyvalidaciones.service;

import com.example._6_persona_practicatestyvalidaciones.dto.requestDTO.DeporteRequestDTO;
import com.example._6_persona_practicatestyvalidaciones.dto.responseDTO.DeporteResponseDTO;
import com.example._6_persona_practicatestyvalidaciones.model.Deporte;
import com.example._6_persona_practicatestyvalidaciones.repository.IDeporteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class DeporteService implements IDeporteService{
    @Autowired
    IDeporteRepository repository;

    @Override
    public DeporteResponseDTO agregarDeporte(@Valid DeporteRequestDTO deporteRequestDTO) {
        ObjectMapper mapper = new ObjectMapper();

        Deporte deporte = mapper.convertValue(deporteRequestDTO, Deporte.class);

        return mapper.convertValue(repository.save(deporte),
                DeporteResponseDTO.class);
    }
}
