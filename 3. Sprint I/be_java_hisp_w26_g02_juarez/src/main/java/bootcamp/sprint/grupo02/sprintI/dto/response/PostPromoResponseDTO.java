package bootcamp.sprint.grupo02.sprintI.dto.response;

import bootcamp.sprint.grupo02.sprintI.dto.request.ProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    double price;
    @JsonProperty("has_promo")
    boolean hasPromo;
    double discount;
}
