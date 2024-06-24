package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductPurchaseOrderDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderDto implements Serializable{

    @NotEmpty(message = "La fecha de orden no puede estar vacia")
    @Pattern(regexp = "([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4}",
            message = "El formato de date debe ser dd-mm-yyyy")
    private String date;

    @NotNull(message = "El buyer_id no puede estar vacío")
    @Positive(message = "El buyer_id no debe ser negativo")
    @JsonProperty("buyer_id")
    private Long buyerId;

    @Valid
    @NotNull(message = "Debe tener al menos un order_status")
    @JsonProperty("order_status")
    private OrderStatusDto orderStatusDto;

    @Size(min=1, message = "Debe tener al menos un producto")
    @Valid
    private List<ProductPurchaseOrderDto> products;
}
