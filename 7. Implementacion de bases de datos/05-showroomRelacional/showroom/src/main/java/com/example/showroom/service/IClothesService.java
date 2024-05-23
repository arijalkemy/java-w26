package com.example.showroom.service;

import com.example.showroom.dto.request.ClothRequestDTO;
import com.example.showroom.dto.response.ClothDTO;
import com.example.showroom.dto.response.MessageDTO;

import java.util.List;

public interface IClothesService {
    MessageDTO addNewCloth(ClothRequestDTO clotheRequest);
    List<ClothDTO> showAllClothes(String name);
    List<ClothDTO> getClothesBySize(Integer size);
    MessageDTO deleteCloth(Long code);
    ClothDTO searchClothByCode(Long code);
    MessageDTO updateClothByCode(Long code, ClothRequestDTO clothe);
}
