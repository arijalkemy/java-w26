package com.demospring.joyerialasperlas.service;

import com.demospring.joyerialasperlas.dto.JoyaRequestDTO;
import com.demospring.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    Long createJoya(JoyaRequestDTO joya);
    List<Joya> getAllJoyas();
    void deleteJoya(Long id);
    void updateJoya(Long id, JoyaRequestDTO joya);
}
