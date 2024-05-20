package com.example.ejercicio_lasperlas.service;

import com.example.ejercicio_lasperlas.dto.JewelDTO;
import com.example.ejercicio_lasperlas.model.Jewel;

import java.util.List;

public interface IJewelService {
    Jewel saveJewel(JewelDTO jewel);
    List<Jewel> getAllJewels();
    void deleteJewel(long id);
    Jewel getJewel(long id);
    JewelDTO updateJewel(JewelDTO jewelDTO);
}
