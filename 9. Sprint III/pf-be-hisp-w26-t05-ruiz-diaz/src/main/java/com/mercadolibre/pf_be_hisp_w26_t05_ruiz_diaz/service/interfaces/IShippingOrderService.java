package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.ShippingOrderChangeStateRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response.ShippingOrderResponseDTO;

import java.util.List;

public interface IShippingOrderService {
    ShippingOrderResponseDTO generateShippingOrder(Integer idPurchaseOrder);
    List<ShippingOrderResponseDTO> getShippingOrdersPending();
    ShippingOrderResponseDTO updateStateShippingOrder(Integer idPurchaseOrder, ShippingOrderChangeStateRequestDTO state);
    ShippingOrderResponseDTO getShippingOrderById(Integer idShippingOrder);
}
