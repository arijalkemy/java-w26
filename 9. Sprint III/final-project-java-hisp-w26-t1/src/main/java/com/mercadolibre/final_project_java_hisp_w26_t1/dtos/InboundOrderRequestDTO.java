package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class InboundOrderRequestDTO {
    @JsonProperty("inbound_order")
    private InboundOrderDto inboundOrderDto;

}
