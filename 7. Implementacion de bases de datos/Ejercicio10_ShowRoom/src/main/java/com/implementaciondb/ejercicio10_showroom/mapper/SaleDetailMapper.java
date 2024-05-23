package com.implementaciondb.ejercicio10_showroom.mapper;

import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleDetailRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleDetailResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.entity.SaleDetail;

public class SaleDetailMapper {

    public static SaleDetail mapToSaleDetail(SaleDetailRequestDto sd){
        return SaleDetail.builder()
                .quantity(sd.getQuantity())
                .price(sd.getPrice())
                .garment(GarmentMapper.mapToGarment(sd.getGarment()))
                .build();
    }

    public static SaleDetailResponseDto mapToSaleDetailResponseDto(SaleDetail sd){
        return SaleDetailResponseDto.builder()
                .id(sd.getId())
                .quantity(sd.getQuantity())
                .price(sd.getPrice())
                .garment(GarmentMapper.mapToGarmentResponseDto(sd.getGarment()))
                .build();
    }


}
