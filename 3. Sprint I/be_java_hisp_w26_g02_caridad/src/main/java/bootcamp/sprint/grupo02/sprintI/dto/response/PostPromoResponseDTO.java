package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
    private LocalDate date;
    private ProductResponseDTO product;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
