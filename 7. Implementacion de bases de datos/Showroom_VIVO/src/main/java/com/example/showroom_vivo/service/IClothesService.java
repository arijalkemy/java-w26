package com.example.showroom_vivo.service;

import com.example.showroom_vivo.dto.ClothesDTO;
import com.example.showroom_vivo.dto.ResponseDTO;

import java.util.List;

public interface IClothesService {
    ResponseDTO createClothes(ClothesDTO clothes);
    List<ClothesDTO> getAllClothes();
    ClothesDTO getClothesById(Long id);
    ResponseDTO updateClothes(Long id, ClothesDTO clothes);
    ResponseDTO deleteClothes(Long id);
    List<ClothesDTO> getClothesBySize(Double size);
    List<ClothesDTO> getClothesByName(String name);
}
