package com.example.showroomelastic.service;

import com.example.showroomelastic.dto.SaleRequestDto;
import com.example.showroomelastic.dto.SaleResponseDto;

import java.util.List;

public interface ISaleService {
    SaleResponseDto createSale(SaleRequestDto ventaRequestDto);
    List<SaleResponseDto> getSales();
    SaleResponseDto getSaleById(String id);
    SaleResponseDto updateSale(String id, SaleRequestDto ventaRequestDto);
    String deleteSale(String id);
    List<SaleResponseDto> searchByDate(String date);
    SaleResponseDto searchByNumber(String number);
}
