package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.mapper;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ShippingOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.ShippingOrder;

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
