package org.example.obrasliterarias.service.impl;

import org.example.obrasliterarias.dto.ObraLiterariaRequestDto;
import org.example.obrasliterarias.dto.ObraLiterariaResponseDto;
import org.example.obrasliterarias.entity.ObraLiteraria;
import org.example.obrasliterarias.repository.IObraLiteriaRepository;
import org.example.obrasliterarias.service.IObraLiterariaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {
    private final IObraLiteriaRepository obraLiterariaRepository;

    public ObraLiterariaServiceImpl(@Autowired IObraLiteriaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    @Override
    public List<ObraLiterariaResponseDto> saveBulk(List<ObraLiterariaRequestDto> obrasLiterias) {
        ModelMapper modelMapper = new ModelMapper();
        List<ObraLiterariaResponseDto> response = new ArrayList<>();
        obrasLiterias.forEach(obra -> {
            ObraLiteraria saved = obraLiterariaRepository.save(modelMapper.map(obra, ObraLiteraria.class));
            response.add(modelMapper.map(saved, ObraLiterariaResponseDto.class));
        });
        return response;
    }

    @Override
    public List<ObraLiterariaResponseDto> findByAuthor(String author, Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();
        return obraLiterariaRepository.findByAuthor(author, pageable)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraLiterariaResponseDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> getByTitleWildCard(String title, Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();
        return obraLiterariaRepository.findByNameContains(title, pageable)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraLiterariaResponseDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> getTopByAmountPages(Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();
        return obraLiterariaRepository.findTop5ByOrderByAmountOfPagesDesc(pageable)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraLiterariaResponseDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> getByYearLess(Integer year, Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();
        return obraLiterariaRepository.findByPublishingYearIsLessThan(year, pageable)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraLiterariaResponseDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> findByEditorial(String editorial, Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();
        return obraLiterariaRepository.findByEditorial(editorial, pageable)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraLiterariaResponseDto.class))
                .toList();
    }
}
