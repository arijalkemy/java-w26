package org.bootcamp.ejerciciodeportistas.service.impl;

import org.bootcamp.ejerciciodeportistas.dtos.DeportePorPersonaDTO;
import org.bootcamp.ejerciciodeportistas.model.DeportePorPersona;
import org.bootcamp.ejerciciodeportistas.model.Persona;
import org.bootcamp.ejerciciodeportistas.repository.DeportePorPersonaRepository;
import org.bootcamp.ejerciciodeportistas.service.DeportePorPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeportePorPersonaServiceImpl implements DeportePorPersonaService {

    private DeportePorPersonaRepository deportePorPersonaRepository;

    public DeportePorPersonaServiceImpl(DeportePorPersonaRepository deportePorPersonaRepository) {
        this.deportePorPersonaRepository = deportePorPersonaRepository;
    }



    @Override
    public void buscarDeportesPorPersona() {
        List<DeportePorPersona> deportePorPersonas = obtenerDeportesPorPersona();
        List<DeportePorPersonaDTO> deportePorPersonaDTOs = new ArrayList<>();
        List<DeportePorPersona> deportesPorPersona = deportePorPersonaRepository.findAll();
        Map<Persona, List<DeportePorPersona>> deportesFiltrados= deportesPorPersona.stream().collect(Collectors.groupingBy(DeportePorPersona::getPersona));

    }

    private List<DeportePorPersona> obtenerDeportesPorPersona() {
        return deportePorPersonaRepository.findAll();
    }
}
