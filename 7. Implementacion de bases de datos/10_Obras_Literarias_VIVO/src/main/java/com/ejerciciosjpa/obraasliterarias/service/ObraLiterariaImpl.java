package com.ejerciciosjpa.obraasliterarias.service;

import com.ejerciciosjpa.obraasliterarias.domain.ObraLiteraria;
import com.ejerciciosjpa.obraasliterarias.dto.RequestObraLiterariaDto;
import com.ejerciciosjpa.obraasliterarias.dto.ResponseObraLiterariaDto;
import com.ejerciciosjpa.obraasliterarias.repository.IObraLiterariaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ObraLiterariaImpl implements IObraLiterariaService{
    @Autowired
    IObraLiterariaRepository obraRepository;

    @Override
    public ResponseObraLiterariaDto create(RequestObraLiterariaDto request) {
        ModelMapper mapper = new ModelMapper();
        ObraLiteraria obraToSave = mapper.map(request, ObraLiteraria.class);
        obraRepository.save(obraToSave);
        return mapper.map(obraToSave,ResponseObraLiterariaDto.class);
    }

    @Override
    public List<ObraLiteraria> findAll() {
        return obraRepository.findAll();
    }

    @Override
    public List<ResponseObraLiterariaDto> findObraById(String nombre) {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.findAllByAutor(nombre).stream().map(e->mapper.map(e, ResponseObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ResponseObraLiterariaDto> findObraByClave(String clave) {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.findAllByNombre(clave).stream().map(e->mapper.map(e,ResponseObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ResponseObraLiterariaDto> findTopObrasByLength() {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.findTop5ByOrderByCantidadDePaginasDesc().stream().map(e->mapper.map(e,ResponseObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ResponseObraLiterariaDto> findObrasBefore(Integer year) {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.findAllByPrimeraPublicacionIsLessThan(year).stream().map(e->mapper.map(e,ResponseObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ResponseObraLiterariaDto> findObrasByEditorial(String editorial) {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.findAllByEditorial(editorial).stream().map(e->mapper.map(e, ResponseObraLiterariaDto.class)).toList();
    }
}
