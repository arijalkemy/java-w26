package com.example.demo.service.clothesService;

import com.example.demo.model.dto.clothesDTO.ClothesRequestDTO;
import com.example.demo.model.dto.clothesDTO.ClothesResponseDTO;

import java.util.List;

public interface IClothesService {
    ClothesResponseDTO createClothes(ClothesRequestDTO clothesRequestDTO);
    List<ClothesResponseDTO> getAllClothes();
    ClothesResponseDTO getClothesByCode(Long code);
    ClothesResponseDTO updateClothes(Long code, ClothesRequestDTO clothesRequestDTO);
    String deleteClothes(Long code);
    List<ClothesResponseDTO> getClothesBySize(String size);
    List<ClothesResponseDTO> getClothesByType(String type);
}
