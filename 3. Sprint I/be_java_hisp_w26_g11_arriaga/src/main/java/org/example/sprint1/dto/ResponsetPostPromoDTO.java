package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponsetPostPromoDTO extends RequestPostDTO{

    @JsonProperty("has_promo")
     private boolean haspromo;

    private double discount;
}
