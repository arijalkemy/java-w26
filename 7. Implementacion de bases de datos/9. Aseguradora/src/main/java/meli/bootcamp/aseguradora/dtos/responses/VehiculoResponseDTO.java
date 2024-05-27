package meli.bootcamp.aseguradora.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import meli.bootcamp.aseguradora.models.Siniestro;
import lombok.Data;

import java.util.List;

@Data
public class VehiculoResponseDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("anio_fabricacion")
    private Integer anioFabricacion;
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;
    List<Siniestro> siniestros;
}
