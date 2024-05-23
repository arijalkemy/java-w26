package org.example.showroomsql.service;

import org.example.showroomsql.dto.RequestClothesDTO;
import org.example.showroomsql.dto.ResponseClothesDTO;

import java.util.List;

public interface IClothesService {

    ResponseClothesDTO createClothes(RequestClothesDTO request);
    List<ResponseClothesDTO> getAllClothes();
    ResponseClothesDTO getClothesByCode(Long code);
    ResponseClothesDTO updateClothes(Long code, RequestClothesDTO request);
    String deleteClothes(Long code);
    List<ResponseClothesDTO> getClothesBySize(String size);
    List<ResponseClothesDTO> getClothesByName(String name);
}
