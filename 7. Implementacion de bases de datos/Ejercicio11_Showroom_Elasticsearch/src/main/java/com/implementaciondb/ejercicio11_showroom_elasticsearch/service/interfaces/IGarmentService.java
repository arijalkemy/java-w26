package com.implementaciondb.ejercicio11_showroom_elasticsearch.service.interfaces;


import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment.GarmentRequestDto;
import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.dto.Garment.GarmentResponseDto;

import java.util.List;

public interface IGarmentService {
    GarmentResponseDto saveGarment(GarmentRequestDto garmentRequestDto);

    List<GarmentResponseDto> findAllClothes();

    GarmentResponseDto findGarmentByCode(String code);

    GarmentResponseDto deleteGarmentByCode(String code);

    List<GarmentResponseDto> findGarmentBySize(Integer size);

    List<GarmentResponseDto> findClothesByKeyWordName(String name);
}
