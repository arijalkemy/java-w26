package com.mercadolibre.sprint3_individual_perez.service;


import com.mercadolibre.sprint3_individual_perez.dto.request.CartDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.InboundDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.CartWithErrorsResponseDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.InboundListResponseDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.InboundResponseDTO;

public interface IInboundOrderService {
    InboundResponseDTO registerInboundOrder(InboundDTO inboundDTO, Boolean isUpdate);
  
    CartWithErrorsResponseDTO createInBoundOrder(CartDTO cartDTO);

    CartWithErrorsResponseDTO updateInBoundOrder(CartDTO cartDTO, Long idOrder);

    InboundListResponseDTO getInboundOrders();
}
