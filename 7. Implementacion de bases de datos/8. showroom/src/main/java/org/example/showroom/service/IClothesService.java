package org.example.showroom.service;

import org.example.showroom.DTO.RequestClothesDTO;
import org.example.showroom.DTO.ResponseClothesDTO;

import java.util.List;

public interface IClothesService {
    ResponseClothesDTO createClothes(RequestClothesDTO requestClothesDTO);
    List<ResponseClothesDTO> getAllClothes(String keyword);
    ResponseClothesDTO getClothesByCode(Long code);
    ResponseClothesDTO updateClothes(Long code, RequestClothesDTO requestClothesDTO);
    void deleteClothes(Long code);
    List<ResponseClothesDTO> getClothesBySize(float size);
}
