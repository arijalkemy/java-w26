package com.mercadolibre.sprint_3_team_12.service;


import com.mercadolibre.sprint_3_team_12.dto.request.CartDTO;

public interface ICartService {

    CartDTO getCart(Long idOrder);
}
