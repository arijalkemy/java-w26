package com.mercadolibre.sprint_3_team_12_malacara.service;


import com.mercadolibre.sprint_3_team_12_malacara.dto.request.CartDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.request.InboundDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.CartWithErrorsResponseDTO;
import com.mercadolibre.sprint_3_team_12_malacara.dto.response.InboundResponseDTO;

public interface IInboundOrderService {
    InboundResponseDTO registerInboundOrder(InboundDTO inboundDTO, Boolean isUpdate);
  
    CartWithErrorsResponseDTO createInBoundOrder(CartDTO cartDTO);


    CartWithErrorsResponseDTO updateInBoundOrder(CartDTO cartDTO, Long idOrder);
}
