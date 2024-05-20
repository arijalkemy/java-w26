package org.example.joyeria.service;

import org.example.joyeria.dto.SuccessResponseDto;
import org.example.joyeria.dto.jewel.JewelRequestDto;
import org.example.joyeria.dto.jewel.JewelResponseDto;

import java.util.List;

public interface IJewerlyService {
    List<JewelResponseDto> getAllJewels();

    SuccessResponseDto postCreateJewel(JewelRequestDto jewelRequestDto);

    JewelResponseDto updateJewel(Long id, JewelRequestDto jewelRequestDto);

    void deleteJewelById(Long id);
}
