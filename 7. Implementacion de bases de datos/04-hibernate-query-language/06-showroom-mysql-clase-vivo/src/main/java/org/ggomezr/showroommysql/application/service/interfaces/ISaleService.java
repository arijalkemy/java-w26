package org.ggomezr.showroommysql.application.service.interfaces;

import org.ggomezr.showroommysql.domain.dto.ResponseDTO;
import org.ggomezr.showroommysql.domain.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    List<SaleDTO> createSalesBatch(List<SaleDTO> saleDTOList);
    List<SaleDTO> getAllSales();
    SaleDTO getSaleById(Long code);
    SaleDTO updateSale(SaleDTO saleDTO, Long code);
    ResponseDTO deleteSale(Long code);
    List<SaleDTO> getSalesByDate(LocalDate date);
    List<SaleDTO> getSaleByCode(Long code);
}
