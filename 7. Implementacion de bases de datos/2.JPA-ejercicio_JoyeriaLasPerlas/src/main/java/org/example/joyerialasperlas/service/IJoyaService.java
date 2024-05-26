package org.example.joyerialasperlas.service;

import org.example.joyerialasperlas.dto.JoyaRequestDTO;
import org.example.joyerialasperlas.dto.JoyaResponseDTO;
import org.example.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<JoyaResponseDTO> findAll();

    public Joya findById(Long id);

    public Long create(JoyaRequestDTO joya);

    public JoyaResponseDTO update(Long id, JoyaRequestDTO joya);

    public void delete(Long id);
}
