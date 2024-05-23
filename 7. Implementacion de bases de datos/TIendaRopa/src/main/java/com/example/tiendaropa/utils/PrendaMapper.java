package com.example.tiendaropa.utils;

import com.example.tiendaropa.models.Dto.PrendaRequestDto;
import com.example.tiendaropa.models.Dto.PrendaResponseDto;
import com.example.tiendaropa.models.Prenda;

public class PrendaMapper {
    public static Prenda mapToPrenda(PrendaRequestDto PrendaRequestDto) {

        return Prenda.builder()
                .talla(PrendaRequestDto.getTalla())
                .color(PrendaRequestDto.getColor())
                .marca(PrendaRequestDto.getMarca())
                .tipo(PrendaRequestDto.getTipo())
                .cantidad(PrendaRequestDto.getCantidad())
                .precioVenta(PrendaRequestDto.getPrecioVenta())
                .nombre(PrendaRequestDto.getNombre())
                .build();
    }

    public static PrendaResponseDto mapToPrendaResponseDto(Prenda prenda) {

        return PrendaResponseDto.builder()
                .id(prenda.getId())
                .talla(prenda.getTalla())
                .color(prenda.getColor())
                .marca(prenda.getMarca())
                .tipo(prenda.getTipo())
                .cantidad(prenda.getCantidad())
                .precioVenta(prenda.getPrecioVenta())
                .nombre(prenda.getNombre())
                .build();
    }
}
