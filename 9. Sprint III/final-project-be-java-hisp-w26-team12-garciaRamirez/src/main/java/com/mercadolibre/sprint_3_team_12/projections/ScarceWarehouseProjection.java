package com.mercadolibre.sprint_3_team_12.projections;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
public record ScarceWarehouseProjection(Long warehouseID, Long productID, Long productQuantity){}
