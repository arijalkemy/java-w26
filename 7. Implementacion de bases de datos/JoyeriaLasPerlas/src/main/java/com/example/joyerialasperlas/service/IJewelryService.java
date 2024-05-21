package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JewelryDto;
import com.example.joyerialasperlas.entity.Jewelry;

import java.util.List;

public interface IJewelryService {
    String createJewelry(JewelryDto jewelryDto);
    List<JewelryDto> getAllJewelry();
    String deleteJewelry(Long id);
    JewelryDto updateJewelry(Long id, JewelryDto updatedJewelry);

}
