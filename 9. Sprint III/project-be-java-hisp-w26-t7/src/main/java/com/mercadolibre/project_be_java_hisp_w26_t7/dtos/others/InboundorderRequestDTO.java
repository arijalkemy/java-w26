package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.order.OrderRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InboundorderRequestDTO {

    @Valid
    @NotNull(message = "Inbound order details are required")
    @JsonProperty("inbound_order")
    private OrderRequestDTO inboundOrder;

}
