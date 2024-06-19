package com.mercadolibre.sprint3_individual_perez.projections;


import lombok.Builder;

@Builder
public record WarehouseProjection (Long id, Long totalQuantity){}
