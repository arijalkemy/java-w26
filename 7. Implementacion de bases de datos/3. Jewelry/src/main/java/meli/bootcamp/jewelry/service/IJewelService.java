package meli.bootcamp.jewelry.service;

import meli.bootcamp.jewelry.dto.JewelRequestDTO;
import meli.bootcamp.jewelry.dto.JewelResponseDTO;
import meli.bootcamp.jewelry.entity.Jewel;

import java.util.List;
import java.util.Map;

public interface IJewelService {
    Map<String, Long> saveJewel(JewelRequestDTO jewel);
    JewelResponseDTO getJewelById(Long id);
    List<JewelResponseDTO> getJewels();
    void deleteJewel(Long id);
    JewelResponseDTO updateJewel(Long id, JewelRequestDTO jewel);
}
