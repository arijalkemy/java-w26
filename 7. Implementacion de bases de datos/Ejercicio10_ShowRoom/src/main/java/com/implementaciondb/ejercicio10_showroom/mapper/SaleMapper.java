package com.implementaciondb.ejercicio10_showroom.mapper;

import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleDetailResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleRequestDto;
import com.implementaciondb.ejercicio10_showroom.model.dto.Sale.SaleResponseDto;
import com.implementaciondb.ejercicio10_showroom.model.entity.Sale;
import com.implementaciondb.ejercicio10_showroom.model.entity.SaleDetail;

import java.util.List;

public class SaleMapper {

    public static Sale mapToSale(SaleRequestDto s) {
        List<SaleDetail> sales = s.getSaleDetails().stream().map(SaleDetailMapper::mapToSaleDetail).toList();
        return Sale.builder()
                .date(s.getDate())
                .total(s.getTotal())
                .paymentMethod(s.getPaymentMethod())
                .saleDetails(sales)
                .build();
    }

    public static SaleResponseDto mapToSaleResponseDto(Sale s) {
        List<SaleDetailResponseDto> sales = s.getSaleDetails()
                .stream()
                .map(SaleDetailMapper::mapToSaleDetailResponseDto)
                .toList();
        return SaleResponseDto.builder()
                .number(s.getNumber())
                .date(s.getDate())
                .total(s.getTotal())
                .paymentMethod(s.getPaymentMethod())
                .saleDetails(sales)
                .build();
    }

}
