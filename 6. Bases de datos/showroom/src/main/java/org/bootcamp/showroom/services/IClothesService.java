package org.bootcamp.showroom.services;

import org.bootcamp.showroom.dtos.ClotheResponseDto;
import org.bootcamp.showroom.dtos.ClotheUpdateDto;
import org.bootcamp.showroom.dtos.ClothesRequestDto;
import org.bootcamp.showroom.dtos.MessageResponseDTO;

import java.util.List;

public interface IClothesService {
    ClotheResponseDto create(ClothesRequestDto clothe);
    List<ClotheResponseDto> getAllClothes();
    ClotheResponseDto getByCode(String code);
    ClotheResponseDto update(String code, ClotheUpdateDto clothe);
    MessageResponseDTO delete(String code);
    List<ClotheResponseDto> getAllClothesByWaist(String waist);
    List<ClotheResponseDto> getAllClothesByName(String name);
}
