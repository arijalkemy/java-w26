package com.bootcamp.vehiculo.dto;

import com.bootcamp.vehiculo.model.Siniestro;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VehiculoDTO {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("anio_fabricacion")
    private LocalDate anioFabricacion;

    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;

    private List<SiniestroDTO> siniestros;

}
