package org.example.ejercicios_extra_elasticsearch.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link org.example.ejercicios_extra_elasticsearch.model.Venta}
 */
@Data
@NoArgsConstructor
public class VentaDto implements Serializable {
    String numero;
    LocalDate fecha;
    BigDecimal total;
    String medioDePago;
    List<PrendaDto> prendas;
}