package com.mercadolibre.pf_be_hisp_w26_t01_coro.util;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.OrderItem;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.entity.User;

import java.util.List;

public class PurchaseOrderMapper {

    public static PurchaseOrder PurcharOrderMappingFromDto(PurchaseOrderDTO dto, User user){
        PurchaseOrder order = PurchaseOrder
                .builder()
                .date(dto.getDate())
                .user(user)
                .build();
        List<OrderItem> items = OrderItemsMapper.orderItemListMappingFromDto(dto.getProducts(),order);
        order.setOrderItems(items);
        return order;
    }

    public static PurchaseOrder newPurcharOrderMappingFromDto(Integer id,PurchaseOrderDTO dto, User user) {
        PurchaseOrder order = PurchaseOrderMapper.PurcharOrderMappingFromDto(dto,user);
        order.setId(id);
        return order;
    }
}
