package com.mercadolibre.pf_be_hisp_w26_t01_moises.util;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.OrderStatusDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.OrderItem;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.PurchaseOrder;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.User;

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
    public static PurchaseOrderResponseDTO mapToResponseDto(PurchaseOrder order) {
        List<ProductPurchaseResponseDto> products = order.getOrderItems().stream()
                .map((orderItem) ->
                        ProductMapper.mapToProductPurchaseResponseDto(
                                orderItem.getProduct(),
                                orderItem.getQuantity()
                        ))
                .toList();
        return PurchaseOrderResponseDTO.builder()
                .id(order.getId())
                .orderStatus(new OrderStatusDTO("CART"))
                .products(products)
                .date(order.getDate())
                .totalPrice(calculateTotalPrice(order))
                .build();
    }
    private static Double calculateTotalPrice(PurchaseOrder order) {
        return order.getOrderItems().stream()
                .mapToDouble(orderItem -> orderItem.getQuantity() * orderItem.getProduct().getPrice())
                .sum();
    }
}
