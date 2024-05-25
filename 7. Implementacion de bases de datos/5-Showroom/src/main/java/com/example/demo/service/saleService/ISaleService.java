package com.example.demo.service.saleService;

import com.example.demo.model.dto.clothesDTO.ClothesResponseDTO;
import com.example.demo.model.dto.saleDTO.SaleRequestDTO;
import com.example.demo.model.dto.saleDTO.SaleResponseDTO;
import com.example.demo.model.entity.Clothes;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO);
    List<SaleResponseDTO> getSales();
    SaleResponseDTO getSaleById(Long id);
    SaleResponseDTO updateSale(Long id, SaleRequestDTO saleRequestDTO);
    String deleteSale(Long id);
    List<ClothesResponseDTO> getClothesSoldOnDate(LocalDate date);
    List<ClothesResponseDTO> getClothesBySale(Long saleId);
}
