package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetailsDto {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("buyer_id")
    private Integer buyerId;
    @JsonProperty("order_status")
    private OrderStatusDto orderStatus;
    private List<ProductRequestDto> products;
}
