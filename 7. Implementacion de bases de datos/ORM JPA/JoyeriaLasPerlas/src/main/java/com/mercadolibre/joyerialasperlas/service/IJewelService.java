package com.mercadolibre.joyerialasperlas.service;

import com.mercadolibre.joyerialasperlas.dto.JewelDTO;
import com.mercadolibre.joyerialasperlas.dto.JewelResponseDTO;

import java.util.List;

public interface IJewelService {

    Long createJewel(JewelDTO jewel);

    List<JewelResponseDTO> getAllJewels();

    JewelResponseDTO delete(Long id);

    JewelResponseDTO updateJewel(Long id, JewelDTO updatedJewel);
}
