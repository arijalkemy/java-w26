package com.meli.obras_literarias_VIVO.service.impl;

import com.meli.obras_literarias_VIVO.dtos.RequestObraDto;
import com.meli.obras_literarias_VIVO.dtos.ResponseObraDto;
import com.meli.obras_literarias_VIVO.entities.Obra;
import com.meli.obras_literarias_VIVO.repository.ObraRepository;
import com.meli.obras_literarias_VIVO.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ObraServiceImpl implements ObraService {
    private final ObraRepository obraRepository;
    @Override
    public String guardObras(List<RequestObraDto> obras) {
        List<Obra> obrasList = obras.stream().map(o -> Obra.builder()
                .autor(o.getAutor())
                .nombre(o.getNombre())
                .año(o.getAño())
                .cantidadDePaginas(o.getCantidadDePaginas())
                .editorial(o.getEditorial())
                .build())
                .toList();
        obraRepository.saveAll(obrasList);
        return "Obra guardada correctamente!";
    }

    @Override
    public List<ResponseObraDto> getObras() {
        return obraRepository.findAll()
                .stream()
                .map(this::parseToDto)
                .toList();
    }

    @Override
    public List<ResponseObraDto> getByAutor(String autor) {
        return obraRepository.findByAutor(autor)
                .stream()
                .map(this::parseToDto)
                .toList();
    }

    @Override
    public List<ResponseObraDto> getObrasByTitulo(String titulo) {
        return obraRepository.findByNombre(titulo)
                .stream()
                .map(this::parseToDto)
                .toList();
    }

    @Override
    public List<ResponseObraDto> getTopFiveByPages() {
        return obraRepository.findTop5ByOrderByCantidadDePaginasDesc()
                .stream()
                .map(this::parseToDto)
                .toList();
    }

    @Override
    public List<ResponseObraDto> getAfterAge(Integer age) {
        return obraRepository.findByAñoGreaterThan(age)
                .stream()
                .map(this::parseToDto)
                .toList();
    }

    private ResponseObraDto parseToDto(Obra o) {
        return ResponseObraDto
                .builder()
                .nombre(o.getNombre())
                .autor(o.getAutor())
                .año(o.getAño())
                .cantidadDePaginas(o.getCantidadDePaginas())
                .editorial(o.getEditorial())
                .id(o.getId())
                .build();
    }
}
