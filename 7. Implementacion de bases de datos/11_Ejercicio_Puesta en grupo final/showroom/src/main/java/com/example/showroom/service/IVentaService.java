package com.example.showroom.service;

import com.example.showroom.dto.PrendaResponseDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.dto.VentaResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    VentaResponseDto saveSale(VentaDto venta);

    List<VentaResponseDto> findAllSales();

    VentaResponseDto findSaleById(Long number);

    String deleteSaleById(Long number);

    List<PrendaResponseDto> findClothesByDate(LocalDate date);

    List<PrendaResponseDto> findClothesBySale(Long number);
}
