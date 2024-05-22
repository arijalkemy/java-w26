package org.example.tiendadeprendas.service;

import org.example.tiendadeprendas.dto.PrendaDto;

import java.util.List;

public interface IPrendaService {
    public  void createPrenda(PrendaDto prendaDto);
    public PrendaDto findByCode(Long code);
    public void updatePrenda(Long code, PrendaDto prendaDto);
    public void deletePrenda(Long code);
    public List<PrendaDto> allPrendas();
    public List<PrendaDto> prendasBySize(String size);
    public List<PrendaDto> findPrendasByName(String name);
}
