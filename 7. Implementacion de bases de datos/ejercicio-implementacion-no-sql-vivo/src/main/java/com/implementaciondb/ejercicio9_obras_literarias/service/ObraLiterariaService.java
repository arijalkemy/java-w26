package com.implementaciondb.ejercicio9_obras_literarias.service;


import com.implementaciondb.ejercicio9_obras_literarias.exception.NotFoundException;
import com.implementaciondb.ejercicio9_obras_literarias.mapper.ObraLiterariaMapper;
import com.implementaciondb.ejercicio9_obras_literarias.model.domain.ObraLiteraria;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaRequestDto;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaResponseDto;
import com.implementaciondb.ejercicio9_obras_literarias.repository.IObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    @Override
    public ObraLiterariaResponseDto saveObraLiteraria(ObraLiterariaRequestDto obraLiterariaRequestDto) {
        ObraLiteraria obraLiteraria = obraLiterariaRepository.save(ObraLiterariaMapper.mapToObraLiteraria(obraLiterariaRequestDto));
        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(obraLiteraria);
    }

    @Override
    public List<ObraLiterariaResponseDto> searchAllObrasLiterarias() {
        Iterable<ObraLiteraria> iterable = obraLiterariaRepository.findAll();
        List<ObraLiteraria> obraLiterarias = StreamSupport.stream(iterable.spliterator(), false).toList();
        return obraLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public ObraLiterariaResponseDto searchObraLiterariaById(String id) {
        ObraLiteraria obraLiteraria = obraLiterariaRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe un documento con el id: " + id));
        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(obraLiteraria);
    }

    @Override
    public ObraLiterariaResponseDto updateObraLiteraria(String id, ObraLiterariaRequestDto obraLiterariaRequestDto) {
        searchObraLiterariaById(id);

        ObraLiteraria obraLiteraria = ObraLiterariaMapper.mapToObraLiteraria(obraLiterariaRequestDto);
        obraLiteraria.setId(id);
        obraLiteraria = obraLiterariaRepository.save(obraLiteraria);

        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(obraLiteraria);
    }

    @Override
    public List<ObraLiterariaResponseDto> searchObrasLiterariasByAuthor(String author) {
        List<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findAllByAuthor(author);
        return obrasLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> searchObrasLiterariasByTitleKeyword(String keyword) {
        List<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findAllByKeyWordFromTitle(keyword);
        return obrasLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> searchObrasLiterariasByPagesNumber() {
        List<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findTop5ByOrderByNumberPagesDesc();
        return obrasLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> searchObrasLiterariasByYearPublicationBefore(Integer year) {
        List<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findByYearPublicationBefore(year);
        return obrasLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> searchObrasLiterariasByEditorial(String editorial) {
        List<ObraLiteraria> obrasLiterarias = obraLiterariaRepository.findAllByEditoria(editorial);
        return obrasLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }
}
