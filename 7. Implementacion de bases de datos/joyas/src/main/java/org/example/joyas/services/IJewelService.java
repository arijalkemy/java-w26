package org.example.joyas.services;

import org.example.joyas.DTO.JewelNewResponseDTO;
import org.example.joyas.DTO.JewelRequestDTO;
import org.example.joyas.DTO.JewelResponseDTO;

import java.util.*;

public interface IJewelService {
    JewelNewResponseDTO createJewerly(JewelRequestDTO newJewerly);
    List<JewelResponseDTO> listAll();
    void deleteJewerlyById(Long id);
    JewelResponseDTO updateById(Long id, JewelRequestDTO jewel);
}
