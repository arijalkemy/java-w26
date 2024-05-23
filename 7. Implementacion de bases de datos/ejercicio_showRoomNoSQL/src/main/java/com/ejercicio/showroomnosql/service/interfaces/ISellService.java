package com.ejercicio.showroomnosql.service.interfaces;

import com.ejercicio.showroomnosql.dto.ClotheDTO;
import com.ejercicio.showroomnosql.dto.MessageResponseDTO;
import com.ejercicio.showroomnosql.dto.SellDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISellService {
    MessageResponseDTO createSell(SellDTO sellDTO);
    List<SellDTO> getAllSells();
    SellDTO getSellById(int id);
    SellDTO updateSell(int id, SellDTO sellDTO);
    void deleteSell(int id);
    List<SellDTO> getAllByDate(LocalDate date);
    List<ClotheDTO> getAllClothesFromSale(int sellId);
}
