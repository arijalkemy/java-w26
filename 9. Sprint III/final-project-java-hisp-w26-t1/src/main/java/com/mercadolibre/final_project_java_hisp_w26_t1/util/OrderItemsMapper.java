package com.mercadolibre.final_project_java_hisp_w26_t1.util;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.ProductPurchaseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.OrderItem;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.PurchaseOrder;

import java.util.List;

public class OrderItemsMapper {
    public static OrderItem orderItemMappingFromDto(ProductPurchaseDTO dto,PurchaseOrder order){
        return OrderItem
                .builder()
                .product(ProductMapper.productMappingFromProductPurchaseDto(dto))
                .quantity(dto.getQuantity())
                .build();
    }

    public static List<OrderItem> orderItemListMappingFromDto(List<ProductPurchaseDTO> listDto, PurchaseOrder order){
        return listDto
                .stream()
                .map(oi -> orderItemMappingFromDto(oi,order))
                .toList();
    }
}
