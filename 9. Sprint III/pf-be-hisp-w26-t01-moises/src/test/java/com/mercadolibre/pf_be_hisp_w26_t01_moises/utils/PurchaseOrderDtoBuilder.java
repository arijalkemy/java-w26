package com.mercadolibre.pf_be_hisp_w26_t01_moises.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.OrderStatusDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderDtoBuilder {
    private PurchaseOrderDtoBuilder() {
    }

    public static PurchaseOrderDTO getPurchaseOrderDto() {
        return new PurchaseOrderDTO(
                LocalDate.of(2024, 1, 1),
                1,
                new OrderStatusDTO("CARRITO"),
                List.of(
                        new ProductPurchaseDTO(1, 5)
                ));
    }

    public static PurchaseOrderResponseDTO getPurchaseOrderResponseDto() {
        return PurchaseOrderResponseDTO.builder()
                .id(1)
                .date(LocalDate.of(2024, 1, 1))
                .totalPrice(5.0)
                .products(List.of(
                        ProductPurchaseDtoBuilder.getResponseDto()
                ))
                .orderStatus(new OrderStatusDTO("CART"))
                .build();
    }
    public static PurchaseOrderResponseDTO getPurchaseOrderResponseDto(LocalDate date) {
        return PurchaseOrderResponseDTO.builder()
                .id(1)
                .date(date)
                .totalPrice(5.0)
                .products(List.of(
                        ProductPurchaseDtoBuilder.getResponseDto()
                ))
                .orderStatus(new OrderStatusDTO("CART"))
                .build();
    }
    public static PurchaseOrderResponseDTO getPurchaseOrderResponseDto(double price, int quantity) {
        return PurchaseOrderResponseDTO.builder()
                .id(1)
                .date(LocalDate.of(2024, 1, 1))
                .totalPrice(price * quantity)
                .products(List.of(
                        ProductPurchaseDtoBuilder.getResponseDto(quantity)
                ))
                .orderStatus(new OrderStatusDTO("CART"))
                .build();
    }
    public static List<PurchaseOrderResponseDTO> getResponseListWithDifferentDatesOrdered() {
        return List.of(
                getPurchaseOrderResponseDto(LocalDate.of(2023,5,12)),
                getPurchaseOrderResponseDto(LocalDate.of(2024,1,11)),
                getPurchaseOrderResponseDto(LocalDate.of(2025,2,13))
                );
    }
    public static List<PurchaseOrderResponseDTO> getResponseListWithDifferentPricesOrdered() {
        return List.of(
                getPurchaseOrderResponseDto(20.0,2),
                getPurchaseOrderResponseDto(50.0,3),
                getPurchaseOrderResponseDto(95.0,5)
        );
    }
}
