package org.example.showroom.service;

import org.example.showroom.models.DTO.SaleRequestDTO;
import org.example.showroom.models.DTO.SaleResponseDTO;

import java.util.List;

public interface ISaleService {
    SaleResponseDTO createNewSale(SaleRequestDTO newSale);
    List<SaleResponseDTO> findAllSales();
    SaleResponseDTO findSaleByNumber(Long number);
}
