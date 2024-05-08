package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("product_name")
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}

/*public class ProductDTO {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}*/
