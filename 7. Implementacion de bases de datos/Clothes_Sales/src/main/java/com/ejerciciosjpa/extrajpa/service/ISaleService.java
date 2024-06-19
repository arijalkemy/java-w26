package com.ejerciciosjpa.extrajpa.service;

import com.ejerciciosjpa.extrajpa.dto.ClothResponseDto;
import com.ejerciciosjpa.extrajpa.dto.SaleRequestDto;
import com.ejerciciosjpa.extrajpa.dto.SaleResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleResponseDto createSale(SaleRequestDto request);
    List<SaleResponseDto> getAllSales();
    SaleResponseDto getSaleById(Long number);
    SaleResponseDto updateSale(Long number, SaleRequestDto request);
    void deleteSale(Long number);
    List<SaleResponseDto> getAllSalesByDate(LocalDate date);
    List<ClothResponseDto> getAllClothesBySale(Long number);
}
