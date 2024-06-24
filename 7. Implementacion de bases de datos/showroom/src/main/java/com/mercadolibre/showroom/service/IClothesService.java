package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.RequestClothes;
import com.mercadolibre.showroom.dto.ResponseClothes;

import java.util.List;

public interface IClothesService {

    ResponseClothes createClothes(RequestClothes request);

    List<ResponseClothes> listResponseClothes();

    ResponseClothes responseClothes(Long code);

    ResponseClothes updateClothes(Long code, RequestClothes request);

    String deleteClothes(Long code);

    List<ResponseClothes> listResponseClothesBySize(String size);

    List<ResponseClothes> listResponseClothesByName(String name);
}
