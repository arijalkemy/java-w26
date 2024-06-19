package com.mercadolibre.sprint_3_team_12_malacara.service;


import com.mercadolibre.sprint_3_team_12_malacara.dto.request.CartDTO;

public interface ICartService {

    CartDTO getCart(Long idOrder);
}
