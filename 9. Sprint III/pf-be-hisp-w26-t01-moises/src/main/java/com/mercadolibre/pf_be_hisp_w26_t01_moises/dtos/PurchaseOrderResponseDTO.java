package com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PurchaseOrderResponseDTO {
    @JsonProperty("id_purchase_order")
    Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate date;
    @JsonProperty("order_status")
    OrderStatusDTO orderStatus;
    List<ProductPurchaseResponseDto> products;
    @JsonProperty("total_price")
    Double totalPrice;
}
