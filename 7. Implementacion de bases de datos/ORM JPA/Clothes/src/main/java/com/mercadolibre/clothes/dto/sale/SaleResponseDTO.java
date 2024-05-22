package com.mercadolibre.clothes.dto.sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaleResponseDTO implements Serializable {
    private Long number;
    private String date;
    private Double total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("cloth_list")
    private Set<ClothResponseDTO> clothList;
}
