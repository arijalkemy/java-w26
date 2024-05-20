package com.bootcamp.joyeriacrud.service;

import com.bootcamp.joyeriacrud.model.dto.JewelryRequestDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryListResponseDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryResponseDTO;
import com.bootcamp.joyeriacrud.model.dto.MessageResponseDTO;

public interface IJewelryService {
    public MessageResponseDTO saveJewelry(JewelryRequestDTO jewelryRequestDTO);

    public JewelryListResponseDTO getJewelry();

    public MessageResponseDTO deleteJewelry(Long jewelryId);

    public JewelryResponseDTO updateJewelry(Long jewelryId, JewelryRequestDTO jewelryRequestDTO);
}
