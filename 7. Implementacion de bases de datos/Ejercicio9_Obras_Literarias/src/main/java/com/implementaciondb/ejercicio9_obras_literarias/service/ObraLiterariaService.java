package com.implementaciondb.ejercicio9_obras_literarias.service;


import com.implementaciondb.ejercicio9_obras_literarias.exception.NotFoundException;
import com.implementaciondb.ejercicio9_obras_literarias.mapper.ObraLiterariaMapper;
import com.implementaciondb.ejercicio9_obras_literarias.model.domain.ObraLiteraria;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaRequestDto;
import com.implementaciondb.ejercicio9_obras_literarias.model.dto.ObraLiterariaResponseDto;
import com.implementaciondb.ejercicio9_obras_literarias.repository.IObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    @Override
    public ObraLiterariaResponseDto saveObraLiteraria(ObraLiterariaRequestDto obraLiteraria) {
        ObraLiteraria savedEmployed = obraLiterariaRepository.save(ObraLiterariaMapper.mapToObraLiteraria(obraLiteraria));
        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(savedEmployed);
    }

    @Override
    public List<ObraLiterariaResponseDto> findAllObraLiterarias() {
        Iterable<ObraLiteraria> iterable = obraLiterariaRepository.findAll();
        List<ObraLiteraria> obraLiterarias = StreamSupport.stream(iterable.spliterator(), false).toList();
        return obraLiterarias.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public ObraLiterariaResponseDto findObraLiterariaById(String id) {
        ObraLiteraria obraLiteraria = obraLiterariaRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No existe un documento con el id: " + id)
        );
        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(obraLiteraria);
    }

    @Override
    public List<ObraLiterariaResponseDto> findBooksByAuthor(String author) {
        List<ObraLiteraria> obras = obraLiterariaRepository.findAllByAuthor(author);
        return obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> findBooksByKeyWordTitle(String keyWord) {
        List<ObraLiteraria> obras = obraLiterariaRepository.findAllByKeyWordFromTitle(keyWord);
        return obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> findBooksByNumberPages() {
        List<ObraLiteraria> obras = obraLiterariaRepository.findTop5ByOrderByNumberPagesDesc();
        return obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> findBooksByYearPublication(Integer yearPublication) {
        List<ObraLiteraria> obras = obraLiterariaRepository.findByYearPublicationBefore(yearPublication);
        return obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> findBooksByKeyWordEditorial(String keyWord) {
        List<ObraLiteraria> obras = obraLiterariaRepository.findAllByEditorial(keyWord);
        return obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    @Override
    public ObraLiterariaResponseDto updateObraLiteraria(String id, ObraLiterariaRequestDto obraLiteraria) {
        findObraLiterariaById(id);
        ObraLiteraria obraLiterariaMapped = ObraLiterariaMapper.mapToObraLiteraria(obraLiteraria);
        obraLiterariaMapped.setId(id);
        ObraLiteraria updatedEmployed = obraLiterariaRepository.save(obraLiterariaMapped);
        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(updatedEmployed);
    }

}
