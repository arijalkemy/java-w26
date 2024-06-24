package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.InboundOrderDto.InboundOrderRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BatchInsertionRequestDto implements Serializable {

    @NotNull(message = "El inbound_order no puede estar vacio")
    @Valid
    @JsonProperty("inbound_order")
    private InboundOrderRequestDto inboundOrderRequestDto;
}
