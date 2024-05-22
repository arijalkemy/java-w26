package com.mercadolibre.clothes.service.cloth;

import com.mercadolibre.clothes.dto.cloth.ClothRequestDTO;
import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;

import java.util.List;

public interface IClothesService {
    Long createCloth(ClothRequestDTO clothRequestDTO);

    List<ClothResponseDTO> getAllClothes(String type);

    ClothResponseDTO getClothByCode(Long code);

    ClothResponseDTO updateClothByCode(Long code, ClothRequestDTO clothRequestDTO);

    void deleteCloth(Long code);

    List<ClothResponseDTO> getClothesBySize(Integer size);
}
