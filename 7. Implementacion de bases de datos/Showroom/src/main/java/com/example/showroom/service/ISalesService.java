package com.example.showroom.service;

import com.example.showroom.model.dto.InfoMessageDto;
import com.example.showroom.model.dto.RespClothesDto;
import com.example.showroom.model.dto.RespSalesDto;

import java.util.List;

public interface ISalesService {

    InfoMessageDto deleteSaleById(Long id);
    List<RespSalesDto> getSalesByDate(String date);
    List<RespClothesDto> getClothesBySale(Long id);
    RespSalesDto getSalesById(Long id);
}
