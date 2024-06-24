package com.mercadolibre.final_project_java_hisp_w26_t6.mappers;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseWithWarningsDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseWithoutWarningsDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.Product;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.PurchaseOrder;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.PurchaseOrderDetail;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.User;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.EnumChecker;
import com.mercadolibre.final_project_java_hisp_w26_t6.util.OrderType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PurchaseOrderMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static PurchaseOrderProductResponseDto purchaseOrderDetailToPurchaseOrderProductResponseDto
            (PurchaseOrderDetail purchaseOrderDetail) {
        return PurchaseOrderProductResponseDto.builder()
                .productId(purchaseOrderDetail.getProduct().getId())
                .name(purchaseOrderDetail.getProduct().getName())
                .quantity(purchaseOrderDetail.getQuantity())
                .build();
    }

    public static PurchaseOrderProductsResponseDto buildPurchaseOrderProductsResponseDto
            (List<PurchaseOrderProductResponseDto> purchaseOrderProductResponseDtos) {
        return PurchaseOrderProductsResponseDto.builder().products(purchaseOrderProductResponseDtos).build();
    }

    public static PurchaseOrderPostResponseWithWarningsDto buildPurchaseOrderPostResponseWithWarningsDto
            (Double purchaseOrderPrice, List<String> warnings){
        return PurchaseOrderPostResponseWithWarningsDto.builder()
                .totalPrice(purchaseOrderPrice)
                .warnings(warnings)
                .build();
    }

    public static PurchaseOrderPostResponseWithoutWarningsDto buildPurchaseOrderPostResponseWithoutWarningsDto
            (Double purchaseOrderPrice){
        return PurchaseOrderPostResponseWithoutWarningsDto.builder()
                .totalPrice(purchaseOrderPrice)
                .build();
    }

    public static PurchaseOrder toPurchaseOrder(User buyer, List<PurchaseOrderDetail> details,
                                                PurchaseOrderDto purchaseOrderDto) {

        LocalDate date = LocalDate.parse(purchaseOrderDto.getDate(), formatter);

        EnumChecker.isValidEnum(OrderType.class, purchaseOrderDto.getOrderStatusDto().getStatusCode(),
                "Invalid order type: " + purchaseOrderDto.getOrderStatusDto().getStatusCode());

        return PurchaseOrder.builder()
                .purchaseOrderDetails(details)
                .buyer(buyer)
                .date(date)
                .type(OrderType.valueOf(purchaseOrderDto.getOrderStatusDto().getStatusCode()))
                .build();
    }

    public static PurchaseOrderDetail toPurchaseOrderDetails(Product product, Integer quantity){
        return PurchaseOrderDetail.builder()
                .product(product)
                .quantity(quantity).build();
    }
}
