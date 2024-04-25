package org.example.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestPostPromoDTO extends RequestPostDTO {
    @JsonProperty("has_promo")
    @NotNull
    private boolean hasPromo;
    @NotNull
    @Min(1)
    private double discount;
}
