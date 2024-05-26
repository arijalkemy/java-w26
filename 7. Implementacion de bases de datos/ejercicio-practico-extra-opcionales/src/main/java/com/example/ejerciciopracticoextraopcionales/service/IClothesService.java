package com.example.ejerciciopracticoextraopcionales.service;

import com.example.ejerciciopracticoextraopcionales.dto.request.ClothRequestDTO;
import com.example.ejerciciopracticoextraopcionales.dto.response.ClothDTO;
import com.example.ejerciciopracticoextraopcionales.dto.response.MessageDTO;

import java.util.List;

public interface IClothesService {
    MessageDTO addNewCloth(ClothRequestDTO clotheRequest);
    List<ClothDTO> showAllClothes(String name);
    List<ClothDTO> getClothesBySize(Integer size);
    void deleteCloth(Long code);
    ClothDTO searchClothByCode(Long code);
    MessageDTO updateClothByCode(Long code, ClothRequestDTO clothe);
}
