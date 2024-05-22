package com.implementaciondb.ejercicio10_showroom.mapper;

import com.implementaciondb.ejercicio10_showroom.exception.NotFoundException;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Garment.GarmentResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;

import java.util.List;

public class GarmentMapper {

    public static Garment mapToGarment(GarmentRequestDto g) {
        return new Garment(
                null,
                g.getName(),
                g.getType(),
                g.getBrand(),
                g.getColor(),
                g.getSize(),
                g.getQuantity(),
                g.getSalePrice()
        );
    }

    public static Garment mapToGarment(GarmentDto g) {
        return new Garment(
                g.getCode(),
                g.getName(),
                g.getType(),
                g.getBrand(),
                g.getColor(),
                g.getSize(),
                g.getQuantity(),
                g.getSalePrice()
        );
    }

    public static GarmentResponseDto mapToGarmentResponseDto(Garment g) {
        return new GarmentResponseDto(
                g.getCode(),
                g.getName(),
                g.getType(),
                g.getBrand(),
                g.getColor(),
                g.getSize(),
                g.getQuantity(),
                g.getSalePrice()
        );
    }

    public static List<GarmentResponseDto> mapToGarmentResponseDtoList(List<Garment> garments) {
        if (garments.isEmpty()) {
            throw new NotFoundException("Prendas no encontradas");
        }
        return garments.stream().map(GarmentMapper::mapToGarmentResponseDto).toList();
    }

}
