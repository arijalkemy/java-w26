package org.example.showroom.services;

import org.example.showroom.models.DTO.ClothesRequestDTO;
import org.example.showroom.models.DTO.ClothesResponseDTO;

import java.util.List;

public interface IClothesService {
    ClothesResponseDTO findByCode(String code);
    ClothesResponseDTO createNewClothes(ClothesRequestDTO newClothe);
    List< ClothesResponseDTO> findAllClothes();
    ClothesResponseDTO updateClotheByCode(String code, ClothesRequestDTO clothe);
    String deleteClotheByCode(String code);
    List<ClothesResponseDTO> findClothesBySize(String size);
    List<ClothesResponseDTO> findClothesByName(String  name);
}
