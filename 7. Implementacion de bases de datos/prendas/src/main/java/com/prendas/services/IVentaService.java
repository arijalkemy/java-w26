package com.prendas.services;

import com.prendas.DTOs.request.SaleRequestDto;
import com.prendas.DTOs.response.PrendaResponseDTO;
import com.prendas.DTOs.response.SaleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    SaleResponseDTO crear(SaleRequestDto saleRequestDto);
    List<SaleResponseDTO> getAll();
    SaleResponseDTO findByNumber(Long number);
    SaleResponseDTO update(Long id, SaleRequestDto saleRequestDto);
    void delete(Long number);
    List<SaleResponseDTO> findByDate(LocalDate date);
    List<PrendaResponseDTO> findClothesByNumber(Long number);
}
