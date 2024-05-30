package com.example.showroom.service.implement;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.PrendaResponseDto;
import com.example.showroom.entity.Prenda;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.repository.IPrendaRepository;
import com.example.showroom.service.IPrendaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements IPrendaService {
    IPrendaRepository repository;
    ObjectMapper mapper;

    public PrendaService(IPrendaRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PrendaResponseDto savePrenda(PrendaDto prenda) {
        return convertToPrendaResponseDto(repository.save(convertToPrenda(prenda)));
    }

    @Override
    public List<PrendaResponseDto> getAllPrendas() {
        return repository.findAll().stream()
                .map(this::convertToPrendaResponseDto).toList();
    }

    @Override
    public PrendaResponseDto getPrendaById(Long id) {
        return convertToPrendaResponseDto(repository.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encontro la prenda")));
    }

    @Override
    public PrendaResponseDto updatePrenda(Long id, PrendaDto prenda) {
        Prenda prendaNueva = mapper.convertValue(prenda, Prenda.class);
        prendaNueva.setId(id);
        repository.save(prendaNueva);
        return convertToPrendaResponseDto(prendaNueva);
    }

    @Override
    public String deletePrenda(Long id) {
        repository.deleteById(id);
        return "Se elimino con exito";
    }

    @Override
    public List<PrendaResponseDto> getAllPrendasByTalla(String talla) {
        return repository.findPrendasByTalla(talla).stream()
                .map(this::convertToPrendaResponseDto).toList();
    }

    @Override
    public List<PrendaResponseDto> getAllPrendasByTipo(String tipo) {
        return repository.findPrendasByTipo(tipo).stream()
                .map(this::convertToPrendaResponseDto).toList();
    }

    private Prenda convertToPrenda(PrendaDto prendaDto){
        return mapper.convertValue(prendaDto,Prenda.class);
    }

    private PrendaResponseDto convertToPrendaResponseDto(Prenda prenda){
        return mapper.convertValue(prenda, PrendaResponseDto.class);
    }
}
