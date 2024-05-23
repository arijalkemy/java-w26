package com.ejerciciosjpa.extrajpa.service;


import com.ejerciciosjpa.extrajpa.dto.ClothRequestDto;
import com.ejerciciosjpa.extrajpa.dto.ClothResponseDto;

import java.util.List;

public interface IClotheService {
    List<ClothResponseDto> getAllClothes();
    ClothResponseDto getClothByCode(Long code);
    List<ClothResponseDto> getClothBySize(Integer size);
    ClothResponseDto addCloth(ClothRequestDto request);
    ClothResponseDto updateCloth(Long codigo, ClothRequestDto request);
    List<ClothResponseDto> getClothesByKey(String word);
    void deleteClothById(Long code);
}
