package com.example.ejerciciopracticoextraopcionales.service;

import com.example.ejerciciopracticoextraopcionales.dto.request.SaleRequestDTO;
import com.example.ejerciciopracticoextraopcionales.dto.response.ClothDTO;
import com.example.ejerciciopracticoextraopcionales.dto.response.MessageDTO;
import com.example.ejerciciopracticoextraopcionales.dto.response.SaleDTO;

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
    List<ClothDTO> showClothesByDate(LocalDate date);
}
