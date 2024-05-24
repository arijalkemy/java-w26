package org.example.ejerciciojoyeria.service;

import org.example.ejerciciojoyeria.dto.JoyaRequestDTO;
import org.example.ejerciciojoyeria.dto.JoyaResponseDTO;

import java.util.List;

public interface IJoyeriaService {
    public String saveJoya(JoyaRequestDTO joya);
    public List<JoyaResponseDTO> getAllJoyas();
    public JoyaResponseDTO getJoyaById(Long id);
    public String deleteJoya(Long id);
    public String updateJoya(Long id, JoyaRequestDTO joya);
}
