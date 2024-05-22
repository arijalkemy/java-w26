package org.example.integradorlasperlas.service;

import org.example.integradorlasperlas.model.dto.JoyaRequestDTO;
import org.example.integradorlasperlas.model.dto.JoyaResponseDTO;
import org.example.integradorlasperlas.model.dto.JoyaUpdateDTO;

import java.util.List;

public interface IJoyaService {

    JoyaRequestDTO createJewel(JoyaRequestDTO joyaRequestDTO);
    List<JoyaResponseDTO> getAllJewels();
    String deleteJewel(Long id);
    JoyaResponseDTO getJewel(Long id);
    JoyaUpdateDTO updateJewel(JoyaUpdateDTO joyaUpdateDTO);

    String logicalDeleteJewel(Long id);
    List<JoyaResponseDTO> logicalGetAllJewels();
}
