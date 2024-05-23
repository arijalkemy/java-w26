package com.example.showroom.service;

import com.example.showroom.dto.request.SaleRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.dto.response.SaleDTO;
import com.example.showroom.entity.Cloth;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISalesService {
    MessageDTO addNewSale(SaleRequestDTO saleRequestDTO);
    void deleteSale(Long number);
    List<SaleDTO> getSales();
    List<SaleDTO> getSalesByDate(LocalDate date);
    List<ClothDTO> searchClothesOfSale(Long saleCode);
    SaleDTO showSaleByNumber(Long number);
}
