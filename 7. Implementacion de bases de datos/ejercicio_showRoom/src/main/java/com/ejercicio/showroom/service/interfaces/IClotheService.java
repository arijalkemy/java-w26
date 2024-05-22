package com.ejercicio.showroom.service.interfaces;

import com.ejercicio.showroom.dto.MessageResponseDTO;
import com.ejercicio.showroom.dto.ClotheDTO;
import com.ejercicio.showroom.entities.Clothe;

import java.util.List;

public interface IClotheService {
    MessageResponseDTO createClothe(ClotheDTO clotheDTO);
    List<Clothe> getAllClothes();
    Clothe getClotheByCode(long code);
    Clothe updateClothe(long code, ClotheDTO clotheDTO);
    MessageResponseDTO deleteClothe(long code);
    List<Clothe> getAllClothesByWaist(String waist);
    List<Clothe> getAllClothesByName(String name);
}
