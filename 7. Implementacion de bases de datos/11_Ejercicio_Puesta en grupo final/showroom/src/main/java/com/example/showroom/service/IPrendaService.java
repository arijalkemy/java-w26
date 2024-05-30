package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.PrendaResponseDto;

import java.util.List;

public interface IPrendaService {
    public PrendaResponseDto savePrenda(PrendaDto prenda);
    public List<PrendaResponseDto> getAllPrendas();
    public PrendaResponseDto getPrendaById(Long id);
    public PrendaResponseDto updatePrenda(Long id, PrendaDto prenda);
    public String deletePrenda(Long id);
    public List<PrendaResponseDto> getAllPrendasByTalla(String talla);
    public List<PrendaResponseDto> getAllPrendasByTipo(String tipo);
}
