package com.implementacionDB.joyeria.service;

import com.implementacionDB.joyeria.dto.JewellResponseDTO;
import com.implementacionDB.joyeria.dto.request.JewelDTO;
import com.implementacionDB.joyeria.dto.MessageDTO;

import java.util.List;

public interface IJewelService {
    public List<JewellResponseDTO> getAll();
    public JewellResponseDTO getById(Long id);
    public MessageDTO deleteJewel(Long id);
    public MessageDTO addJewel(JewelDTO jewelDTO);
    public MessageDTO updateJewel(Long id, JewelDTO jewelDTO);

}
