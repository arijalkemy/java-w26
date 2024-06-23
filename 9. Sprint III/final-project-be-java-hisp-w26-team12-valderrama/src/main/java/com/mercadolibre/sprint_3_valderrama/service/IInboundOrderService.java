package com.mercadolibre.sprint_3_valderrama.service;


import com.mercadolibre.sprint_3_valderrama.dto.request.CartDTO;
import com.mercadolibre.sprint_3_valderrama.dto.request.InboundDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.CartWithErrorsResponseDTO;
import com.mercadolibre.sprint_3_valderrama.dto.response.InboundResponseDTO;

public interface IInboundOrderService {
    InboundResponseDTO registerInboundOrder(InboundDTO inboundDTO, Boolean isUpdate);

    CartWithErrorsResponseDTO createInBoundOrder(CartDTO cartDTO);


    CartWithErrorsResponseDTO updateInBoundOrder(CartDTO cartDTO, Long idOrder);
}
