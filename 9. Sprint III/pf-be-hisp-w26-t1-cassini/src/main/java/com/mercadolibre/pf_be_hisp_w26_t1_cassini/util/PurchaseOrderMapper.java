package com.mercadolibre.pf_be_hisp_w26_t1_cassini.util;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.OrderItem;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.User;

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
