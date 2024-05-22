package com.example.showroom.service;

import com.example.showroom.model.dto.RequesUpdateClotheDTO;
import com.example.showroom.model.dto.RequestAddClotheDTO;

import java.util.List;

public interface IClothesService {
    String createClothes(RequestAddClotheDTO clothes);
    RequestAddClotheDTO getClothes(String id);
    List<RequestAddClotheDTO> getAllClothes();
    String updateClothes(RequesUpdateClotheDTO clothes);
    String deleteClothes(String id);
    List<RequestAddClotheDTO> getAllClothesBySize(String size);
    List<RequestAddClotheDTO> getAllClothesByName(String name);
}
