package com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ShippingOrderChangeStateRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ShippingOrderResponseDTO;

import java.util.List;

public interface IShippingOrderService {
    ShippingOrderResponseDTO generateShippingOrder(Integer idPurchaseOrder);
    List<ShippingOrderResponseDTO> getShippingOrdersPending();
    ShippingOrderResponseDTO updateStateShippingOrder(Integer idPurchaseOrder, ShippingOrderChangeStateRequestDTO state);
    ShippingOrderResponseDTO getShippingOrderById(Integer idShippingOrder);
}
