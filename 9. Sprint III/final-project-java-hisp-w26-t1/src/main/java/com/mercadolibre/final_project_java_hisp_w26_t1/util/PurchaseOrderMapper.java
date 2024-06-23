package com.mercadolibre.final_project_java_hisp_w26_t1.util;

import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.PurchaseOrderDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.OrderItem;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.PurchaseOrder;
import com.mercadolibre.final_project_java_hisp_w26_t1.entity.User;

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
