package com.showroom.showroomelastic.service;

import com.showroom.showroomelastic.dto.ClothResponseDTO;
import com.showroom.showroomelastic.model.Cloth;

import java.util.List;

public interface IClothService {
    String save(Cloth cloth);
    List<ClothResponseDTO> getAll();
    ClothResponseDTO getById(String id);
    ClothResponseDTO update(String id, Cloth cloth);
    String delete(String id);
    List<ClothResponseDTO> getClothBySize(String size);
    List<ClothResponseDTO> getClothByName(String name);
}
