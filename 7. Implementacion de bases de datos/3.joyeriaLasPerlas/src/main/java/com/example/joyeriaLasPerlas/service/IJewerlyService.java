package com.example.joyeriaLasPerlas.service;

import com.example.joyeriaLasPerlas.dto.JewerlyRequestDTO;
import com.example.joyeriaLasPerlas.dto.JewerlyResponseDTO;
import com.example.joyeriaLasPerlas.model.Jewerly;

import java.util.List;

public interface IJewerlyService {

    void createJewerly(JewerlyRequestDTO jewerlyRequestDTO);
    List<JewerlyResponseDTO> getAllRegisteredJewerlies();
    void deleteJewerlyById(Long id);
    JewerlyResponseDTO updateJewerly(Long id, JewerlyRequestDTO jewerlyRequestDTO);
}
