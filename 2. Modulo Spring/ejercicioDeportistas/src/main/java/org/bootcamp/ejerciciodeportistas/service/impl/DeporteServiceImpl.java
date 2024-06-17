package org.bootcamp.ejerciciodeportistas.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.bootcamp.ejerciciodeportistas.dtos.DeporteDTO;
import org.bootcamp.ejerciciodeportistas.model.Deporte;
import org.bootcamp.ejerciciodeportistas.repository.DeporteRepository;
import org.bootcamp.ejerciciodeportistas.service.DeporteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServiceImpl implements DeporteService {

    private final DeporteRepository deporteRepository;
    private final ObjectMapper objectMapper;

    public DeporteServiceImpl(DeporteRepository deporteRepository, ObjectMapper objectMapper) {
        this.deporteRepository = deporteRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public List<DeporteDTO> obtenerDeportes() {
       return deporteRepository.findAll().stream().map(this::deporteADeporteDTO).toList();
    }

    @Override
    public DeporteDTO obtenerDeportePorNombre(String nombre) {
        return deporteADeporteDTO(deporteRepository.findByNombre(nombre));
    }

    private DeporteDTO deporteADeporteDTO(Deporte deporte) {
        return objectMapper.convertValue(deporte, DeporteDTO.class);
    }
    private Deporte deporteDTOADeporte(DeporteDTO deporteDTO) {
        return objectMapper.convertValue(deporteDTO, Deporte.class);
    }
}



