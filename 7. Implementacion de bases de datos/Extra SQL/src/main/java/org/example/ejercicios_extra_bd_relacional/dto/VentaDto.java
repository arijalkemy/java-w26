package org.example.ejercicios_extra_bd_relacional.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link org.example.ejercicios_extra_bd_relacional.model.Venta}
 */
@Data
@NoArgsConstructor
public class VentaDto implements Serializable {
    int numero;
    LocalDate fecha;
    BigDecimal total;
    String medioDePago;
    List<PrendaDto> prendas;
}