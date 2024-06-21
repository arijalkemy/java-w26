package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter @Getter
public class ProductOrderRequestDTO {
        @JsonProperty("product_id")
        @NotNull(message = "Product cannot be null")
        private Long product;
        @Positive(message = "Quantity must be greater than 0")
        @NotNull(message = "Quantity cannot be null")
        private Integer quantity;
}

