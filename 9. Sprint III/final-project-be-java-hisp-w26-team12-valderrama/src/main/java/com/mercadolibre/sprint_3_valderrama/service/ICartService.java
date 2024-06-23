package com.mercadolibre.sprint_3_valderrama.service;


import com.mercadolibre.sprint_3_valderrama.dto.request.CartDTO;

public interface ICartService {

    CartDTO getCart(Long idOrder);
}
