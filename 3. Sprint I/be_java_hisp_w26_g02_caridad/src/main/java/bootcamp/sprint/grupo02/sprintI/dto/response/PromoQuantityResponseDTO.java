package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoQuantityResponseDTO {
    @JsonUnwrapped
    private UserResponseDTO userResponseDTO;
    @JsonProperty("promo_products_count")
    private int promoProductsCount;
}
