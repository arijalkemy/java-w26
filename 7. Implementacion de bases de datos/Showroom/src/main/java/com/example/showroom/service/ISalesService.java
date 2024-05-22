package com.example.showroom.service;

import com.example.showroom.model.dto.*;

import java.util.List;

public interface ISalesService {

    InfoMessageDto addSale(RequestedAddSaleDto newSale);

    List<RespSalesDto> getAllSales();

    RespSalesDto getSalesById(Long id);

    InfoMessageDto updateSale(RequestUpdateSaleDto updatedSale);

    InfoMessageDto deleteSaleById(Long id);

    List<RespSalesDto> getSalesByDate(String date);

    List<RespClothesDto> getClothesBySale(Long id);
}
