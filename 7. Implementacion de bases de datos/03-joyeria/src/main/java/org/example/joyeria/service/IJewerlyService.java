package org.example.joyeria.service;

import org.example.joyeria.dto.JewelRequestDTO;
import org.example.joyeria.dto.JewelResponseDTO;

import java.util.List;

public interface IJewerlyService {
    List<JewelResponseDTO> getJewerly();
    Long saveJewel(JewelRequestDTO jewel);
    void deleteJewel(Long id);
    JewelResponseDTO findJewel(Long id);
    JewelResponseDTO updateJewel(Long id, JewelRequestDTO jewel);
}
