package org.responseentity.productos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private String id;
    private String nombre;
    private String tipo;
    private Long precioVenta;
    private Long precioCosto;
    private Integer cantidadDisponible;
}
