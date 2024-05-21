package com.joyerialasperlas.services.interfaces;

import com.joyerialasperlas.DTOs.JoyaDTO;
import com.joyerialasperlas.DTOs.JoyaResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJoyaService {
    JoyaResponseDTO create(JoyaDTO joyaDTO);
    JoyaResponseDTO findById(Long id);
    List<JoyaResponseDTO> findAll();
    JoyaResponseDTO update(Long id, JoyaDTO joyaDTO);
    void delete(Long id);
}
