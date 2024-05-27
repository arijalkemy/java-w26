package meli.bootcamp.jewelry.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelResponseDTO {
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    @JsonProperty("has_stone")
    private Boolean hasStone;
    @JsonProperty("is_for_sale")
    private Boolean isForSale;
}
