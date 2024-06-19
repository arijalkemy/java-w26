package com.mercadolibre.sprint_3_team_12_malacara.projections;


import lombok.Builder;

@Builder
public record WarehouseProjection (Long id, Long totalQuantity){}
