package com.mercadolibre.clothes.dto.sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.clothes.dto.cloth.ClothRequestDTO;
import com.mercadolibre.clothes.dto.cloth.ClothResponseDTO;
import com.mercadolibre.clothes.model.Cloth;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SaleRequestDTO implements Serializable {
    private String date;
    private Double total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("cloth_list")
    private Set<Long> clothList;
}
