package org.example.ejercicios_extra_bd_relacional.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link org.example.ejercicios_extra_bd_relacional.model.Venta}
 */
@Value
public class VentaRequestDto implements Serializable {
    LocalDate fecha;
    @JsonProperty("medio_de_pago")
    String medioDePago;
    @JsonProperty("id_prendas")
    List<Long> idPrendas;
}