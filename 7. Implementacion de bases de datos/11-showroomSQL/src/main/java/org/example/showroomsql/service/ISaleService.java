package org.example.showroomsql.service;

import org.example.showroomsql.dto.RequestSaleDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;
import org.example.showroomsql.dto.ResponseSaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    ResponseSaleDTO createSale(RequestSaleDTO request);
    List<ResponseSaleDTO> getAllSales();
    ResponseSaleDTO getSaleByNumber(Long num);
    ResponseSaleDTO updateSale(Long num, RequestSaleDTO request);
    String deleteSale(Long num);
    List<ResponseClothesDTO> getSalesByDate(LocalDate date);
    List<ResponseClothesDTO> getClothesBySale(Long num);
}
