package bootcamp.bendezujonathan.cloth.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothRequest {

    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer cantidad;
    private String talle;
    @JsonProperty("precio_venta")
    private Double precioVenta;


}
