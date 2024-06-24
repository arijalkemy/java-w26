package com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchTransferDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutboundOrderDto {

    @NotNull(message = "The order number cannot be null")
    @JsonProperty("outbound_order_number")
    private Long orderNumber;

    @NotNull(message = "The warehouse destination cannot be null")
    @JsonProperty("warehouse_origin_code")
    private Integer warehouseOrigin;

    @NotNull(message = "The warehouse destination cannot be null")
    @JsonProperty("warehouse_destination_code")
    private Integer warehouseDestination;

    @NotNull(message = "The batches cannot be null")
    @Valid
    private List<BatchTransferDto> batches;


}
