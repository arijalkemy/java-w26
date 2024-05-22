package com.showroom.showroomelastic.service;

import com.showroom.showroomelastic.dto.ClothResponseDTO;
import com.showroom.showroomelastic.dto.SaleRequestDTO;
import com.showroom.showroomelastic.dto.SaleResponseDto;

import java.util.List;

public interface ISaleService {
    SaleResponseDto save(SaleRequestDTO sale);
    List<SaleResponseDto> getAll();
    SaleResponseDto update(String id, SaleRequestDTO sale);
    String delete(String id);
    SaleResponseDto getById(String id);
    SaleResponseDto getByDate(String date);
    List<ClothResponseDTO> getClothes( String id );
}
