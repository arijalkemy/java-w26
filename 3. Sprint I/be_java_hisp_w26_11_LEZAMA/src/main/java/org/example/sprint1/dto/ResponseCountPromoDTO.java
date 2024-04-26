package org.example.sprint1.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCountPromoDTO {
    @JsonProperty("user_id")
    @NotNull
    @Positive
    private int userId;
    @JsonProperty("user_name")
    @NotNull
    private String userName;
    @JsonProperty("promo_products_count")
    @NotNull
    @Positive
    private int promoProductsCount;
}
