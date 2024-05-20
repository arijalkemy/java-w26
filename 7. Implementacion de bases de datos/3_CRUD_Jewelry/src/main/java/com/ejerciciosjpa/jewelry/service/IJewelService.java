package com.ejerciciosjpa.jewelry.service;

import com.ejerciciosjpa.jewelry.dto.JewelResponseDto;
import com.ejerciciosjpa.jewelry.entity.Jewel;

import java.util.List;

public interface IJewelService {
    public JewelResponseDto create(Jewel jewel);
    public List<Jewel> getJewelCatalogue();
    public void deleteJewel(Long id);
    public Jewel update(Long id,Jewel jewel);
}
