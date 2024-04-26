package bootcamp.sprint.grupo02.sprintI.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoDTO {
    @JsonProperty("user_id")
   private int userId;
   private String date;
   private ProductDTO product;
   private int category;
   double price;
    @JsonProperty("has_promo")
   boolean hasPromo;
   double discount;

}
