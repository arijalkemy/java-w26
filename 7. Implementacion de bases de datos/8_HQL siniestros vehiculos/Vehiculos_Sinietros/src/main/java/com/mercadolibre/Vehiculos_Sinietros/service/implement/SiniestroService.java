package com.mercadolibre.Vehiculos_Sinietros.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.SiniestroRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.SiniestroResponseDto;
import com.mercadolibre.Vehiculos_Sinietros.model.entity.Siniestro;
import com.mercadolibre.Vehiculos_Sinietros.repository.ISiniestroRepository;
import com.mercadolibre.Vehiculos_Sinietros.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ISiniestroRepository siniestroRepository;

    @Override
    public SiniestroResponseDto saveSiniestro(SiniestroRequestDto siniestro) {
        return convertToSiniestroResponseDto(
                siniestroRepository.save(convertToSiniestro(siniestro)));
    }

    @Override
    public List<SiniestroResponseDto> getAllSiniestro() {
        return siniestroRepository.findAll().stream()
                .map(this::convertToSiniestroResponseDto).toList();
    }

    @Override
    public SiniestroResponseDto getSiniestroById(Long id) {
        return convertToSiniestroResponseDto(siniestroRepository.findById(id).orElse(null));
    }
    private Siniestro convertToSiniestro(SiniestroRequestDto siniestro){
        return mapper.convertValue(siniestro,Siniestro.class);
    }
    private SiniestroResponseDto convertToSiniestroResponseDto(Siniestro siniestro){
        return mapper.convertValue(siniestro,SiniestroResponseDto.class);
    }
}
