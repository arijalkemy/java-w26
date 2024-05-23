package com.implementaciondb.ejercicio10_showroom.service.interfaces;

import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;

import java.util.List;

public interface IGarmentService {
    GarmentResponseDto saveGarment(GarmentRequestDto garmentRequestDto);

    List<GarmentResponseDto> findAllClothes();

    GarmentResponseDto findGarmentByCode(Long code);

    GarmentResponseDto deleteGarmentByCode(Long code);

    List<GarmentResponseDto> findGarmentBySize(Integer size);

    List<GarmentResponseDto> findClothesByKeyWordName(String name);
}
