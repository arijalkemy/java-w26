package com.mercadolibre.sprint_3_team_12.service;


import com.mercadolibre.sprint_3_team_12.dto.request.CartDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.InboundOrderDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.InboundDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.CartResponseDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.CartWithErrorsResponseDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.InboundResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface IInboundOrderService {
    InboundResponseDTO registerInboundOrder(InboundDTO inboundDTO, Boolean isUpdate);
  
    CartWithErrorsResponseDTO createInBoundOrder(CartDTO cartDTO);


    CartWithErrorsResponseDTO updateInBoundOrder(CartDTO cartDTO, Long idOrder);
}
