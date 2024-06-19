package com.mercadolibre.sprint3_individual_perez.service;


import com.mercadolibre.sprint3_individual_perez.dto.request.CartDTO;

public interface ICartService {

    CartDTO getCart(Long idOrder);
}
