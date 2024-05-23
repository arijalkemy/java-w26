package com.example.tiendaropa.service;

import com.example.tiendaropa.models.Dto.PrendaRequestDto;
import com.example.tiendaropa.models.Dto.PrendaResponseDto;

import java.util.List;

public interface IPrendaService {
    PrendaResponseDto postNewPrenda(PrendaRequestDto prenda);

    List<PrendaResponseDto> getAllPrendas();

    PrendaResponseDto findPrendaById(Long id);

    PrendaResponseDto updatePrenda(Long id , PrendaRequestDto prenda);

    String deletePrenda(Long id );

    List<PrendaResponseDto> findPrendasBySize(String talla);

    List<PrendaResponseDto> findByName(String name);

}
