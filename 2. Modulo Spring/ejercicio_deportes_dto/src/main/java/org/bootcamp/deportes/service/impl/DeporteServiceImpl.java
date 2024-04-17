package org.bootcamp.deportes.service.impl;

import org.bootcamp.deportes.domain.Deporte;
import org.bootcamp.deportes.domain.Persona;
import org.bootcamp.deportes.mapper.DeporteMapper;
import org.bootcamp.deportes.repository.DeportistaRepository;
import org.bootcamp.deportes.restcontroller.dto.DeporteDTO;
import org.bootcamp.deportes.restcontroller.dto.DeportistasDTO;
import org.bootcamp.deportes.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServiceImpl implements DeporteService {

    private static DeportistaRepository deportistaRepository;

    @Autowired
    private DeporteMapper deporteMapper;

    public DeporteServiceImpl() {
        this.deportistaRepository = new DeportistaRepository();
    }

    public static DeportistaRepository getDeportistaRepository() {
        return deportistaRepository;
    }

    public static void setDeportistaRepository(DeportistaRepository deportistaRepository) {
        DeporteServiceImpl.deportistaRepository = deportistaRepository;
    }

    @Override
    public void guardarDeportistas(Deporte deporte, List<Persona> personas) {
        if(deporte != null && !personas.isEmpty()){
            this.deportistaRepository.guardarDeportistas(deporte, personas);
        }
    }

    @Override
    public List<Deporte> obtenerDeportes() {
        return this.deportistaRepository.obtenerDeportes();
    }

    @Override
    public DeporteDTO obtenerNivelPorNombreDeporte(String nombreDeporte) {
        return deporteMapper.deporteADeporteDTO(
                this.deportistaRepository.obtenerNivelPorNombreDeporte(nombreDeporte));
    }

    @Override
    public List<DeportistasDTO> obtenerPersonasPorDeporte() {
        return deporteMapper.mapDeportistaADeporteDTOLista(
                this.deportistaRepository.obtenerPersonasPorDeporte());
    }

}
