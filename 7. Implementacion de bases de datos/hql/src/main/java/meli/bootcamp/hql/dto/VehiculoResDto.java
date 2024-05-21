package meli.bootcamp.hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;

    @JsonProperty("anio_fabricacion")
    private Integer anioFabricacion;

    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;
}
