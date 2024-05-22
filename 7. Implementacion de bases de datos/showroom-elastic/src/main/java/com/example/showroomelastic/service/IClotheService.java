package com.example.showroomelastic.service;

import com.example.showroomelastic.dto.PrendaRequestDto;
import com.example.showroomelastic.dto.PrendaResponseDto;

import java.util.List;

public interface IClotheService {
    List<PrendaResponseDto> getAll();
    PrendaResponseDto getClotheById(String id);
    PrendaResponseDto createClothe(PrendaRequestDto prendaRequestDto);
    PrendaResponseDto updateClothe(String id, PrendaRequestDto prendaRequestDto);
    String deleteClothe(String id);
    List<PrendaResponseDto> getClothesBySize(String size);
    List<PrendaResponseDto> searchClothes(String name);
}
