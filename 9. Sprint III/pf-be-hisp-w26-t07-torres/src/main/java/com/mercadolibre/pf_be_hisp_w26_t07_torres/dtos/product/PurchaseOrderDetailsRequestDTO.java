package com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.order.OrderStatusRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class PurchaseOrderDetailsRequestDTO {

    @JsonProperty("date")
    @NotNull(message = "Date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty("buyer_id")
    @NotNull(message = "Buyer ID is required")
    @Positive(message = "Buyer ID must be positive")
    private Integer buyerId;

    @JsonProperty("order_status")
    @Valid
    @NotNull(message = "Order status is required")
    private OrderStatusRequestDTO orderStatus;

    @JsonProperty("products")
    @Valid
    @NotNull(message = "Products are required")
    private List<ProductPurchaseOrderRequestDto> products;

}
