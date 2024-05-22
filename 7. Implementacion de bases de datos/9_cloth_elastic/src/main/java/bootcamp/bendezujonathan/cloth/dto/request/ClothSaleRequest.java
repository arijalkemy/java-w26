package bootcamp.bendezujonathan.cloth.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothSaleRequest {

    private  String id;
    private Integer cantidad;
}
