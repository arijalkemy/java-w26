package com.obrasliterariaseelastic.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obrasliterariaseelastic.DTOs.ObraLiterariaRequestDTO;
import com.obrasliterariaseelastic.models.ObraLiteraria;
import com.obrasliterariaseelastic.repositories.IObraLiterariaRepository;
import com.obrasliterariaseelastic.services.IObraLiterariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<ObraLiteraria> guardarTodos(List<ObraLiterariaRequestDTO> obras) {
        List<ObraLiteraria> obraLiterarias = (List<ObraLiteraria>) this.obraLiterariaRepository.saveAll(obras.stream().map(
                o -> objectMapper.convertValue(o, ObraLiteraria.class)
        ).toList());

        return obraLiterarias;
    }

    @Override
    public List<ObraLiteraria> getObrasByAutor(String autor) {
        return this.obraLiterariaRepository.findByAutor(autor);
    }

    @Override
    public List<ObraLiteraria> getObrasConPalabrasClaveEnElTitulo(String titulo) {
        return this.obraLiterariaRepository.findByTitleContaining(titulo);
    }

    @Override
    public List<ObraLiteraria> getTop5ConMasPaginas() {
        return this.obraLiterariaRepository.findTop5ByOrderByCantPaginasDesc();
    }

    @Override
    public List<ObraLiteraria> getObrasAntesDe(Integer anio) {
        return this.obraLiterariaRepository.findByAnioPublicacionBefore(anio);
    }

    @Override
    public List<ObraLiteraria> getObrasByEditorial(String editorial) {
        return this.obraLiterariaRepository.findByEditorial(editorial);
    }
}
