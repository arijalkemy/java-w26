package com.mercadolibre.lasperlas.service;

import com.mercadolibre.lasperlas.dto.JoyaRequestDTO;
import com.mercadolibre.lasperlas.dto.JoyaResponseDTO;
import com.mercadolibre.lasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public void saveJoya(JoyaRequestDTO joya);
    public List<Joya> getJoyas();
    public JoyaResponseDTO findJoya(Long id);
    public void deleteJoya(Long id);
    public void editJoya(Long idModificar, JoyaRequestDTO joyaModif);

}
