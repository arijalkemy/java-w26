package com.example.JoyeriaLasPerlas.service;

import com.example.JoyeriaLasPerlas.dto.jewel.JewelCompleteResponseDto;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelRequestDto;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelResponseDto;

import java.util.List;

public interface IJewelService {
    JewelResponseDto addJewel(JewelRequestDto jewelRequestDto);
    List<JewelCompleteResponseDto> getAllJewels();
    String deleteJewel(Long id);
    JewelCompleteResponseDto updateJewel(Long id, JewelRequestDto jewelRequestDto);

}
