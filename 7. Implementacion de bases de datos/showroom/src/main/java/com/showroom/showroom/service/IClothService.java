package com.showroom.showroom.service;

import com.showroom.showroom.dto.ClothResponseDTO;
import com.showroom.showroom.model.Cloth;

import java.util.List;

public interface IClothService {
    Long save(Cloth cloth);
    List<ClothResponseDTO> getAll();
    ClothResponseDTO getById(Long id);
    ClothResponseDTO update(Long id, Cloth cloth);
    String delete(Long id);
    List<ClothResponseDTO> getClothBySize(String size);
    List<ClothResponseDTO> getClothByName(String name);
}
