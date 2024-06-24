package com.mercadolibre.project_java_w26_team13.service;

import com.mercadolibre.project_java_w26_team13.dtos.CartRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.CartResponseDto;

public interface ICartService {
    CartResponseDto createCart(
            String authorizationHeader,
            CartRequestDto cartRequestDto
    );

    CartResponseDto updateCart(String authorizationHeader, Long orderId, CartRequestDto cartRequestDto);

    CartRequestDto searchCart(String authorizationHeader, Long orderId);
}
