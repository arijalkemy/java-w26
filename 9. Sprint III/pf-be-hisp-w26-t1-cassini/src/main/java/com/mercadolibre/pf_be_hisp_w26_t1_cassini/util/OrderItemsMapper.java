package com.mercadolibre.pf_be_hisp_w26_t1_cassini.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductPurchaseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.OrderItem;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.PurchaseOrder;

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
