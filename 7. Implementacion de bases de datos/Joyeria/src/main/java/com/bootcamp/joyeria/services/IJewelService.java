package com.bootcamp.joyeria.services;

import com.bootcamp.joyeria.dtos.JewelRequestDTO;
import com.bootcamp.joyeria.dtos.JewelResponseDTO;
import com.bootcamp.joyeria.dtos.JewelUpdateDTO;
import com.bootcamp.joyeria.dtos.MessageResponseDTO;

import java.util.List;

public interface IJewelService {
    MessageResponseDTO createJewel(JewelRequestDTO jewelRequestDTO);
    List<JewelResponseDTO> getAllJewels();
    void deleteJewel(Long id);
    MessageResponseDTO updateJewel(Long id, JewelUpdateDTO jewelUpdateDTO);
}
