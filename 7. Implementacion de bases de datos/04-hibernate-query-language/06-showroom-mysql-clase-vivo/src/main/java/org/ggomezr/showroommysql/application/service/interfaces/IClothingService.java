package org.ggomezr.showroommysql.application.service.interfaces;

import org.ggomezr.showroommysql.domain.dto.ClothingDTO;
import org.ggomezr.showroommysql.domain.dto.ResponseDTO;

import java.util.List;

public interface IClothingService {
    ClothingDTO createClothing(ClothingDTO clothingDTO);
    List<ClothingDTO> createClothingBatch(List<ClothingDTO> clothingDTOList);
    List<ClothingDTO> getAllClothing();
    ClothingDTO getClothingById(Long id);
    ClothingDTO updateClothing(Long id, ClothingDTO clothingDTO);
    ResponseDTO deleteClothing(Long id);
    List<ClothingDTO> getClothingBySize(String size);
    List<ClothingDTO> getClothingByName(String name);
}
