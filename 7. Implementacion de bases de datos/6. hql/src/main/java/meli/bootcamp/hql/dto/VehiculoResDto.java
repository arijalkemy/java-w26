package meli.bootcamp.hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResDto {
    @NotNull(message = "El id es requerido")
    private Long id;

    @NotNull(message = "La patente es requerida")
    private String patente;

    @NotNull(message = "La marca es requerida")
    private String marca;

    @NotNull(message = "El modelo es requerido")
    private String modelo;

    @JsonProperty("anio_fabricacion")
    @NotNull(message = "El año de fabricación es requerido")
    private Integer anioFabricacion;

    @JsonProperty("cantidad_ruedas")
    @NotNull(message = "La cantidad de ruedas es requerida")
    @Min(value = 1, message = "La cantidad de ruedas debe ser mayor a 0")
    private Integer cantidadRuedas;
}
