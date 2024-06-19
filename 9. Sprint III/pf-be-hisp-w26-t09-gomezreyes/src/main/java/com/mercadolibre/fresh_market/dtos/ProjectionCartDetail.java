package com.mercadolibre.fresh_market.dtos;

import com.mercadolibre.fresh_market.model.ShoppingCartKey;

import lombok.Builder;

@Builder
public record ProjectionCartDetail(String description, ShoppingCartKey id, Integer quantity, ProjectionProduct product) {
}
