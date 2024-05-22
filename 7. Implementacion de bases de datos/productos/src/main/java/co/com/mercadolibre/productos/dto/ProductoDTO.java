package co.com.mercadolibre.productos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductoDTO {

    private String id;
    private String nombre;
    private String tipo;
    private Double precioDeVenta;
    private Double precioDeCosto;
    private Integer cantidadDisponible;
}
