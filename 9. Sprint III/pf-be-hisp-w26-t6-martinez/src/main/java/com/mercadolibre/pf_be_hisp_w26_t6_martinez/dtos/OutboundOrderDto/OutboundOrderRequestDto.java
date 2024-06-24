package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class OutboundOrderRequestDto {
    @NotNull(message = "El outbound_order no puede estar vacio")
    @Valid
    @JsonProperty("outbound_order")
    private OutboundOrderDto outboundOrderDto;
}
