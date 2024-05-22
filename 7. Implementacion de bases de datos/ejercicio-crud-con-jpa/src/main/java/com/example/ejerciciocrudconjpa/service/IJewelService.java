package com.example.ejerciciocrudconjpa.service;

import com.example.ejerciciocrudconjpa.dto.request.CreateJewelRequestDto;
import com.example.ejerciciocrudconjpa.dto.request.UpdateJewelRequestDto;
import com.example.ejerciciocrudconjpa.dto.response.JewelResponseDto;
import com.example.ejerciciocrudconjpa.dto.response.ResponseDto;

import java.util.List;

public interface IJewelService {
    ResponseDto createJewel(CreateJewelRequestDto createJewelRequestDto);
    List<JewelResponseDto> findAllJewels();
    void deleteJewel(Integer id);
    JewelResponseDto updateJewel(Integer id, UpdateJewelRequestDto updateJewelRequestDto);
}
