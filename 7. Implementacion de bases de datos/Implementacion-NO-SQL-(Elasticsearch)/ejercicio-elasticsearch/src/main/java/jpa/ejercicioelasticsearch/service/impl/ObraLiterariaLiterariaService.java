package jpa.ejercicioelasticsearch.service.impl;

import jpa.ejercicioelasticsearch.dto.reponseDTO.ObraliterariaResponseDto;
import jpa.ejercicioelasticsearch.dto.requestDTO.ObraLiterariaRequestDto;
import jpa.ejercicioelasticsearch.mapper.ObraLiterariaMapper;
import jpa.ejercicioelasticsearch.model.ObraLiteraria;
import jpa.ejercicioelasticsearch.repository.IObraLiterariaRepository;
import jpa.ejercicioelasticsearch.service.IObraLiterariaService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaLiterariaService implements IObraLiterariaService {
    private final IObraLiterariaRepository obraLiterariaRepository;

    public ObraLiterariaLiterariaService(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    public ObraliterariaResponseDto saveObraLiteraria(ObraLiterariaRequestDto obraLiteraria) {
        ObraLiteraria saved = obraLiterariaRepository.save(ObraLiterariaMapper.mapToObraLiteraria(obraLiteraria));
        return ObraLiterariaMapper.mapToObraLiterariaResponseDto(saved);
    }

    public List<ObraliterariaResponseDto> saveAllObrasLiterarias(List<ObraLiterariaRequestDto> obrasLiterarias) {
        List<ObraLiteraria> savedList = obrasLiterarias.stream().map(o -> ObraLiterariaMapper.mapToObraLiteraria(o)).toList();
        obraLiterariaRepository.saveAll(savedList);
        return savedList.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    public List<ObraliterariaResponseDto> getAllByAuthor(String author){
        List<ObraLiteraria> obras = this.obraLiterariaRepository.findByAuthor(author);
        return  obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }


    public List<ObraliterariaResponseDto> getAllObrasByKeyWordTitle(String keyWord){
        List<ObraLiteraria> obras = this.obraLiterariaRepository.findAllByKeyWordFromTitle(keyWord);
        return obras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    public List<ObraliterariaResponseDto> getTopFiveObrasLiterariasByNumberPage(){
        List<ObraLiteraria> topFiveObras = this.obraLiterariaRepository.findTop5ByOrderByNumberPagesDesc();
        return topFiveObras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    public List<ObraliterariaResponseDto> getObrasLiterariasByYearPublicationBefore(int year){
        List<ObraLiteraria> topFiveObras = this.obraLiterariaRepository.findByYearPublicationBefore(year);
        return topFiveObras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

    public List<ObraliterariaResponseDto> getObrasLiterariasByEditorial(String editorial) {
        List<ObraLiteraria> topFiveObras = this.obraLiterariaRepository.findAllByEditorial(editorial);
        return topFiveObras.stream().map(ObraLiterariaMapper::mapToObraLiterariaResponseDto).toList();
    }

}
