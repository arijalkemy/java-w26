package org.ggomezr.showroomelasticsearch.application.service.interfaces;

import org.ggomezr.showroomelasticsearch.domain.dto.ClothingDTO;
import org.ggomezr.showroomelasticsearch.domain.dto.ResponseDTO;

import java.util.List;

public interface IClothingService {
    ClothingDTO createClothing(ClothingDTO clothingDTO);
    List<ClothingDTO> createClothingBatch(List<ClothingDTO> clothingDTOList);
    List<ClothingDTO> getAllClothing();
    ClothingDTO getClothingById(String id);
    ClothingDTO updateClothing(String id, ClothingDTO clothingDTO);
    ResponseDTO deleteClothing(String id);
    List<ClothingDTO> getClothingBySize(String size);
    List<ClothingDTO> getClothingByName(String name);
}
