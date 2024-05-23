package com.implementaciondb.ejercicio10_showroom.service.interfaces;

import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleResponseDto saveSale(SaleRequestDto saleRequestDto);

    List<SaleResponseDto> findAllSales();

    SaleResponseDto findSaleById(Long number);

    SaleResponseDto deleteSaleById(Long number);

    List<GarmentResponseDto> findClothesByDate(LocalDate date);

    List<GarmentResponseDto> findClothesBySale(Long number);
}
