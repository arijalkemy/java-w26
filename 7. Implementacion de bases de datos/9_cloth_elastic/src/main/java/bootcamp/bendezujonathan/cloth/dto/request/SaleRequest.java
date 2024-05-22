package bootcamp.bendezujonathan.cloth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {

    @JsonProperty("medio_de_pago")
    private String medioDePago;
    private List<ClothSaleRequest> prendas;
}
