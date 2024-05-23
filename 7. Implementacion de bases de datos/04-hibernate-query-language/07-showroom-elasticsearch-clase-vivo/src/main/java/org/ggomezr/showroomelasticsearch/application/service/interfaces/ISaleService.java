package org.ggomezr.showroomelasticsearch.application.service.interfaces;

import org.ggomezr.showroomelasticsearch.domain.dto.ResponseDTO;
import org.ggomezr.showroomelasticsearch.domain.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    List<SaleDTO> createSalesBatch(List<SaleDTO> saleDTOList);
    List<SaleDTO> getAllSales();
    SaleDTO getSaleById(String code);
    SaleDTO updateSale(SaleDTO saleDTO, String code);
    ResponseDTO deleteSale(String code);
    List<SaleDTO> getSalesByDate(LocalDate date);
    SaleDTO getSaleByCode(String code);
}
