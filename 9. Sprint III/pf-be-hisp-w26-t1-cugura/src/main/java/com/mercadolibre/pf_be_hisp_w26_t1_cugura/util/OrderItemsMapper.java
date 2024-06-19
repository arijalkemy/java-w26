package com.mercadolibre.pf_be_hisp_w26_t1_cugura.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.OrderItem;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.PurchaseOrder;

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
