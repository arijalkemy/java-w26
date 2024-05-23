package org.example.showroom.service;

import org.example.showroom.dto.clothe.ClotheResponseDto;
import org.example.showroom.dto.sale.SaleRequestDto;
import org.example.showroom.dto.sale.SaleResponseDto;

import java.util.List;

public interface ISaleService {
    SaleResponseDto save(SaleRequestDto sale);

    SaleResponseDto findById(Long id);

    List<SaleResponseDto> findAll();

    SaleResponseDto update(Long id, SaleRequestDto sale);

    void delete(Long id);

    List<ClotheResponseDto> findClothes(Long id);
}
