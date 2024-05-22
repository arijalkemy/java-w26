package com.showroom.showroom.service;

import com.showroom.showroom.dto.ClothResponseDTO;
import com.showroom.showroom.dto.SaleRequestDTO;
import com.showroom.showroom.dto.SaleResponseDto;
import com.showroom.showroom.model.Cloth;
import com.showroom.showroom.model.Sale;

import java.time.LocalDateTime;
import java.util.List;

public interface ISaleService {
    SaleResponseDto save(SaleRequestDTO sale);
    List<SaleResponseDto> getAll();
    SaleResponseDto update(Long id, SaleRequestDTO sale);
    String delete(Long id);
    SaleResponseDto getById(Long id);
    SaleResponseDto getByDate(String date);
    List<ClothResponseDTO> getClothes( Long id );
}
