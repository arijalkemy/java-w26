package com.example.showroom.service;

import com.example.showroom.model.dto.InfoMessageDto;
import com.example.showroom.model.dto.RequestedAddSaleDto;
import com.example.showroom.model.dto.RespClothesDto;
import com.example.showroom.model.dto.RespSalesDto;

import java.util.List;

public interface ISalesService {
    InfoMessageDto addSale(RequestedAddSaleDto newSale);
    List<RespSalesDto> getAllSales();
    RespSalesDto getSaleById(Long id);
    RespSalesDto updateSale(Long id, RequestedAddSaleDto updatedDto);
    InfoMessageDto deleteSaleById(Long id);
    List<RespSalesDto> getSalesByDate(String date);
    List<RespClothesDto> getClothesBySale(Long id);
}
