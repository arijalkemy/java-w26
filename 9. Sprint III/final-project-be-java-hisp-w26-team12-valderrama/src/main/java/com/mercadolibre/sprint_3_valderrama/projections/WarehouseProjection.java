package com.mercadolibre.sprint_3_valderrama.projections;


import lombok.Builder;

@Builder
public record WarehouseProjection (Long id, Long totalQuantity){}
