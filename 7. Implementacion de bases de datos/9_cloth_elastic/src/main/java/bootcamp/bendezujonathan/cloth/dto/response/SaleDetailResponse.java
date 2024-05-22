package bootcamp.bendezujonathan.cloth.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailResponse {

    private String id;
    @JsonProperty("precio_individual")
    private double precioIndividual;
    private Integer cantidad;
    private ClothResponse cloth;
}
