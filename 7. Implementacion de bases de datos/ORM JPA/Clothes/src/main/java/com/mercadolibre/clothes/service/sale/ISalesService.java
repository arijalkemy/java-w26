package com.mercadolibre.clothes.service.sale;

import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import com.mercadolibre.clothes.dto.sale.SaleRequestDTO;
import com.mercadolibre.clothes.dto.sale.SaleResponseDTO;

import java.util.List;
import java.util.Set;

public interface ISalesService {
    Long createSale(SaleRequestDTO saleRequestDTO);

    List<SaleResponseDTO> getAllSales(String date);

    SaleResponseDTO getSaleById(Long number);

    SaleResponseDTO updateSale(Long number, SaleRequestDTO saleRequestDTO);

    void deleteSale(Long number);

    Set<ClothResponseDTO> getClothesFromSale(Long number);
}
