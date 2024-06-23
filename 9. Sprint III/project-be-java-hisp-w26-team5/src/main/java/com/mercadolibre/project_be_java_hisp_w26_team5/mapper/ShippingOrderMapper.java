package com.mercadolibre.project_be_java_hisp_w26_team5.mapper;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ShippingOrderResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.ShippingOrder;

public class ShippingOrderMapper {

    public static ShippingOrderResponseDTO toResponseDTO(ShippingOrder shippingOrder) {
        ShippingOrderResponseDTO shippingOrderResponseDTO = new ShippingOrderResponseDTO();
        shippingOrderResponseDTO.setId(shippingOrder.getId());
        shippingOrderResponseDTO.setIdPurchaseOrder(shippingOrder.getPurchaseOrder().getId());
        shippingOrderResponseDTO.setIdSourceWarehouse(shippingOrder.getSourceWarehouse().getId());
        shippingOrderResponseDTO.setIdDestination(shippingOrder.getBuyerLocation().getId());
        shippingOrderResponseDTO.setDateCreated(shippingOrder.getDateCreated().toString());
        shippingOrderResponseDTO.setState(shippingOrder.getState().toString());
        shippingOrderResponseDTO.setDateLastUpdated(shippingOrder.getDateUpdated().toString());
        return shippingOrderResponseDTO;
    }
}
