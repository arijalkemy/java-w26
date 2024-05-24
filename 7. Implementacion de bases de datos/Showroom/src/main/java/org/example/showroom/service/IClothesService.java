package org.example.showroom.service;

import org.example.showroom.models.DTO.ClothesRequestDTO;
import org.example.showroom.models.DTO.ClothesResponseDTO;

import java.util.List;

public interface IClothesService {
    ClothesResponseDTO findByCode(Long code);
    ClothesResponseDTO createNewClothes(ClothesRequestDTO newClothe);
    List< ClothesResponseDTO> findAllClothes();
    ClothesResponseDTO updateClotheByCode(Long code, ClothesRequestDTO clothe);
    String deleteClotheByCode(Long code);
    List<ClothesResponseDTO> findClothesBySize(String size);
    List<ClothesResponseDTO> findClothesByName(String  name);
}
